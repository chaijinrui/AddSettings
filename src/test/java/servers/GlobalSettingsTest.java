package servers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.ChangeRespon;
import utils.GetToken;
import utils.SelfException;


import java.io.IOException;

import static org.testng.Assert.*;

/**
 * FileName：GlobalSettingsTest
 * Author: sns-chaijinrui
 * Date: 2024/5/29
 * Time: 下午3:42
 * Description：
 */
@Deprecated
public class GlobalSettingsTest {
    private static final Logger log = LogManager.getLogger(ChangeRespon.class);


    @Deprecated
    public void testAddSettings() throws IOException, SelfException {
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