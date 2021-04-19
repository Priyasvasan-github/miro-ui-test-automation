package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.NoSuchElementException;

/**
 * Created by Sripriya Srinivasan on 12/3/2018.
 */
@DefaultUrl("/app/dashboard/")
public class DashBoardPage extends PageObject {

    @FindBy(xpath = "//*[@data-autotest-id='dashboardTemplatesPanel__createNewBoard']")
    WebElementFacade createNewBoard;

    public boolean verifyDashBoardPageIsLoaded(){
        try {
            return createNewBoard.isDisplayed();
        } catch (NoSuchElementException e) {
           return false;
        }
    }


}
