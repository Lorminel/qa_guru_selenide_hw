package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideSoftAssertionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void softAssertionsContainsJUnit() {

        open("/selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();

        $$(".markdown-heading").findBy(text("JUnit5")).shouldBe(visible);
        $$("pre").findBy(text("ExtendWith")).shouldBe(visible);
        $$("pre").findBy(text("RegisterExtension")).shouldBe(visible);
    }

    }

