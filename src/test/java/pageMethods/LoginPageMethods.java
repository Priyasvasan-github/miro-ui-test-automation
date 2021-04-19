package pageMethods;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.yecht.Data;
import pageObjects.LoginPage;

/**
 * Created by Sripriya Srinivasan on 12/3/2018.
 */
public class LoginPageMethods {

    private LoginPage loginPage;

    @Step
    public void launch(){
        loginPage.open();
    }

    @Step
    public boolean isLoginPageDisplayed(){
        return loginPage.verifyLoginPageIsLoaded();
    }

    @Step
    public void login(String username, String password){
        loginPage.loginWithDetails(username,password);
    }

    @Step
    public String getErrorMessage(){
        return loginPage.getErrorMessage();
    }

}
