package servers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.*;

import java.io.IOException;

public class GlobalSettings {
    private static final Logger log = LogManager.getLogger(GlobalSettings.class);

    public void addSettings(String packageChineseName, String settingName, String settingValue, String token) throws IOException {

        //判断settingname是否正确
        if (!Action.judgeSettingName(token, settingName)) {
            return;
        }


//      修改配置

        boolean result =ChangeRespon.addRespon(packageChineseName, settingValue, settingName, token);
        if (result){
            return;
        }


//        立即生效
        Action.execute(token, packageChineseName);
    }


    public static void main(String[] args) throws IOException {
        String token = GetToken.getToken();
        log.info("token: {}", token);
//        需要增加配置的包
        String[] rpkName = {
                "西瓜免费小说",
//                "答题赚宝",
                "十万个冷知识"};
        for (String packname : rpkName) {
            log.info("{}开始", packname);
            new GlobalSettings().addSettings(packname, "AXR", "10", token);
        }
    }
}

