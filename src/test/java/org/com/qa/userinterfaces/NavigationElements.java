package org.com.qa.userinterfaces;

public class NavigationElements {

    public static String navButtonSelector(String navReference) {
        return "a.nav-link[href='" + navReference + ".html']";
    }

}
