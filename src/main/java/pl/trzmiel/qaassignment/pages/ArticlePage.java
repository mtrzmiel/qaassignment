package pl.trzmiel.qaassignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.trzmiel.qaassignment.utilities.SessionContext;

public class ArticlePage {

    @FindBy(css = "div.container > h1")
    private WebElement titleLabel;
    @FindBy(css = "div.container.page > .article-content > div > div")
    private WebElement contextArea;

    private final SessionContext sessionContext;


    public ArticlePage(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
        PageFactory.initElements(sessionContext.getDriver(), this);
    }


    public String getTitle() {
        return this.titleLabel.getText();
    }

    public String getContent() {
        return this.contextArea.getText();
    }

    public boolean contains(String string) {
        return this.sessionContext.getDriver()
                .getPageSource().contains(string);
    }
}
