package com.xiaomaoguai.gecco.bookcrawler;

import java.util.List;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
@Gecco(matchUrl = "http://{type}.qidian.com/{other}", pipelines = { "consolePipeline", "indexPipeline" })
public class Index_model  implements HtmlBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Request
	private HttpRequest request;
	@Href
	@HtmlField(cssPath = "a")
	private List<String> urlsList;
	public HttpRequest getRequest() {
		return request;
	}
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	public List<String> getUrlsList() {
		return urlsList;
	}
	public void setUrlsList(List<String> urlsList) {
		this.urlsList = urlsList;
	}
	@Override
	public String toString() {
		return "Index_model [request=" + request + ", urlsList=" + urlsList
				+ "]";
	}
	
	
	
	
	
}
