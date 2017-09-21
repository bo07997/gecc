package com.xiaomaoguai.gecco.mapper;

import org.springframework.stereotype.Repository;

import com.xiaomaoguai.gecco.testcrawler.bookInfo;



public interface bookInfoMapper {
    int deleteByPrimaryKey(String bookId);

    int insert(bookInfo record);

    int insertSelective(bookInfo record);

    bookInfo selectByPrimaryKey(String bookId);

    int updateByPrimaryKeySelective(bookInfo record);

    int updateByPrimaryKey(bookInfo record);
}