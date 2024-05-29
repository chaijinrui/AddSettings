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

    public static Boolean addRespon(String name, String settingValue, String settingName, String token) throws IOException {
//        打印配置的值
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(FindRespon.findGolbalRespon(name, token));
        for (JsonNode node : jsonNode) {
            if (node.get("key").asText().equals(settingName)) {
                log.info(settingName + "已存在，value= " + node.get("value").asText());
                return false;
            }
        }
//        add配置
        String addUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
                "actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=" +
                URLEncoder.encode((FindParams.findAppid3(name, token) + "\"key\":\"" + settingName + "\",\"value\":\"" + settingValue + "\",\"cId\":0}"), "UTF-8");
//        log.info("add接口入参：{}", FindParams.findAppid3(name, token) + "\"key\":\"" + settingName + "\",\"value\":\"" + settingValue + "\",\"cId\":0}");
        log.info("{}请求add接口响应：{}", name, RequestUtil.getRequest(addUrl, token));
        return true;
    }
}
