package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static utils.RequestUtil.getRequest;


/**
 * FileName：FindParams
 * Author: thinkbook-chaijinrui
 * Date: 2024/5/27
 * Time: 22:50
 * Description：拼接入参。
 * 三种方法的区别  只有返回值不同。根据不同接口的入参，拼接出不一样的入参return给调用方
 */
public class FindParams {
    private static final Logger log = LogManager.getLogger(FindParams.class);

    //获取appid，然后拼接起来用做参数
    public static String findAppid(String name, String token, String cpId) throws IOException {
        String apiUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getapp&methodName=AdverJoinSDK&formValue=%7B%7D";
        String appid = null;
        String appname;
        // 使用ObjectMapper读取URL中的JSON数据
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(getRequest(apiUrl, token));
        JsonNode dataTableNode = jsonNode.get("dataTable");

//        找出cpid,包名的遍历不能在这里处理，得在调用方处理。调用方每次值传进来一个包名，该方法每次返回一个链接，待所有请求完成后，再传进来第二个参数...
        for (JsonNode appNode : dataTableNode) {
            appname = appNode.get("appname").asText();
            appid = appNode.get("app_id").asText();
            // 接下来可以对appname进行处理或检查
            if (appname.equals(name)) {
                break;
            }
        }
//        log.info("入参：" + "{\"asId\":\"9483," + appid + ",3018\"}");
        return "{\"asId\":\"" + cpId + "," + appid + ",3018\"}";
    }


    public static String findAppid2(String name, String token, String cpId) throws IOException {
        String apiUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getapp&methodName=AdverJoinSDK&formValue=%7B%7D";
        String appid = null;
        String appname;
        // 使用ObjectMapper读取URL中的JSON数据
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(getRequest(apiUrl, token));
        JsonNode dataTableNode = jsonNode.get("dataTable");

        for (JsonNode appNode : dataTableNode) {
            appname = appNode.get("appname").asText();
            appid = appNode.get("app_id").asText();
            // 接下来可以对appname进行处理或检查
            if (appname.equals(name)) {
                break;
            }
        }
        return "{\"cp_id\":" + cpId + "," + "\"app_id\":" + appid + ",\"sdk_code\":" + "3018,";
    }

    public static String findAppid3(String name, String token, String cpId) throws IOException {
        String apiUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getapp&methodName=AdverJoinSDK&formValue=%7B%7D";
        String appid = null;
        String appname;
        // 使用ObjectMapper读取URL中的JSON数据
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(getRequest(apiUrl, token));
        JsonNode dataTableNode = jsonNode.get("dataTable");

        for (JsonNode appNode : dataTableNode) {
            appname = appNode.get("appname").asText();
            appid = appNode.get("app_id").asText();
            // 接下来可以对appname进行处理或检查
            if (appname.equals(name)) {
                break;
            }
        }
        return "{\"asId\":\"" + cpId + "," + appid + ",3018\",";
    }

    public static String findAppid4(String name, String token) throws IOException {
        String apiUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getapp&methodName=AdverJoinSDK&formValue=%7B%7D";
        String appid = null;
        String appname;
        // 使用ObjectMapper读取URL中的JSON数据
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(getRequest(apiUrl, token));
        JsonNode dataTableNode = jsonNode.get("dataTable");

        for (JsonNode appNode : dataTableNode) {
            appname = appNode.get("appname").asText();
            appid = appNode.get("app_id").asText();
            // 接下来可以对appname进行处理或检查
            if (appname.equals(name)) {
                break;
            }
        }
        return appid;
    }
}

