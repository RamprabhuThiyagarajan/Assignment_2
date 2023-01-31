package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static ExtentTest test;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark = new ExtentSparkReporter(
			System.getProperty("user.dir") + "\\reports\\extentReport.html");

	// Method for checking the webElement is present or not
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	static int index;
	static String substring;
	static By by;

	// Method for getting element
	public static By by(String locator) {
		index = locator.indexOf("_");
		substring = locator.substring(0, index);
		if (locator.endsWith("_CSS")) {
			by = By.cssSelector(substring);
		} else if (locator.endsWith("_XPATH")) {
			by = By.xpath(substring);
		} else if (locator.endsWith("_ID")) {
			by = By.id(substring);
		} else if (locator.endsWith("_LINK")) {
			by = By.linkText(substring);
		} else if (locator.endsWith("_CLASS")) {
			by = By.className(substring);
		}else if (locator.endsWith("_NAME")) {
			by = By.name(substring);
		}else if (locator.endsWith("_TAG")) {
			by = By.tagName(substring);
		}else if (locator.endsWith("_PARTIALLINK")) {
			by = By.partialLinkText(substring);
		}
		return by;
	}

	// Method for browser initialization and extent report configuration
	public static void setUp() {
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Browser configuration
			if (config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				driver = new EdgeDriver();
			}
			driver.get(config.getProperty("testUrl"));
			driver.manage().window().maximize();
			// Extent report configuration
			spark.config().setEncoding("utf-8");
			spark.config().setDocumentTitle("Extent Report");
			spark.config().setReportName("Ramprabhu");
			spark.config().setTheme(Theme.STANDARD);
			extent.setSystemInfo("Tester", "Ramprabhu");
			extent.setSystemInfo("Orgainzation", "propel");
		}
	}

	// Method for reportConfiguration
	public static void reportConfiguration() {
		extent.attachReporter(spark);
	}

	// Method for report flush function
	public static void flushReport() {
		extent.flush();
	}

	// Method for quitting the browser
	public static void tearDown() {
		driver.quit();
	}

}
