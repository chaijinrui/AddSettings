package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;


public class Action {
    private static final Logger log = LogManager.getLogger(Action.class);

    //    立即生效
    public static void execute(String token, String name, String cpId) throws IOException {
        String excuteurl1 = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=reloadSDKServers&methodName=SDK_WEBConfigInfo&formValue=";
        String excuteurl2 = FindParams.findAppid2(name, token, cpId) + "\"actions\":\"advertScriptById\",\"url\":";
        String Domain = "\"http://";
        String excuteurl3 = "/sdk/api/init/admin/setup\",\"flag\":\"1\"}";
        String[] ipArray = {
                "39.103.193.66:8060",
                "8.142.209.54:8060",
                "39.99.156.86:8060",
                "39.103.235.152:8060",
                "8.142.121.29:8060",
                "8.142.143.13:8060",
                "8.142.71.145:8060",
                "39.98.198.216:8060",
                "39.98.209.184:8060",
                "39.98.190.11:8060",
                "39.98.209.116:8060",
                "39.98.197.248:8060",
                "39.98.198.174:8060",
                "39.98.67.159:8060",
                "39.98.210.157:8060",
                "39.98.73.111:8060",
                "47.92.70.55:8060",
                "47.92.153.231:8060",
                "47.92.86.41:8060",
                "47.92.67.18:8060",
                "47.92.112.248:8060",
                "47.92.113.69:8060",
                "47.92.140.123:8060",
                "47.92.36.175:8060",
                "47.92.27.175:8060",
                "47.92.52.162:8060",
                "47.92.192.79:8060",
                "47.92.31.7:8060",
                "47.92.223.62:8060",
                "39.98.55.111:8060",
                "47.92.171.5:8060"};
//        url的编码遇到问题，浏览器自带编码工具
        String finalUrl = null;
        for (int i = 0; i < ipArray.length; i++) {
            String ip = ipArray[i];
//            log.info("{}{}{}{}{}", excuteurl1, excuteurl2, Domain, ip, excuteurl3);
            finalUrl = excuteurl1 + URLEncoder.encode(excuteurl2 + Domain + ip + excuteurl3, "UTF-8");
//            log.info("请求链接：{}", finalUrl);
//            log.info("立即生效响应：{}", RequestUtil.getRequest(finalUrl, token));
        }
        log.info("{}添加完毕", name);
    }

    //判断SettingName是否正确
    public static Boolean judgeSettingName(String token, String settingName) throws JsonProcessingException {
        String settingUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getAdvertShow&methodName=AdverJoinSDK&formValue=%7B%22KeyName%22%3A%22advertCommonConfig%22%7D";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(RequestUtil.getRequest(settingUrl, token)).get("dataTable");
        for (JsonNode node : jsonNode) {
            if (settingName.equals(node.get("KeyName").asText())) {
                return true;
            }
        }
        log.info("{},不存在", settingName);
        return false;
    }

    //判断packageChineseName是否正确
    public static void judgePackageChineseName(String name, String token) throws JsonProcessingException, SelfException {
        String nameUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getapp&methodName=AdverJoinSDK&formValue=%7B%7D";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(RequestUtil.getRequest(nameUrl, token)).get("dataTable");
        boolean foundMatch = true;
        String truename = "";
        for (JsonNode node : jsonNode) {
            truename = node.get("appname").asText();
            if (name.equals(truename)) {
                foundMatch = false;
                break;
            }
        }
        if (foundMatch) {
            throw new SelfException(name);
        } else
            log.info("包名都正确");
    }
}


