package com.xiaomaoguai.gecco.mapper.mymapper;

import org.springframework.stereotype.Repository;

import com.xiaomaoguai.gecco.testcrawler.bookInfo;



@Repository
public interface bookInfoMapper22 {
    int deleteByPrimaryKey(String bookId);

    int insert(bookInfo record);

    int insertSelective(bookInfo record);

    bookInfo selectByPrimaryKey(String bookId);

    int updateByPrimaryKeySelective(bookInfo record);

    int updateByPrimaryKey(bookInfo record);
}