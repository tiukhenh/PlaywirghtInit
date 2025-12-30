package org.example.base;

import com.microsoft.playwright.Locator;
import org.example.factory.PlaywrightFactory;

public class CommonAction {


    private static class SingletonCommonAction {
        private static CommonAction INSTANCE = new CommonAction();
    }

    public static CommonAction getInstance() {
        return SingletonCommonAction.INSTANCE;
    }

    public void navigate(String url) {
        PlaywrightFactory.getPage().navigate(url);
    }

    public void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void inputValue(Locator e, String text) {
        e.click();
        e.clear();
        e.fill(text);
    }
    public void setBorderForElement(Locator e) {
        try {
            e.evaluate("element => element.style.border = '4px dotted red'");
        } catch (Exception ex) {
            System.out.println("Cannot set border to element: " + e + ", ex: " + ex);
        }
    }
    public void click(Locator e) {
        try {
            setBorderForElement(e);
        } catch (Exception ex) {
            // ignore
        }
        e.click();
        System.out.println("    Clicked on element: '" + e + "'");
    }
    public boolean isElementDisplay(Locator e) {
        boolean isDisplay = false;
        try {
            isDisplay = e.isVisible();
            if (isDisplay) {
                System.out.println("    '" + e + "' is displayed");
            } else {
                System.out.println("    '" + e + "' is not displayed");
            }
        } catch (Exception ex) {
            System.out.println("    Exception while checking visibility of element: " + e + ", ex=" + ex);
        }
        return isDisplay;
    }
}
