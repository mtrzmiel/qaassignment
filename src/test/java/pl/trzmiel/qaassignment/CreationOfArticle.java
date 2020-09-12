package pl.trzmiel.qaassignment;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.trzmiel.qaassignment.assertobjects.ArticlePageAssert;
import pl.trzmiel.qaassignment.entities.Article;
import pl.trzmiel.qaassignment.pages.ArticlePage;
import pl.trzmiel.qaassignment.pages.TopBar;
import pl.trzmiel.qaassignment.utilities.Configuration;

public class CreationOfArticle extends TestBase {

    private Article article;
    private ArticlePage articlePage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        super.login(Configuration.getUser());

        this.article = new Article.ArticleBuilder()
                .setTitle("Fine title")
                .setSummary("Subtitle")
                .setContext("Context is a little bit longer, than rest.")
                .setTag("coolTag")
                .build();
    }

    @Test
    public void createArticle() {
        this.articlePage = new TopBar(this.sessionContext).clickNewPost()
                .fillArticleData(this.article)
                .publishArticle();
        this.thenArticlePage()
                .titleEquals(this.article.getTitle())
                .contentEquals(this.article.getContext())
                .pageContains(this.article.getTag()) // According to scenario I created tag and summary should be visible as well
                .pageContains(this.article.getSummary());
    }

    private ArticlePageAssert thenArticlePage() {
        return new ArticlePageAssert(this.articlePage);
    }
}
