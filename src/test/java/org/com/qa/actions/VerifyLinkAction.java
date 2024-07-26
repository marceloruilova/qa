package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.assertj.core.api.Assertions;

public class VerifyLinkAction implements Performable {

    private final String expectedUrl;

    public VerifyLinkAction(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        Assertions.assertThat(currentUrl).isEqualTo(expectedUrl);
    }

    public static VerifyLinkAction verifyUrl(String expectedUrl) {
        return new VerifyLinkAction(expectedUrl);
    }
}
