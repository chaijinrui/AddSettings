package servers;

import utils.FindParams;
import utils.FindRespon;
import utils.GetToken;
import utils.RequestUtil;

import java.io.IOException;

public class GlobalSettings {
    //    https://tongyi.aliyusn.com/qianwen/share?shareId=977da3f7-5810-47b7-bba3-23d42c5df586\


    //    传入的包名不止一个
    public void addSettings(String packageChineseName, String settingName, String settingValue, String token) throws IOException {
//        请求全局配置返回结果
        FindRespon.findGolbalRespon("西瓜免费小说", GetToken.getToken());

    }

}

