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
import TestPages.EnterInsurantData;
import Utilities.ExcelReader;

public class VerifyEnterInsurantDataTab {

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

	String hobbies;
	// Validating EnterInsurantData tab fields
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "dp")
	public void enterInsurantData(Hashtable<String, String> data) {
		try {
			// Checking whether this test is runnable
			// by reading runMode in Excel
			if (!(ExcelReader.isTestRunnable("enterInsurantData"))) {
				throw new SkipException("Skipping the test enterInsurantData as the run mode is NO");
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
		EnterInsurantData enterInsurantData = new EnterInsurantData();
		enterInsurantData.enterInsurantData();
		enterInsurantData.firstName(data.get("FirstName"));
		enterInsurantData.lastName(data.get("LastName"));
		enterInsurantData.dateOfBirth(data.get("DateOfBirth"));
		enterInsurantData.gender(data.get("Gender"));
		enterInsurantData.streetAddress(data.get("StreetAddress"));
		enterInsurantData.country(data.get("Country"));
		enterInsurantData.zipCode(data.get("ZipCode"));
		enterInsurantData.city(data.get("City"));
		enterInsurantData.occupation(data.get("Occupation"));

		// Getting list of hobbies and separating by comma  
		hobbies = data.get("Hobbies");
		ArrayList<String> List = new ArrayList<String>(Arrays.asList(hobbies.split(",")));
		for (String i : List) {
			enterInsurantData.hobbies(i);
		}
		enterInsurantData.website();
		//enterInsurantData.picture();
		enterInsurantData.next();
	}

}
