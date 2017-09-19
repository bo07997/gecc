package com.gecco.atest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.gecco.atest.filter.FilterInter;
import com.gecco.atest.filterimpl.BookUrls;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName("consolePipeline")
public class ConsolePipeline implements Pipeline<NullATest> {

    @Override
    public void process(NullATest aTest) {
    	System.out.println();
    	FilterInter fInter =new BookUrls();
    /*	List<Crawurl> newUrls =fInter.filterBookUrls(aTest.getUrlList());
    	if(newUrls!=null){
    		for(Crawurl url:newUrls){
    			SchedulerContext.into(aTest.getRequest().subRequest(url.getUrl()));
    		}
    	}*/
    	File file = new File("D://a.txt");
    	
    		
    	
    	// 第2步、通过子类实例化父类对象
    			Writer out = null ;	// 准备好一个输出的对象
    			try {
					out = new FileWriter(file,true)  ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	// 通过对象多态性，进行实例化
    			// 第3步、进行写操作
    		System.out.println(aTest.toString());
    			try {
					out.write(aTest.toString()) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 将内容输出，保存文件
    		finally{
    			// 第4步、关闭输出流
    			try {
					out.close() ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 关闭输出流
    		}
    }
    
}
