package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URLEncoder;

public class Action {
    private static final Logger log = LogManager.getLogger(Action.class);

    //    配置结束后的立即生效方法
    public static void execute(String token, String name) throws IOException {
        String excuteurl1 = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=reloadSDKServers&methodName=SDK_WEBConfigInfo&formValue=";
        String excuteurl2 = FindParams.findAppid2(name, token) + "\"actions\":\"advertScriptById\",\"url\":";
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
            log.info(excuteurl1 + excuteurl2 + Domain + ip + excuteurl3);
            finalUrl = excuteurl1 + URLEncoder.encode(excuteurl2 + Domain + ip + excuteurl3, "UTF-8");
            log.info(finalUrl);
            System.out.println("响应值：" + RequestUtil.getRequest(finalUrl, token));
        }
    }

    public static void main(String[] args) throws IOException {
//        log.info(RequestUtil.getRequest("http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=reloadSDKServers&methodName=SDK_WEBConfigInfo&formValue=%7B%22cp_id%22%3A9483%2C%22app_id%22%3A5717%2C%22sdk_code%22%3A3018%2C%22actions%22%3A%22advertScriptById%22%2C%22url%22%3A%22http%3A%2F%2F8.142.209.54%3A8060%2Fsdk%2Fapi%2Finit%2Fadmin%2Fsetup%22%2C%22flag%22%3A%221%22%7D", GetToken.getToken()));
        Action.execute(GetToken.getToken(), "西瓜免费小说");
    }

}


