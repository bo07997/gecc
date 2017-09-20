package com.xiaomaoguai.gecco.service.myservice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaomaoguai.gecco.mapper.bookInfoMapper;
import com.xiaomaoguai.gecco.service.myservice.BookInfoService;
import com.xiaomaoguai.gecco.testcrawler.bookInfo;
import com.yyfq.commons.lang.idgenerator.IdUtils;
@Service
public class BookInfoServiceimpl implements BookInfoService {
	Logger Logger = LoggerFactory.getLogger(BookInfoServiceimpl.class);
	@Autowired
	private bookInfoMapper bookInfoMapper;
	

	public void setBookInfoMapper(bookInfoMapper bookInfoMapper) {
		this.bookInfoMapper = bookInfoMapper;
	}

	public bookInfoMapper getBookInfoMapper() {
		return bookInfoMapper;
	}

	@Override
	public int insertBookInfo(bookInfo book) {
		if(book==null){
			return -1;
		}
		//生成16位ID
		book.setBookId(IdUtils.genStringId());
		int result = 0;
		try {
			//简介超出
			if(book.getProductInstruction().length()>255){
				book.setProductInstruction(book.getProductInstruction().substring(0, 250)+"....");
			}
			result = bookInfoMapper.insertSelective(book);
		
			System.out.println(result+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Logger.error("【书籍信息】插入错误!");
		}
		return result;
	}
  
}
