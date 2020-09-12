package pl.trzmiel.qaassignment.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {


    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments(
                String.format("--window-size=%s,%s", Configuration.getWidth(), Configuration.getHeight()));

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Configuration.getImplicitWait(), TimeUnit.SECONDS);
        return driver;
    }


}
