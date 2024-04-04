package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${deviceHost}.properties"
})
public interface BrowserstackConfig extends Config {
    @Config.Key("browserstack.device")
    String getDevice();

    @Config.Key("browserstack.deviceOsVersion")
    String getOsVersion();

    @Config.Key("browserstack.app")
    String getApp();

    @Config.Key("browserstack.remoteUrl")
    String getBrowserstackUrl();
}
