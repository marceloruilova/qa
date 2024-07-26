package org.com.qa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MainPageElements {

    public static final Target PRODUCT_IMAGES = Target.the("Product images")
            .locatedBy(".card-img-top.img-fluid");

    public static Target PRODUCT(String childNumber) {
        return Target.the("Product " + childNumber)
                .locatedBy("#tbodyid > div:nth-child(" + childNumber + ") > div > a > img");
    }

}
