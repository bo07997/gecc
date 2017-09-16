package com.gecco.atest.filterimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.gecco.atest.Crawurl;
import com.gecco.atest.filter.FilterInter;
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
public class BookUrls implements FilterInter {
	 String pattern = "http://book.qidian.com/info/\\d+";
	@Override
	public List<Crawurl> filterBookUrls(List<Crawurl> urls) {
		List<Crawurl> newUrls = new ArrayList<Crawurl>(); 
		  for (Crawurl url : urls) {
		         if(Pattern.matches(pattern, url.getUrl())){
		        	newUrls.add(url);
		         }
		      }
		      return newUrls;
	}

}
