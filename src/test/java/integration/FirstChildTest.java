package integration;

import com.codeborne.selenide.Configuration;
import integration.helpers.HTMLBuilderForTestPreconditions;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by apop on 4/7/2017.
 */
public class FirstChildTest extends IntegrationTest {
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
    public void firstChildShouldReturnCorrectElement() {
        $("ul").firstChild().shouldHave(text("Miller"));
    }
}
