package com.xiaomaoguai.gecco.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaomaoguai.gecco.testcrawler.BookPip;

@Controller
@RequestMapping("index")
public class IndexController {

	@Resource
	private BookPip bookPip;
	/**
	 * 首页
	 */
	@RequestMapping
	public String index() {
		return "index";
	}

}
