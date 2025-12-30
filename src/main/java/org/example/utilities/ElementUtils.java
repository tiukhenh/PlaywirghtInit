package org.example.utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ElementUtils {
    private Page page;

    public ElementUtils(Page page) {
        this.page = page;
    }

    protected Locator waitUntilElementVisibleById(String id) {
        Locator element = page.locator("#" + id);
        element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return element;
    }

    protected Locator waitUntilElementVisibleByXpath(String xpath) {
        Locator element = page.locator("xpath=" + xpath);
        element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return element;
    }

    protected Locator waitUntilElementPresenceByXpath(String xpath) {
        Locator element = page.locator("xpath=" + xpath);
        element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        return element;
    }
}
