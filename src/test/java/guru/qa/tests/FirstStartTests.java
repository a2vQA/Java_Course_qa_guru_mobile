package guru.qa.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Feature("Mobile tests")
@Story("Wikipedia app tests")
@Tag("onboardingWiki")
@Owner("vvartemenko")
public class FirstStartTests extends BaseTest {

    @Test
    @DisplayName("Успешное отображение 4ех экранов онбординга при первом запуске")
    void checkOnboardingInfoTest() {
        step("Первая страница онбординга имеет заголовок \"The Free Encyclopedia …in over 300 languages\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Вторая страница онбординга имеет заголовок \"New ways to explore\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Третья страница онбординга имеет заголовок \"Reading lists with sync\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Четвертая страница онбординга имеет заголовок \"Data & Privacy\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Data & Privacy"));
        });

        step("Закончить онбординг и перейти к википедии", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar")).shouldBe(visible);
        });
    }
}
