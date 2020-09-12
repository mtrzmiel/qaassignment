package pl.trzmiel.qaassignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.trzmiel.qaassignment.utilities.SessionContext;

public class LoginPage {

    @FindBy(css = "input[placeholder='Username']")
    private WebElement usernameInput;
    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Sign in')]")
    private WebElement loginButton;

    private final SeleniumActions seleniumActions;

    public LoginPage(SessionContext sessionContext) {
        PageFactory.initElements(sessionContext.getDriver(), this);
        seleniumActions = new SeleniumActions(sessionContext.getDriver());
    }


    public boolean isPageOpen() {
        return this.seleniumActions.isElementVisible(this.loginButton);
    }

}
