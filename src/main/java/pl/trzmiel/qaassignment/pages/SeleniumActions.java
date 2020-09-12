package pl.trzmiel.qaassignment.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.trzmiel.qaassignment.utilities.Configuration;

public class SeleniumActions {

    private final WebDriver driver;
    //private final WebDriverWait webDriverWait;

    public SeleniumActions(WebDriver driver) {
        this.driver = driver;
        //this.webDriverWait = new WebDriverWait(driver, Configuration.getExplicitWait());
    }

    public boolean isElementVisible(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 3);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
