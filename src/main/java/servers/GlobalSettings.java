package servers;

import utils.GetToken;
import utils.RequestUtil;

public class GlobalSettings {
    //    https://tongyi.aliyusn.com/qianwen/share?shareId=977da3f7-5810-47b7-bba3-23d42c5df586\


    //    传入的报名不止一个
    public void addSettings(String packageChineseName, String settingName, String settingValue) {
//    获取token
        String token = GetToken.token;

//      获取app_id
        String appidurl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=getapp&methodName=AdverJoinSDK&formValue=%7B%7D";
        RequestUtil.getRequest(appidurl,token);


    }


}

