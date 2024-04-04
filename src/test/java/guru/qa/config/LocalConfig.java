package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${deviceHost}.properties")
public interface LocalConfig extends Config {

    @Key("local.device")
    String getDeviceModel();

    @Key("local.deviceOsVersion")
    String getSystemVersion();

    @Key("local.appVersion")
    String getAppVersion();

    @Key("local.appUrl")
    String getAppUrl();

    @Key("local.appPackage")
    String getAppPackage();

    @Key("local.appActivity")
    String getAppActivity();
}
