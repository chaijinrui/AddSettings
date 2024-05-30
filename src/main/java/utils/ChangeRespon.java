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

    public static boolean addRespon(String name, String settingValue, String settingName, String token) throws IOException {
//        打印配置的值
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(FindRespon.findGolbalRespon(name, token));
        String cId = null;
        for (JsonNode node : jsonNode) {
            if (node.get("key").asText().equals(settingName)) {
                cId = node.get("cId").asText();
                log.info(settingName + "已存在，value= " + node.get("value").asText());
                if (!settingValue.equals(node.get("value").asText())) {
                    fixRespon(name, settingValue, settingName, token, cId);
                } else
                    return true; //要是配置本来就符合预期，这条case还没搞好
            }
        }
//        add配置
        String addUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
                "actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=" +
                URLEncoder.encode((FindParams.findAppid3(name, token) + "\"key\":\"" + settingName + "\",\"value\":\"" + settingValue + "\",\"cId\":0}"), "UTF-8");
//        log.info("add接口入参：{}", FindParams.findAppid3(name, token) + "\"key\":\"" + settingName + "\",\"value\":\"" + settingValue + "\",\"cId\":0}");
        log.info("{}请求add接口响应：{}", name, RequestUtil.getRequest(addUrl, token));
        return false;
    }


    //          当这个配置已经存在时，调用fixRespon去修改
    public static void fixRespon(String name, String settingValue, String settingName, String token, String cId) throws IOException {
        String fixUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
                "actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=" +
                URLEncoder.encode("{\"asId\":\"9483," + FindParams.findAppid4(name, token) + ",3018\",\"key\":\"" + settingName + "\",\"value\":\"" + settingValue + "\",\"cId\":" + cId + "}"
                        , "UTF-8");
        log.info("fixUrl={}", fixUrl);
        String fixres = RequestUtil.getRequest(fixUrl, token);

        log.info("{}请求fix接口响应：{}", name, fixres);
    }
}
