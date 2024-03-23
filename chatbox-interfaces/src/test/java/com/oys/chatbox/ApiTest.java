package com.oys.chatbox;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiTest {


    /**
     * 这是模拟进行提问时需要用到的爬虫
     * @throws IOException
     */
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 请求网址
        HttpGet get = new HttpGet("");
        // cookie的值
        get.addHeader("cookie","");
        // 内容类型
        get.addHeader("Content-Type","application/json;charset=utf8");
        // 执行请求把异常抛出去
        CloseableHttpResponse response = httpClient.execute(get);
        // 如果返回200
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            // 解析
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            // 否则打印状态码
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }



    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("");
        post.addHeader("cookie","");
        post.addHeader("Content-Type","");
        // 请求返回体
        String paramJson = "{}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
