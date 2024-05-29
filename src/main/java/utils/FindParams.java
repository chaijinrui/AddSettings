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
 * Description：
 */
public class FindParams {
    private static final Logger log = LogManager.getLogger(FindParams.class);

    //获取appid，然后拼接起来用做参数
//    生成值  {"asId":"9483,5717,3018"
    public static String findAppid(String name, String token) throws IOException {
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
                log.info("app_id= " + appid);
                log.info("name= " + name);
                break;
            }
        }
        log.info("入参：" + "{\"asId\":\"9483," + appid + ",3018\"}");
        return "{\"asId\":\"9483," + appid + ",3018\"}";
    }


    //    生成值 {"cp_id":9483,"app_id":5717,"sdk_code":3018,
    public static String findAppid2(String name, String token) throws IOException {
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
                log.info("app_id= " + appid);
                log.info("name= " + name);
                break;
            }
        }
        log.info("{\"cp_id\":9483," + "\"app_id\":" + appid + ",\"sdk_code\":" + "3018,");
        return "{\"cp_id\":9483," + "\"app_id\":" + appid + ",\"sdk_code\":" + "3018,";
    }
}

