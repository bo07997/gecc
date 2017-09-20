package com.xiaomaoguai.gecco.testcrawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.xiaomaoguai.gecco.common.utils.SpringContextUtil;
import com.xiaomaoguai.gecco.service.myservice.BookInfoService;
import com.xiaomaoguai.gecco.testcrawler.common.MyAjax;
import com.xiaomaoguai.gecco.testcrawler.common.filter.BookUrls;
import com.xiaomaoguai.gecco.testcrawler.redis.RedisUtil;

/**
 * 
 * 
 * 
 * <p>
 * <a href="BookPip.java"><i>View Source</i></a>
 * 
 * @author dianbo
 * @version 1.0
 * @since 1.0
 */
@PipelineName("bookPipeline")
@Service
public class BookPip implements Pipeline<bookInfo> {
	Logger Logger = LoggerFactory.getLogger(BookPip.class);
	private static Jedis Jedis = RedisUtil.getJedis();

	@Override
	public void process(bookInfo bean) {
		BookInfoService bookInfoService = SpringContextUtil.getBean("bookInfoServiceimpl");
		/*
		 * AJAX请求部分,后期改造结构
		 */
		// null 判断
		String url = "http://book.qidian.com/ajax/comment/index?_csrfToken=e7LIJjWalES4KWNJYvPwwyRZ1PTvOiVWd4W0Gpbm&bookId="
				+ "" + bean.getQidianId();
		String strs = MyAjax.sendGet(url);// {"data":{"rate":7.5,"userCount":181,
		@SuppressWarnings("unused")
		String result = "";
		String regEx = "rate\":(.*?),";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m = pattern.matcher(strs);
		if (m.find()) {
			Logger.info("-------------MATCH------------------");
			bean.setBooRank(m.group(1));
		} else {
			Logger.info("-------------NO MATCH------------------");
		}
		/*
		 * 过滤器部分,过滤非起点urls
		 */
		List<String> urls = BookUrls.filterBookUrls(bean.getUrls());
		if (urls != null) {
			bean.setUrls(urls);
		}
		/*
		 * redis去重
		 */
		synchronized (this) {
			if (urls != null) {
				for (String temp_url : urls) {
					if (Jedis.get(temp_url) == null) {

						// 加入缓存
						Jedis.set(temp_url, "1");
						// 加入爬取队列
						SchedulerContext.into(bean.getRequest().subRequest(
								temp_url));
					}
				}
			}
		}

		/*
		 * 业务部分
		 */

		File file = new File("D://a.txt");
		// 第2步、通过子类实例化父类对象
		Writer out = null; // 准备好一个输出的对象
		try {
			out = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 通过对象多态性，进行实例化
		// 第3步、进行写操作
		System.out.println(bean.toString());
		synchronized (this) {
			try {

				out.write(bean.toString());
				out.write("\r\n");

			} catch (IOException e) {
				e.printStackTrace();
			}// 将内容输出，保存文件
			finally {
				// 第4步、关闭输出流
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 关闭输出流
			}
		}
		/*
		 * 写入数据库
		 */
		
			int a = bookInfoService.insertBookInfo(bean);
	


	}

}
