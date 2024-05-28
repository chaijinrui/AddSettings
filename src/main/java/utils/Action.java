package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URLEncoder;

public class Action {
    private static final Logger log = LogManager.getLogger(Action.class);

    //    配置结束后的立即生效方法
    public static void execute(String token, String name) throws IOException {
        String excuteurl1 = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" + "actions=reloadSDKServers&methodName=SDK_WEBConfigInfo&formValue=";
        String excuteurl2 = FindParams.findAppid2(name, token) + "\"actions\":\"advertScriptById\",\"url\":\"http://";
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
        for (int i = 0; i < ipArray.length; i++) {
            String ip = ipArray[i];
            log.info(excuteurl1);
            log.info(excuteurl2);
            log.info(excuteurl3);
            log.info(URLEncoder.encode(excuteurl2 + ip + excuteurl3, "UTF-8"));
            log.info(excuteurl1 + URLEncoder.encode(excuteurl2, "UTF-8") + ip + URLEncoder.encode(excuteurl3, "UTF-8"));
            log.info(RequestUtil.getRequest(excuteurl1 + URLEncoder.encode(excuteurl2 + ip + excuteurl3, "UTF-8"), token));
        }
    }

    public static void main(String[] args) throws IOException {
        //        log.info(RequestUtil.getRequest("http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=reloadSDKServers&methodName=SDK_WEBConfigInfo&formValue={\"cp_id\":9483,\"app_id\":5717,\"sdk_code\":3018,\"actions\":\"advertScriptById\",\"url\":\"http://39.103.193.66:8060/sdk/api/init/admin/setup\",\"flag\":\"1\"}\n", GetToken.getToken()));
//           }
        Action.execute(GetToken.getToken(), "西瓜免费小说");
    }
}

