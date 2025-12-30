package steps.example.common;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.base.BaseTest;
import org.example.base.CommonAction;
import org.example.config.ConfigLoader;
import org.example.element.GooglePage;
import org.example.factory.PlaywrightFactory;
import org.example.utilities.VerificationUtils;

public class CommonBehavior extends VerificationUtils {
    private Page page = PlaywrightFactory.getPage();
    private CommonAction action = CommonAction.getInstance();
    private GooglePage googlePage = new GooglePage(page);

    @When("Navigate to the cms page")
    public void navigateToTheCmsPage() {
//        System.out.println( ConfigLoader.get("url"));
        action.navigate( ConfigLoader.get("url"));
        action.delay(2);
    }

    @And("Input user admin")
    public void inputUserAdmin() {
        action.inputValue(googlePage.inputEmail(),ConfigLoader.get("user"));
    }

    @And("Input password")
    public void inputPassword() {
        action.inputValue(googlePage.inputPassword(),ConfigLoader.get("pass"));
        action.delay(5);
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        action.click(googlePage.btnLogin());
    }

    @Then("Verify access to Dashboard page success")
    public void verifyAccessToDashboardPageSuccess() {
        verifyTrue(action.isElementDisplay(googlePage.dashboardMenu()),"Dashboard Menu should be displayed");
    }
}
