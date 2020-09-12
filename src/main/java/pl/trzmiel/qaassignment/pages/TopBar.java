package pl.trzmiel.qaassignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.trzmiel.qaassignment.utilities.SessionContext;

public class TopBar {

    @FindBy(css = "li.nav-item a.nav-link[href='#/editor']")
    private WebElement newPostButton;

    private final SeleniumActions seleniumActions;


    public TopBar(SessionContext sessionContext) {
        PageFactory.initElements(sessionContext.getDriver(), this);
        seleniumActions = new SeleniumActions(sessionContext.getDriver());
    }

    public void clickNewPost(){
        this.newPostButton.click();
    }

    public boolean isNewPostButtonVisible() {
        return this.seleniumActions.isElementVisible(this.newPostButton);
    }

}
