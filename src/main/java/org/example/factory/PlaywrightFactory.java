package org.example.factory;

import com.microsoft.playwright.*;

import java.util.List;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Page initBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(null)
        );
//        context = browser.newContext(
//                new Browser.NewContextOptions()
//                        .setViewportSize(1920, 1080)
//        );
        page = context.newPage();
        return page;
    }

    public static Page getPage() {
        return page;
    }

    public static void closeBrowser() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}

