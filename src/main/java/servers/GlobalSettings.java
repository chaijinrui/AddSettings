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
 * cpId 渠道号
 */

public class GlobalSettings {
    private static final Logger log = LogManager.getLogger(GlobalSettings.class);

    public void addSettings(String packageChineseName, String settingName, String settingValue, String token, String cpId) throws IOException, SelfException {
//        判断包名是否正确
        Action.judgePackageChineseName(packageChineseName, token);

        //判断settingname是否正确
        if (!Action.judgeSettingName(token, settingName)) {
            return;
        }


//      修改配置

        boolean result = ChangeRespon.addRespon(packageChineseName, settingValue, settingName, token, cpId);
        if (result) {
            return;
        }


//        立即生效
        Action.execute(token, packageChineseName, cpId);
    }


    public static void main(String[] args) throws IOException, SelfException {
//        需要增加配置的包
        String[] rpkName = {
//                "做我房客（做我房客H）",
//                "十万个冷知识",
//                "思维夺宝",
//                "恋爱圈子",
//                "创意头像",
//                "夺宝智多星",
//                "静心白噪音",
//                "知识巅峰",
//                "启点小说",
//                "答题英雄",
//                "舒睡宝",
//                "黄金读书",
//                "白鲸追书大全",
//                "全免小说大全",
//                "答题之星",
//                "猜题夺金",
                "西瓜免费小说",
                "答题之星"
        };
        String cpId = "9483";
        String token = GetToken.getToken();
        for (String packname : rpkName) {
            log.info("{}开始", packname);
            new GlobalSettings().addSettings(packname, "TDR", "2-4000-1-1", token, cpId);
            new GlobalSettings().addSettings(packname, "APL", "10", token, cpId);
            new GlobalSettings().addSettings(packname, "THT", "4", token, cpId);
        }
    }
}

