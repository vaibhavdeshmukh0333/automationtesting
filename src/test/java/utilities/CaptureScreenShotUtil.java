package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * CaptureScreenShotUtil class to capture screenshots during test execution.
 * Saves screenshots in target/screenshots folder.
 */
public class CaptureScreenShotUtil {

    private static final String SCREENSHOT_DIR = "target/screenshots/";

    /**
     * Takes a screenshot and saves it with the given name.
     * @param driver WebDriver instance.
     * @param screenshotName Name of the screenshot file.
     * @return Path to the saved screenshot.
     */
    public static String takeScreenShot(WebDriver driver, String screenshotName) {
        String screenshotPath = SCREENSHOT_DIR + screenshotName + ".png";
        try {
            // Create directory if not exists
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotPath);
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
