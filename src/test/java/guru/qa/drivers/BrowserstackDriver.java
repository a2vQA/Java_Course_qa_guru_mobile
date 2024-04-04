package guru.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import guru.qa.config.AuthConfig;
import guru.qa.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", authConfig.getUsername());
        caps.setCapability("browserstack.key", authConfig.getPassword());

        // Set URL of the application under test
        caps.setCapability("app", "bs://af222daa56f9933e6b474aac9f37723a1f9574f8");

        // Specify device and os_version for testing
        caps.setCapability("device", browserstackConfig.getDevice());
        caps.setCapability("os_version", browserstackConfig.getOsVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.getBrowserstackUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
