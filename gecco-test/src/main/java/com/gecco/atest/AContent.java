package com.gecco.atest;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class AContent implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Text
	@HtmlField(cssPath="body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > p:nth-child(4) > em:nth-child(1)")
	private String wordCount;

	
	@HtmlField(cssPath="body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > h1 > em")
	private String title;

	@HtmlField(cssPath="body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > p.intro")
	private String instrouction;

	public String getWordCount() {
		return wordCount;
	}

	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstrouction() {
		return instrouction;
	}

	public void setInstrouction(String instrouction) {
		this.instrouction = instrouction;
	}

	@Override
	public String toString() {
		return "AContent [wordCount=" + wordCount + ", title=" + title
				+ ", instrouction=" + instrouction + "]";
	}



}
