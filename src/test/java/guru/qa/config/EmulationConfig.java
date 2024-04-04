package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${deviceHost}.properties")
public interface EmulationConfig extends Config {

    @Key("emulation.device")
    String getDeviceModel();

    @Key("emulation.deviceOsVersion")
    String getSystemVersion();

    @Key("emulation.appVersion")
    String getAppVersion();

    @Key("emulation.appUrl")
    String getAppUrl();

    @Key("emulation.appPackage")
    String getAppPackage();

    @Key("emulation.appActivity")
    String getAppActivity();
}
