package com.gecco.atest;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

public class Crawurl  implements HtmlBean{
	private static final long serialVersionUID = 1L;


	@Href
	@HtmlField(cssPath="a")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Crawurl [url=" + url + "]";
	}
	
	
}
