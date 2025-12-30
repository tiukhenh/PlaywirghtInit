package steps.example.google;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.base.BaseTest;
import org.example.base.CommonAction;
import org.example.element.GooglePage;

import static org.testng.Assert.assertTrue;

public class GoogleSteps{
    private CommonAction action = CommonAction.getInstance();

    private GooglePage googlePage;


    @Given("user opens google page")
    public void user_opens_google_page() {
        googlePage = new GooglePage(BaseTest.page);
        googlePage.open();
    }

    @When("user searches {string}")
    public void searchKeyword(String keyword) {
        googlePage.search(keyword);
        action.delay(5);

    }

    @Then("search result should be displayed")
    public void verifyResult() {
        assertTrue(googlePage.isResultDisplayed());
    }


}
