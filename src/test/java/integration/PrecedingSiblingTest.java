package integration;

import com.codeborne.selenide.Configuration;
import integration.helpers.HTMLBuilderForTestPreconditions;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by apop on 4/7/2017.
 */
public class PrecedingSiblingTest extends IntegrationTest {
    @Before
    public void openPage() {
        HTMLBuilderForTestPreconditions.Given.openedPageWithBody(
                "<ul>Hello to:",
                "<li class='the-expanse detective'>Miller</li>",
                "<li class='the-expanse missing'>Julie Mao</li>",
                "</ul>"
        );
        Configuration.timeout = 0;
    }

    @Test
    public void followingSiblingShouldReturnCorrectElement() {
        $(byText("Julie Mao")).precedingSibling().shouldHave(text("Miller"));
    }
}
