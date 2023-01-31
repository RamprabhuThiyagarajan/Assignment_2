package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestPages.EnterProductData;
import Utilities.ExcelReader;

public class VerifyEnterProductDataTab {
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

	String optionalProducts;
	// Validating EnterProductData tab fields
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "dp")
	public void enterProductData(Hashtable<String, String> data) {
		try {
			// Checking whether this test is runnable
			// by reading runMode in Excel
			if (!(ExcelReader.isTestRunnable("enterProductData"))) {
				throw new SkipException("Skipping the test enterProductData as the run mode is NO");
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Checking whether the test data runMode is yes
		if (!data.get("RunMode").equals("yes")) {
			throw new SkipException("Skipping the test data as the run mode is NO " + data);
		}
		EnterProductData enterProductData = new EnterProductData();
		enterProductData.enterProductData();
		enterProductData.StartDate(data.get("StartDate"));
		enterProductData.insuranceSum(data.get("InsuranceSum"));
		enterProductData.meritRating(data.get("MeritRating"));
		enterProductData.damageInsurance(data.get("DamageInsurance"));

		// Getting the list of OptionalProducts and separating by comma
		optionalProducts = data.get("OptionalProducts");
		ArrayList<String> List = new ArrayList<String>(Arrays.asList(optionalProducts.split(",")));
		for (String i : List) {
			enterProductData.optionalProducts(i);
		}
		enterProductData.courtesyCar(data.get("CourtesyCar"));
		enterProductData.next();
	}

}
