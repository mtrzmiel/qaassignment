package pl.trzmiel.qaassignment.utilities;

import org.openqa.selenium.WebDriver;

public class SessionContext {

    private final WebDriver driver;

    public SessionContext(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }




}
