package utils;

/**
 * FileName：SelfException
 * Author: sns-chaijinrui
 * Date: 2024/6/3
 * Time: 下午6:24
 */
//  自定义一个包名错误异常类(类名没起好)
public class SelfException extends Exception {
    private String packageChineseName;
    private String packName;

    public SelfException(String packageChineseName, String packName) {
        super("正确的包名: " + packName + ", 你的包名: " + packageChineseName);
    }

    // 可以添加getter方法，以便在捕获异常时获取更多信息
    public String getPackageChineseName() {
        return packageChineseName;
    }

    public String getPackageName() {
        return packName;
    }
}
