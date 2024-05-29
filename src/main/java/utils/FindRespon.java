package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * 查询目前配置
 */
public class FindRespon {
    private static final Logger log = LogManager.getLogger(FindRespon.class);

    public static String findGolbalRespon(String name, String token) throws IOException {
        String responUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
                "actions=getAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=" + URLEncoder.encode(FindParams.findAppid(name, token), "UTF-8");
//        log.info(responUrl);
        String respon = RequestUtil.getRequest(responUrl, token);
        log.info("{}目前配置：{}", name, respon);
        return respon;
    }
}
