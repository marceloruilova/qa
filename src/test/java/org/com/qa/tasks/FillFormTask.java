package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.com.qa.models.User;
import org.com.qa.userinterfaces.FormElements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FillFormTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(FillFormTask.class);

    private final User user;

    public FillFormTask(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Filling form with user details: {}", user);
        actor.attemptsTo(
                Enter.theValue(user.getName()).into(FormElements.NAME_FIELD),
                Enter.theValue(user.getCountry()).into(FormElements.COUNTRY_FIELD),
                Enter.theValue(user.getCity()).into(FormElements.CITY_FIELD),
                Enter.theValue(user.getCreditCard()).into(FormElements.CREDIT_CARD_FIELD),
                Enter.theValue(user.getMonth()).into(FormElements.MONTH_FIELD),
                Enter.theValue(user.getYear()).into(FormElements.YEAR_FIELD)
        );
    }

    public static FillFormTask withUser(User user) {
        return new FillFormTask(user);
    }
}
