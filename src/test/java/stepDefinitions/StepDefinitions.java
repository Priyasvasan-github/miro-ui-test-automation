package stepDefinitions;

import utils.GetTestProperties;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import pageMethods.LoginPageMethods;
import pageObjects.DashBoardPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Sripriya srinivasan on 12/3/2018.
 */
public class StepDefinitions {

    @Steps
    LoginPageMethods loginPageMethods;

    @Steps
    DashBoardPage dashBoardPage;

    @Given("^A (.*) user is accessing Miro login portal$")
    public void accessLoginPortal(String userType) {
        loginPageMethods.launch();
        GetTestProperties getTestProperties = new GetTestProperties();
        Serenity.setSessionVariable("username").to(getTestProperties.getValue(userType+"Email"));
        Serenity.setSessionVariable("password").to(getTestProperties.getValue(userType+"Password"));
        assertThat(loginPageMethods.isLoginPageDisplayed()).as("verify login page is loaded").isTrue();
    }


    @When("^He attempts to Login with his credentials$")
    public void login() {
        loginPageMethods.login(Serenity.sessionVariableCalled("username"),Serenity.sessionVariableCalled("password"));
    }

    @Then("^User (.*) authorized into the portal$")
    public void verifyLogin(String status) {
        if(status.equalsIgnoreCase("is")){
            assertThat(dashBoardPage.verifyDashBoardPageIsLoaded()).as("verify dash board page is loaded").isTrue();
        }else{
            assertThat(loginPageMethods.isLoginPageDisplayed()).as("Authorization failed so still in Login page").isTrue();
        }
    }

    @Then("^(.*) is displayed as expected$")
    public void verifyErrorMessage(String errorMessage) {

            assertThat(loginPageMethods.getErrorMessage().contains(errorMessage)).as("verification of Error message").isTrue();


    }




}
