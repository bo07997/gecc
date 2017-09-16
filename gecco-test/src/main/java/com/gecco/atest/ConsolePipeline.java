package com.gecco.atest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.demo.taobao.Type;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;

@PipelineName("consolePipeline")
public class ConsolePipeline implements Pipeline<NullATest> {

    @Override
    public void process(NullATest aTest) {

    	File file = new File("D://a.txt");
    	
    		
    	
    	// 第2步、通过子类实例化父类对象
    			Writer out = null ;	// 准备好一个输出的对象
    			try {
					out = new FileWriter(file,true)  ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	// 通过对象多态性，进行实例化
    			// 第3步、进行写操作
    			String str = aTest.getHref() ;
    			String str2 = aTest.getText() ;// 准备一个字符串
    			System.out.println(str+":"+str2);
    			try {
					out.write(str) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 将内容输出，保存文件
    		finally{
    			// 第4步、关闭输出流
    			try {
					out.close() ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 关闭输出流
    		}
    }
    
}
