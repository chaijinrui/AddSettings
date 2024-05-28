package utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/*
这
 */
public class RequestUtil {
    /*
这个方法用来做URL的请求
 */
    public static String getRequest(String url, String token) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建HttpGet请求
            HttpGet httpGet = new HttpGet(url);
            // 设置cookie
            httpGet.setHeader("Cookie", token);
            String responseBody = "1";
            // 执行请求
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                // 获取响应状态码
                int statusCode = response.getStatusLine().getStatusCode();

                // 检查响应状态码是否为200
                if (statusCode == 200) {
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();

                    // 将实体转换为字符串
                    responseBody = EntityUtils.toString(entity);


                    // 这里可以根据需要添加更详细的断言来验证响应内容
                    // 例如，使用JSON解析库来验证返回的JSON数据
                } else {
                    System.out.println("Request failed with status code: " + statusCode);
                }
            }
            return responseBody;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static String postRequest(String url,String token) {
//        // 创建HttpClient实例
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            // 设置目标URL
//            HttpPost httpPost = new HttpPost(url);
//
//            // 准备JSON请求体
//            String jsonPayload1= "{\"key1\":\"value1\", \"key2\":\"value2\"}";
//            StringEntity entity = new StringEntity(jsonPayload1, "application/json", "UTF-8");
//
//            // 设置请求体和内容类型
//            httpPost.setEntity(entity);
//            httpPost.setHeader("Cookie", token);
//
//            // 发送POST请求并处理响应
//            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
//                // 获取响应状态码
//                int statusCode = response.getStatusLine().getStatusCode();
//                System.out.println("Response Status Code: " + statusCode);
//
//                // 获取并打印响应内容
//                HttpEntity responseEntity = response.getEntity();
//                if (responseEntity != null) {
//                    String responseBody = EntityUtils.toString(responseEntity);
//                    System.out.println("Response Body: " + responseBody);
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

