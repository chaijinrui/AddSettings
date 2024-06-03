package servers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.*;

import java.io.IOException;

/**
 * 入参：
 * packageChineseName 包名
 * settingName 配置名称
 * settingValue 配置值
 * token 请求接口所用的token
 */
public class GlobalSettings {
    private static final Logger log = LogManager.getLogger(GlobalSettings.class);

    public void addSettings(String packageChineseName, String settingName, String settingValue, String token) throws IOException, SelfException {
//        判断包名是否正确
        Action.judgePackageChineseName(packageChineseName, token);

        //判断settingname是否正确
        if (!Action.judgeSettingName(token, settingName)) {
            return;
        }


//      修改配置

        boolean result = ChangeRespon.addRespon(packageChineseName, settingValue, settingName, token);
        if (result) {
            return;
        }


//        立即生效
        Action.execute(token, packageChineseName);
    }


    public static void main(String[] args) throws IOException, SelfException {
        String token = GetToken.getToken();
        log.info("token: {}", token);
//        需要增加配置的包
        String[] rpkName = {
//                "做我房客（做我房客H）",
                "十万个冷知识",
                "思维夺宝",
                "夺宝智多星",
                "静心白噪音",
                "知识巅峰",
                "启点小说",
                "答题英雄",
                "舒睡宝",
                "黄金读书",
                "白鲸追书大全",
                "全免小说大全",
                "答题之星",
                "猜题夺金"
        };
        for (String packname : rpkName) {
            log.info("{}开始", packname);
            new GlobalSettings().addSettings(packname, "DJSW", "3-0", token);
        }
    }
}

