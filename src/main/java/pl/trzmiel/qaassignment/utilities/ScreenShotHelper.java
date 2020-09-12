package pl.trzmiel.qaassignment.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShotHelper {

    private final WebDriver webDriver;

    public ScreenShotHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void takeAScreenshot(final String filename) {
        final File tmpScreenshotFile = ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.FILE);
        final Path directoryPath = Paths.get(".").resolve("./screenshots")
                .toAbsolutePath().normalize();
        try {
            FileUtils.forceMkdir(directoryPath.toFile());
            final Path filePath = directoryPath.resolve(filename);
            FileUtils.copyFile(tmpScreenshotFile, filePath.toFile());
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
