package com.xiaomaoguai.gecco.testcrawler.filter.filterimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * 
 * 过滤器:过滤起点书籍页面urls
 * 
 * <p>
 * <a href="BookUrls.java"><i>View Source</i></a>
 * 
 * @author dianbo
 * @version 1.0
 * @since 1.0
 */
public class BookUrls {
	//书籍过滤
	 final static String book_pattern = "http://book.qidian.com/info/\\d+";
		//起点过滤
	 final static String qidian_pattern = "http://book.qidian.com/info/\\d+";
	public static List<String> filterBookUrls(List<String> urls) {
		List<String> newUrls = new ArrayList<String>(); 
		  for (String url : urls) {
		         if(Pattern.matches(book_pattern, url)){
		        	newUrls.add(url);
		         }
		      }
		      return newUrls;
	}
	public static List<String> filterBookUrl_qidian(List<String> urls) {
		List<String> newUrls = new ArrayList<String>(); 
		  for (String url : urls) {
		         if(Pattern.matches(qidian_pattern, url)){
		        	newUrls.add(url);
		         }
		      }
		      return newUrls;
	}

}
