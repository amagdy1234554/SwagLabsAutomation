package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "src/test/resources/screenshots";
    private ScreenshotUtil() {
    }

    public static void capture(WebDriver driver, String stepName) {
        try {
            Path dir = Paths.get(SCREENSHOT_DIR);
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = stepName.replaceAll("[^a-zA-Z0-9-_]", "_") + "_" + timestamp + ".png";
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dest = dir.resolve(fileName);
            Files.copy(src.toPath(), dest);
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot for step [" + stepName + "]: " + e.getMessage());
        }
    }
}
