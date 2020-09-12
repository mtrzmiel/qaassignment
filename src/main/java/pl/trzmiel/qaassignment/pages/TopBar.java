package pl.trzmiel.qaassignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.trzmiel.qaassignment.utilities.SessionContext;

public class TopBar {

    private final SeleniumActions seleniumActions;
    private final SessionContext sessionContext;

    @FindBy(css = "li.nav-item a.nav-link[href='#/editor']")
    private WebElement newPostButton;
    @FindBy(css = "li.nav-item a.nav-link[href='#/login']")
    private WebElement signInButton;

    public TopBar(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
        PageFactory.initElements(sessionContext.getDriver(), this);
        seleniumActions = new SeleniumActions(sessionContext.getDriver());
    }

    public AddEditArticlePage clickNewPost() {
        this.newPostButton.click();
        return new AddEditArticlePage(this.sessionContext);
    }

    public boolean isNewPostButtonVisible() {
        return this.seleniumActions.isElementVisible(this.newPostButton);
    }

    public LoginPage clickSignIn() {
        this.signInButton.click();
        return new LoginPage(this.sessionContext);
    }
}
