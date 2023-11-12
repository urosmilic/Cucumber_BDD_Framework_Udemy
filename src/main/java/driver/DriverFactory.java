package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if(webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }
    private static WebDriver createDriver() {
        WebDriver driver = null;
        switch (getBrowserType()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        if(driver != null) {
            driver.manage().window().maximize();
        }
        return driver;
    }
    private static String getBrowserType() {
        String browserType = null;
        Properties properties = new Properties();
        try{
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").trim().toLowerCase();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return browserType;
    }
    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}