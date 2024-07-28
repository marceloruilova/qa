package org.com.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifySweetAlertQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifySweetAlertQuestion.class);

    private final Target sweetAlertModal;

    public VerifySweetAlertQuestion(Target sweetAlertModal) {
        this.sweetAlertModal = sweetAlertModal;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean isVisible = sweetAlertModal.resolveFor(actor).isVisible();
        LOGGER.info("Sweet alert modal visibility: {}", isVisible);
        return isVisible;
    }

    public static VerifySweetAlertQuestion isVisible(Target sweetAlertModal) {
        return new VerifySweetAlertQuestion(sweetAlertModal);
    }
}
