package pl.trzmiel.qaassignment;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pl.trzmiel.qaassignment.entities.User;
import pl.trzmiel.qaassignment.pages.TopBar;
import pl.trzmiel.qaassignment.utilities.Configuration;
import pl.trzmiel.qaassignment.utilities.ScreenShotHelper;
import pl.trzmiel.qaassignment.utilities.SessionContext;
import pl.trzmiel.qaassignment.utilities.WebDriverHelper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static org.testng.ITestResult.FAILURE;

public abstract class TestBase {

    protected SessionContext sessionContext;

    @BeforeSuite
    public void setupWebDriverManager() {
        WebDriverHelper.setup();
    }

    @BeforeClass
    public void setUp() {
        this.sessionContext = new SessionContext(WebDriverHelper.createDriver());
        this.goToMainPageFirstTime();
    }

    private void goToMainPageFirstTime() {
        WebDriver driver = this.sessionContext.getDriver();
        driver.get(Configuration.getUrlWithAuthentication());
        driver.get(Configuration.getMainUrl());
    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) {
        WebDriver driver = this.sessionContext.getDriver();
        if (driver != null) {
            if (iTestResult.getStatus() == FAILURE) {
                new ScreenShotHelper(driver).takeAScreenshot(getScreenshotName(iTestResult));
            }
        }
    }

    @AfterClass
    public void tearDownClass() {
        WebDriver driver = this.sessionContext.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    private String getScreenshotName(ITestResult iTestResult) {
        return iTestResult.getTestClass().getRealClass().getSimpleName() + "_"
                + iTestResult.getMethod().getMethodName() + "_" + this.getTimestamp() + ".png";
    }

    private String getTimestamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return simpleDateFormat.format(timestamp);
    }

    protected void goToLink(String url) {
        this.sessionContext.getDriver().get(url);
    }

    protected void login(User user) {
        new TopBar(this.sessionContext).clickSignIn()
        .loginWithValidCredentials(user);

    }
}
