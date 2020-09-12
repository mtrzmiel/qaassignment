package pl.trzmiel.qaassignment.assertobjects;

import pl.trzmiel.qaassignment.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageAssert {

    private final LoginPage loginPage;


    public LoginPageAssert(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void pageIsOpened(){
        assertThat(this.loginPage.isPageOpen())
                .as("Page is not opened")
                .isTrue();
    }


}
