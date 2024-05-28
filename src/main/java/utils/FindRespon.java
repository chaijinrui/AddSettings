package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URLEncoder;

/*
这个方法直接返回全局配置的返回结果
 */
public class FindRespon {
    private static final Logger log = LogManager.getLogger(FindRespon.class);

    public static String findGolbalRespon(String name, String token) throws IOException {
        String responUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
                "actions=getAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=" + URLEncoder.encode(FindParams.findAppid(name, token), "UTF-8");
        log.info(responUrl);
        String respon = RequestUtil.getRequest(responUrl, token);
        log.info("请求全局配置返回结果：" + respon);
        return respon;
    }
}
