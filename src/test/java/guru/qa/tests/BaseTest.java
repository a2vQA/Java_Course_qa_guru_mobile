package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.drivers.BrowserstackDriver;
import guru.qa.drivers.EmulationDriver;
import guru.qa.drivers.LocalDriver;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    public static void browserSetUp() {
        System.setProperty("deviceHost", System.getProperty("deviceHost", "browserstack"));
        switch (System.getProperty("deviceHost")) {
            case "browserstack" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "emulation" -> Configuration.browser = EmulationDriver.class.getName();
            case "local" -> Configuration.browser = LocalDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    public void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
        if (System.getProperty("deviceHost").equals("browserstack"))
            Attach.addVideo(sessionId);
    }
}
