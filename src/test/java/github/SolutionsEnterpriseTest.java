package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterpriseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void enterprisePageIsOpened(){
        open("/");
        $("header").$$("li").findBy(text("Solutions")).hover()
                .$$("li").findBy(text("Enterprise")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform."));

    }


}
