package pl.trzmiel.qaassignment.assertobjects;

import pl.trzmiel.qaassignment.pages.TopBar;

import static org.assertj.core.api.Assertions.assertThat;

public class TopBarAssert {

    private final TopBar topBar;

    public TopBarAssert(TopBar topBar) {
        this.topBar = topBar;
    }

    public void newPostButtonShouldNotBeVisible() {
        assertThat(this.topBar.isNewPostButtonVisible())
                .as("\"New Post\" button is visible")
                .isFalse();
    }
}
