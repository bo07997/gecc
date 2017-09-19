package com.xiaomaoguai.gecco.testcrawler;

import java.util.List;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://book.qidian.com/info/{id}", pipelines = { "consolePipeline", "bookPipeline" })
public class Book implements HtmlBean{

	private static final long serialVersionUID = 1L;
	
	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String id;
	
	@HtmlField(cssPath = "body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > h1 > em")
	private String bookName;
  
	@HtmlField(cssPath = "body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > h1 > span > a")
	private String auther;
  
    @HtmlField(cssPath= "body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > p.intro")
    private String instruction;
  
    @HtmlField(cssPath = "body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > p:nth-child(4) > em:nth-child(1)")
    private String wordCount;
   
    @HtmlField(cssPath = "body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > p:nth-child(4) > em:nth-child(4)")
    private String mousePress;
  
    //@Ajax(url="http://book.qidian.com/ajax/comment/index?_csrfToken=e7LIJjWalES4KWNJYvPwwyRZ1PTvOiVWd4W0Gpbm&bookId=1005392714")
	private String booRank;
	@Href
	@HtmlField(cssPath = "a")
	private List<String> urls;
	
   @HtmlField(cssPath ="body > div.wrap > div.book-detail-wrap.center990 > div.book-information.cf > div.book-info > p:nth-child(4) > em:nth-child(7)")
	private String tuijianString;

   @Image
   @HtmlField(cssPath = "#bookImg > img")
   private String pictureString;
	@HtmlField(cssPath = "body > div.wrap > div.book-detail-wrap.center990 > div.book-content-wrap.cf > div.left-wrap.fl > div.book-info-detail > div.book-intro > p")
   private String productInstruction;

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getWordCount() {
		return wordCount;
	}

	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}

	public String getMousePress() {
		return mousePress;
	}

	public void setMousePress(String mousePress) {
		this.mousePress = mousePress;
	}

   public String getBooRank() {
		return booRank;
	}

	public void setBooRank(String booRank) {
		this.booRank = booRank;
	}
	


	public String getTuijianString() {
		return tuijianString;
	}

	public void setTuijianString(String tuijianString) {
		this.tuijianString = tuijianString;
	}

	public String getPictureString() {
		return pictureString;
	}

	public void setPictureString(String pictureString) {
		this.pictureString = pictureString;
	}

	public String getProductInstruction() {
		return productInstruction;
	}

	public void setProductInstruction(String productInstruction) {
		this.productInstruction = productInstruction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [request=" + request + ", id=" + id + ", bookName="
				+ bookName + ", auther=" + auther + ", instruction="
				+ instruction + ", wordCount=" + wordCount + ", mousePress="
				+ mousePress + ", booRank=" + booRank + ", urls=" + urls
				+ ", tuijianString=" + tuijianString + ", pictureString="
				+ pictureString + ", productInstruction=" + productInstruction
				+ "]";
	}

	

/*	public static void main(String[] args) {
	HttpRequest aHttpRequest1=	new HttpGetRequest("http://book.qidian.com/info/1005392714");
	HttpRequest aHttpRequest2=	new HttpGetRequest("http://book.qidian.com/info/1010473893");
	HttpRequest aHttpRequest3=	new HttpGetRequest("http://book.qidian.com/info/1010179519");
	HttpRequest aHttpRequest4=	new HttpGetRequest("http://book.qidian.com/info/1010239734");
	HttpRequest aHttpRequest5=	new HttpGetRequest("http://book.qidian.com/info/1010473379");
	List<HttpRequest> requests = new ArrayList<HttpRequest>() ;
	requests.add(aHttpRequest1);
	requests.add(aHttpRequest2);
	requests.add(aHttpRequest3);
	requests.add(aHttpRequest4);
	requests.add(aHttpRequest5);
	
		GeccoEngine.create().classpath("com.xiaomaoguai.gecco.testcrawler").thread(1)
		.interval(2000).start(requests).loop(false)
		.run();
	}*/
    
	
}
