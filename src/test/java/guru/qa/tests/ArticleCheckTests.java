package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Feature("Mobile tests")
@Story("Wikipedia app tests")
@Tag("smoke")
@Owner("vvartemenko")
public class ArticleCheckTests extends BaseTest {

    @Test
    @DisplayName("Отображение ошибки \"An error occurred\" при открытии статьи")
    void CheckErrorOnArticleTest() {
        step("Search for Telegram", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Telegram");
        });

        step("Go to Telegram Article", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0))
                        .findBy(Condition.text("Telegram (software)"))
                        .click());

        step("Check error message", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                        .shouldHave(Condition.text("An error occurred")));
    }
}