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
import TestPages.SendQuote;
import Utilities.ExcelReader;

public class VerifySendQuoteTab {

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

	// Validating SendQuote tab fields
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "dp")
	public void sendQuote(Hashtable<String, String> data) {
		try {
			// Checking whether this test is runnable
			// by reading runMode in Excel
			if (!(ExcelReader.isTestRunnable("sendQuote"))) {
				throw new SkipException("Skipping the test sendQuote as the run mode is NO");
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
		SendQuote sendQuote = new SendQuote();
		sendQuote.sendQuote();
		sendQuote.email(data.get("Email"));
		sendQuote.phone(data.get("Phone"));
		sendQuote.username(data.get("UserName"));
		sendQuote.password(data.get("Password"));
		sendQuote.confirmPassword(data.get("ConfirmPassword"));
		sendQuote.comments(data.get("Comments"));
		sendQuote.send();
	}
}
