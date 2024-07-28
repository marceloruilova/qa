package org.com.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VerifyLinkQuestion implements Question<Boolean> {
    private final String expectedUrl;

    public VerifyLinkQuestion(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        return currentUrl.equals(expectedUrl);
    }

    public static VerifyLinkQuestion verifyUrl(String expectedUrl) {
        return new VerifyLinkQuestion(expectedUrl);
    }
}
