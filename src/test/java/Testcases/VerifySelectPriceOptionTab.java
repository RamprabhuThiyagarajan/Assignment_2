package Testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestPages.SelectPriceOption;
import Utilities.ExcelReader;

public class VerifySelectPriceOptionTab {

	// Method that run before suite to setup the browser
	@BeforeSuite
	public void browserSetUp() {
		// Calling the method setUp in base class
		// for configuring browser and extent report
		TestBase.setUp();
	}

	// Method that run before test to configure report
	@BeforeTest
	public void reportConfiguration() {
		// Calling the method reportConfiguration in base class
		// for configuring extent report
		TestBase.reportConfiguration();
	}

	// Method that run after test to flush the report
	@AfterTest
	public void flushReport() {
		// Calling the method flushReport in base class
		// for flushing extent report
		TestBase.flushReport();
	}

	// Method that run after suite for quitting the browser
	@AfterSuite
	public void quitBrowser() {
		// Calling the method tearDown in base class
		// for quitting the browser
		TestBase.tearDown();
	}

	// Validating SelectPriceOption tab fields
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "dp")
	public void selectPriceOption(Hashtable<String, String> data) {
		try {
			// Checking whether this test is runnable
			// by reading runMode in Excel
			if (!(ExcelReader.isTestRunnable("selectPriceOption"))) {
				throw new SkipException("Skipping the test selectPriceOption as the run mode is NO " + data);
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Checking whether the test data runMode is yes
		if (!data.get("RunMode").equals("yes")) {
			throw new SkipException("Skipping the test data as the run mode is NO");
		}
		SelectPriceOption selectPriceOption = new SelectPriceOption();
		selectPriceOption.selectPriceOption();
		selectPriceOption.priceOption(data.get("PriceOption"));
		selectPriceOption.next();
	}
}
