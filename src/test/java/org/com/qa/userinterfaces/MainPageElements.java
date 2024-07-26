package org.com.qa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MainPageElements {

    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button")
            .locatedBy("#page-wrapper > div > div.col-lg-1 > button");

    public static final Target PRODUCT_IMAGES = Target.the("Product images")
            .locatedBy(".card-img-top.img-fluid");

    public static final Target SWEET_ALERT = Target.the("Sweet alert")
            .locatedBy(".sweet-alert.showSweetAlert.visible");

    public static final Target ORDER_MODAL = Target.the("Order modal")
            .locatedBy("#orderModal");

    public static final Target PLACE_ORDER_BUTTON = Target.the("Place order button")
            .locatedBy("#orderModal > div > div > div.modal-footer > button.btn.btn-primary");

    public static String mainPageProductSelector(String childNumber) {
        return "#tbodyid > div:nth-child(" + childNumber + ") > div > a > img";
    }

}
