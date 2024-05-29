package servers;

import utils.*;

import java.io.IOException;

public class GlobalSettings {
    //    https://tongyi.aliyusn.com/qianwen/share?shareId=977da3f7-5810-47b7-bba3-23d42c5df586\

    //    传入的包名不止一个
    public void addSettings(String packageChineseName, String settingName, String settingValue, String token) throws IOException {

//      修改配置
        ChangeRespon.addRespon(packageChineseName, settingValue, settingName, token);
//        立即生效
        Action.execute(token, packageChineseName);
    }


    public static void main(String[] args) throws IOException {
//        需要增加配置的包
        String[] rpkName = {
                "西瓜免费小说",
                "答题赚宝",
                "十万个冷知识"};


        for (String packname : rpkName) {
            new GlobalSettings().addSettings(packname, "AXR", "77", GetToken.getToken());
        }

    }
}

