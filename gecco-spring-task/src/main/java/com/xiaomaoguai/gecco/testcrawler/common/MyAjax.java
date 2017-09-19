package com.xiaomaoguai.gecco.testcrawler.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

public class MyAjax {
public static void main(String[] args) throws UnsupportedEncodingException {
   
   //发送POST请求 
    MyAjax.sendGet("http://p.3.cn/prices/mgets?skuIds=J_155465"); 
}
/** 
 * 向指定URL发送POST方法的请求 
 *@paramurl 发送请求的URL 
 *@returnURL所代表远程资源的响应 
 */ 
public static String sendGet(String url) { 
  OutputStreamWriter out= null;
     BufferedReader in= null;
     String result= "";
    try{
         URL realUrl= new URL(url);
        // 打开和URL之间的连接
         URLConnection conn= realUrl.openConnection();
        // 设置通用的请求属性
        conn.setRequestProperty("accept","*/*");
        conn.setRequestProperty("connection","close");//短连接
        conn.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
      //  conn.setDoInput(true);
        // 获取URLConnection对象对应的输出流             
        out= new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
        // flush输出流的缓冲
        out.flush();
        // 定义BufferedReader输入流来读取URL的响应
        in= new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
         String line;
        while((line= in.readLine()) !=null) {
            result+= line;
         }
     }catch(Exception e) {
         System.out.println("发送GET 请求出现异常！"+e);
        e.printStackTrace();
     }
    //使用finally块来关闭输出流、输入流
    finally{
        try{
            if(out!=null){
                out.close();
             }
            if(in!=null){
                in.close();
             }
         }
        catch(IOException ex){
            ex.printStackTrace();
         }
     }
    return result;
 }   
}
