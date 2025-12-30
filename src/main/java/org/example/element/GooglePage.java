package org.example.element;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utilities.ElementUtils;

import static org.example.base.BaseTest.page;

public class GooglePage extends ElementUtils{

    public GooglePage(Page page) {
        super(page);
    }

    public void open() {
        page.navigate("https://www.google.com");
    }

    public void search(String keyword) {
        page.fill("textarea[name='q']", keyword);
        page.keyboard().press("Enter");
    }

    public boolean isResultDisplayed() {
        return page.locator("#search").isVisible();
    }
    public Locator inputEmail() {
        return waitUntilElementVisibleByXpath("//input[@id='email']");
    }

    public Locator inputPassword() {
        return waitUntilElementVisibleByXpath("//input[@id='password']");
    }

    public Locator btnLogin() {
        return waitUntilElementVisibleByXpath("//button[normalize-space()='Login']");
    }
    public Locator dashboardMenu() {
        return waitUntilElementVisibleByXpath("//ul[@id='main-menu']//li//span[text()='Dashboard']//ancestor::a");
    }
}
