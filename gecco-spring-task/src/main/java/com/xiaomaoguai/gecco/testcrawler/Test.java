package com.xiaomaoguai.gecco.testcrawler;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;

public class Test implements Job {
	public static void main(String[] args) {
	HttpRequest aHttpRequest1=	new HttpGetRequest("http://www.qidian.com/");

	List<HttpRequest> requests = new ArrayList<HttpRequest>() ;
	requests.add(aHttpRequest1);
		GeccoEngine.create().classpath("com.xiaomaoguai.gecco.testcrawler").thread(1)
		.interval(1000).start(requests).loop(false)
		.run();
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		HttpRequest aHttpRequest1=	new HttpGetRequest("http://www.qidian.com/");

		List<HttpRequest> requests = new ArrayList<HttpRequest>() ;
		requests.add(aHttpRequest1);
			GeccoEngine.create().classpath("com.xiaomaoguai.gecco.testcrawler").thread(1)
			.interval(1000).start(requests).loop(false)
			.run();		
	}
    
}
