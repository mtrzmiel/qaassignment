package pl.trzmiel.qaassignment;

import org.testng.annotations.Test;
import pl.trzmiel.qaassignment.assertobjects.LoginPageAssert;
import pl.trzmiel.qaassignment.assertobjects.TopBarAssert;
import pl.trzmiel.qaassignment.pages.LoginPage;
import pl.trzmiel.qaassignment.pages.TopBar;
import pl.trzmiel.qaassignment.utilities.Configuration;

public class NotLoggedInUserCannotCreateArticle extends TestBase {


    @Test(description = "Test-0")
    public void buttonIsNotVisible() {
        this.thenTopBar()
                .newPostButtonShouldNotBeVisible();
    }

    @Test(description = "Test-0", priority = 1)
    public void directLink() {
        this.goToLink(Configuration.getMainUrl() + "#/editor");

        this.thenLoginPage()
                .pageIsOpened();
    }

    private TopBarAssert thenTopBar() {
        return new TopBarAssert(new TopBar(this.sessionContext));
    }

    private LoginPageAssert thenLoginPage() {
        return new LoginPageAssert(new LoginPage(this.sessionContext));
    }
}
