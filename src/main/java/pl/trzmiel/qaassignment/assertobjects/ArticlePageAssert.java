package pl.trzmiel.qaassignment.assertobjects;

import pl.trzmiel.qaassignment.pages.ArticlePage;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticlePageAssert {

    private final ArticlePage articlePage;

    public ArticlePageAssert(ArticlePage articlePage) {
        this.articlePage = articlePage;
    }


    public ArticlePageAssert titleEquals(String title) {
        assertThat(this.articlePage.getTitle())
                .as("Title is different than expected")
                .isEqualTo(title);
        return this;
    }

    public ArticlePageAssert contentEquals(String context) {
        assertThat(this.articlePage.getContent())
                .as("Context is different than expected")
                .isEqualTo(context);
        return this;
    }

    public ArticlePageAssert pageContains(String text) {
        assertThat(this.articlePage.contains(text))
                .as("Text: \"" + text + "\" is not in the content of the page")
                .isTrue();
        return this;
    }
}
