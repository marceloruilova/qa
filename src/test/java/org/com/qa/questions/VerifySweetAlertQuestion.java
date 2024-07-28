package org.com.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.com.qa.userinterfaces.CartPageElements;

public class VerifySweetAlertQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(CartPageElements.SWEET_ALERT_MODAL).answeredBy(actor).isVisible();
    }

    public static VerifySweetAlertQuestion isVisible() {
        return new VerifySweetAlertQuestion();
    }
}
