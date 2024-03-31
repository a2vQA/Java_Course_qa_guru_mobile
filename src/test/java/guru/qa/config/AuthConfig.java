package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/auth.properties"
})
public interface AuthConfig extends Config {
    @Config.Key("user.username")
    String getUsername();

    @Config.Key("user.accessKey")
    String getPassword();
}