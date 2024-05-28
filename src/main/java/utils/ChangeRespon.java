package utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * 对返回值进行增加、修改、删除等操作
 */
public class ChangeRespon {
    private static final Logger log = LogManager.getLogger(ChangeRespon.class);

    public static void addRespon(String settingName, String settingValue, String name, String token) throws IOException {
//        打印配置的值
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(FindRespon.findGolbalRespon(name, token));
        for (JsonNode node : jsonNode) {
            if (node.get("key").asText().equals(settingName)) {
                log.info(settingName + "已存在，value= " + node.get("value").asText());
                break;
            }
        }
//        add配置
        String addUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
                "actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=" +
                URLEncoder.encode((FindParams.findAppid2(name, token) + "\"key\":\"" + settingName + "\",\"value\":\"" + settingValue + "\",\"cId\":0}"), "UTF-8");
        log.info("响应："+RequestUtil.getRequest(addUrl, token));
//        log.info(addUrl);
    }

    public static void main(String[] args) throws IOException {
        ChangeRespon.addRespon("AXR", "99", "西瓜免费小说", GetToken.getToken());
    }
}
