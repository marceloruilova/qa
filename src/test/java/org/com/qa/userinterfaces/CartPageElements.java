package org.com.qa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPageElements {

    public static final Target TABLE_BODY = Target.the("Cart table body")
            .locatedBy(".table tbody");

    public static final Target TABLE_BODY_ROWS = Target.the("table body rows")
            .locatedBy(".table tbody tr");

    public static final Target PLACE_ORDER_BUTTON = Target.the("Order button")
            .locatedBy("#page-wrapper > div > div.col-lg-1 > button");

    public static final Target PURCHASE_MODAL_BUTTON = Target.the("Purchase modal button")
            .locatedBy("#orderModal > div > div > div.modal-footer > button.btn.btn-primary");

}
