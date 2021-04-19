package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by Sripriya Srinivasan on 12/3/2018.
 */
@DefaultUrl("/login")
public class LoginPage extends PageObject {

    @FindBy(xpath="//*[@data-autotest-id='mr-form-login-btn-signin-1']")
    WebElementFacade signInBtn;

    @FindBy(id="email")
    WebElementFacade emailTxt;

    @FindBy(css="#password")
    WebElementFacade passwordTxt;

    @FindBy(css=".signup__error")
    WebElementFacade loginError;

    @FindBy(xpath = "//*[@data-autotest-id='dashboardTemplatesPanel__createNewBoard']")
    WebElementFacade createNewBoard;

    public boolean verifyLoginPageIsLoaded(){
        return signInBtn.isDisplayed();
    }

    public void clickSignInBtn(){
        signInBtn.waitUntilVisible().then().click();
    }

    public void loginWithDetails(String username,String password){
        emailTxt.waitUntilVisible().clear();
        emailTxt.waitUntilVisible().then().sendKeys(username);
        passwordTxt.waitUntilVisible().then().sendKeys(password);
        clickSignInBtn();
    }

    public String getErrorMessage(){
        return loginError.getText();
    }


}
