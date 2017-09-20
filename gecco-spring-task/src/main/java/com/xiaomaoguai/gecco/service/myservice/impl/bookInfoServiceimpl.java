package com.xiaomaoguai.gecco.service.myservice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.xiaomaoguai.gecco.mapper.mymapper.bookInfoMapper;
import com.xiaomaoguai.gecco.service.myservice.bookInfoService;
import com.xiaomaoguai.gecco.testcrawler.bookInfo;
import com.yyfq.commons.lang.idgenerator.IdUtils;

public class bookInfoServiceimpl implements bookInfoService {
	Logger Logger = LoggerFactory.getLogger(bookInfoServiceimpl.class);
	@Autowired
	private bookInfoMapper bookIndoMapper;
	@Override
	public int insertBookInfo(bookInfo book) {
		if(book==null){
			return -1;
		}
		//生成16位ID
		book.setBookId(IdUtils.genStringId());
		int result = 0;
		try {
			result = bookIndoMapper.insertSelective(book);
		} catch (Exception e) {
			Logger.error("【书籍信息】插入错误!");
		}
		return result;
	}
  
}
