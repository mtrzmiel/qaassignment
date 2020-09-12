package pl.trzmiel.qaassignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.trzmiel.qaassignment.entities.Article;
import pl.trzmiel.qaassignment.utilities.SessionContext;

public class AddEditArticlePage {


    private final SessionContext sessionContext;

    @FindBy(css = "input[placeholder='Article Title']")
    private WebElement titleInput;

    @FindBy(css = "input[placeholder=\"What's this article about?\"]")
    private WebElement subTitleInput;

    @FindBy(css = "textarea[placeholder='Write your article (in markdown)']")
    private WebElement contentTextArea;

    @FindBy(css = "input[placeholder='Enter Tags")
    private WebElement tagsInput;

    @FindBy(xpath = "//button[contains(text(), 'Publish Article')]")
    private WebElement publishArticleButton;


    public AddEditArticlePage(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
        PageFactory.initElements(sessionContext.getDriver(), this);
    }

    public AddEditArticlePage fillArticleData(Article article) {
        this.setTitle(article.getTitle());
        this.setSubTitle(article.getSummary());
        this.setContext(article.getContext());
        this.setTags(article.getTag());
        return this;
    }

    private void setTitle(String title) {
        this.titleInput.clear();
        if (!title.isEmpty()) {
            this.titleInput.sendKeys(title);
        }
    }
    private void setSubTitle(String subtitle) {
        this.subTitleInput.clear();
        if (!subtitle.isEmpty()) {
            this.subTitleInput.sendKeys(subtitle);
        }
    }

    private void setContext(String context) {
        this.contentTextArea.clear();
        if (!context.isEmpty()) {
            this.contentTextArea.sendKeys(context);
        }
    }

    private void setTags(String tag) {
        this.tagsInput.clear();
        if (!tag.isEmpty()) {
            this.tagsInput.sendKeys(tag);
        }
    }

    public ArticlePage publishArticle() {
        this.publishArticleButton.click();
        return new ArticlePage(this.sessionContext);
    }


}
