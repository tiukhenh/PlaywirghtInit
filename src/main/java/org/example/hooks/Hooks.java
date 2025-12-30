package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.factory.PlaywrightFactory;
import org.example.base.BaseTest;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.example.factory.PlaywrightFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Hooks {

    @Before
    public void setUp() {
        BaseTest.page = PlaywrightFactory.initBrowser();
    }
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @After
    public void afterScenario(Scenario scenario) {
        Page page = PlaywrightFactory.getPage();

        if (scenario.isFailed()) {
            log.error("        " + scenario.getName() + " is FAILED :((");

            try {
                // Screenshot bytes
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                        .setFullPage(true)
                );

                // Attach to Cucumber report
                scenario.attach(screenshot, "image/png", scenario.getName());

                // Optional: save locally
                String fileName = "target/screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_") + ".png";
                Files.createDirectories(Paths.get("target/screenshots/"));
                Files.write(Paths.get(fileName), screenshot, StandardOpenOption.CREATE);

            } catch (Exception e) {
                log.error("Failed to take screenshot", e);
            }

        } else {
            log.info("Status test script: " + scenario.getStatus());
            log.info("        " + scenario.getName() + " is PASSED <3");
        }

//        Block JVM exit browser
//        new java.util.Scanner(System.in).nextLine();

        PlaywrightFactory.closeBrowser();
    }


}
