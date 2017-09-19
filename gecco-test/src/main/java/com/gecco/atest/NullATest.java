package com.gecco.atest;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://book.qidian.com/info/{id}", timeout = 60 * 1000, pipelines = { "consolePipeline"
		, "bookPipeline"
})
public class NullATest implements HtmlBean {

	private static final long serialVersionUID = -139677387757121011L;

	@HtmlField(cssPath = "body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info")
	private List<AContent> aList;
	
	@RequestParameter
	private String id;
	
	@HtmlField(cssPath="a")
	private List<Crawurl> urlList;
	
	@Request
	private HttpRequest request;
	
	public List<AContent> getaList() {
		return aList;
	}

	public void setaList(List<AContent> aList) {
		this.aList = aList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Crawurl> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<Crawurl> urlList) {
		this.urlList = urlList;
	}

public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public static void main(String[] args) {
		
		GeccoEngine.create().classpath("com.gecco.atest").thread(1)
				.interval(2000).start("http://book.qidian.com/info/1005244325").loop(false)
				.run();
	}

@Override
	public String toString() {
		return "NullATest [aList=" + aList + ", id=" + id + ", urlList="
				+ urlList + "]";
	}



	

}
