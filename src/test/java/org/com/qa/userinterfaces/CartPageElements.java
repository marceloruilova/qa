package org.com.qa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPageElements {

    public static final Target TABLE_BODY = Target.the("Cart table body")
            .locatedBy(".table tbody");

    public static final Target TABLE_BODY_ROWS = Target.the("table body rows")
            .locatedBy(".table tbody tr");

}
