package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Config.Key("browserstack.device")
    String getDevice();

    @Config.Key("browserstack.deviceOsVersion")
    String getOsVersion();

    @Config.Key("browserstack.remoteUrl")
    String getBrowserstackUrl();
}
