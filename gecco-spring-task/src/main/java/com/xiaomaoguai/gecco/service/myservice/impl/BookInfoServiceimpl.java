package com.xiaomaoguai.gecco.service.myservice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaomaoguai.gecco.mapper.bookInfoMapper;
import com.xiaomaoguai.gecco.service.myservice.BookInfoService;
import com.xiaomaoguai.gecco.testcrawler.bookInfo;
import com.yyfq.commons.lang.idgenerator.IdUtils;
@Service("bookInfoService")
public class BookInfoServiceimpl implements BookInfoService {
	Logger Logger = LoggerFactory.getLogger(BookInfoServiceimpl.class);
	@Autowired
	private bookInfoMapper bookInfoMapper;
	@Override
	public int insertBookInfo(bookInfo book) {
		if(book==null){
			return -1;
		}
		//生成16位ID
		book.setBookId(IdUtils.genStringId());
		int result = 0;
		try {
			result = bookInfoMapper.insertSelective(book);
		} catch (Exception e) {
			Logger.error("【书籍信息】插入错误!");
		}
		return result;
	}
  
}
