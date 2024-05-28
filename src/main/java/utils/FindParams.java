package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * FileName：FindParams
 * Author: thinkbook-chaijinrui
 * Date: 2024/5/27
 * Time: 22:50
 * Description：
 */
public class FindParams {
    public static void Findappid(String name) throws IOException {
        String apiUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getapp&methodName=AdverJoinSDK&formValue=%7B%7D";
        // 使用ObjectMapper读取URL中的JSON数据
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(RequestUtil.getRequest(apiUrl, GetToken.getToken()));

        String appname = jsonNode.get("appname").asText();
        System.out.println(appname);

//
//return jsonNode;
    }

    public static void main(String[] args) throws IOException {
Findappid("西瓜免费小说");

    }
}

