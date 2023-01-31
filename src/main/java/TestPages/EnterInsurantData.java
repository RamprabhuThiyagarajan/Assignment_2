package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

import Base.TestBase;

public class EnterInsurantData extends TestBase {

	// Method for selecting EnterInsurantData tab
	public void enterInsurantData() {
		WebElement elementEnterInsurantData = driver.findElement(by(OR.getProperty("EnterInsurantData")));
		elementEnterInsurantData.click();
		// Log for extent report
		test.log(Status.INFO, "Clicking on : EnterInsurantData");
	}

	// Method for validating FirstName text box
	public void firstName(String firstName) {
		WebElement elementFirstName = driver.findElement(by(OR.getProperty("FirstName")));
		elementFirstName.sendKeys(firstName);
		test.log(Status.INFO, "Typing in the field : FirstName" + "<br>" + "Entered FirstName : " + firstName);
	}

	// Method for validating LastName text box
	public void lastName(String lastName) {
		WebElement elementLastName = driver.findElement(by(OR.getProperty("LastName")));
		elementLastName.sendKeys(lastName);
		test.log(Status.INFO, "Typing in the field : LastName" + "<br>" + "Entered LastName : " + lastName);
	}

	// Method for validating dateOfBirth text box
	public void dateOfBirth(String date) {
		WebElement elementDateOfBirth = driver.findElement(by(OR.getProperty("DateOfBirth")));
		elementDateOfBirth.sendKeys(OR.getProperty("dateOfBirth"));
		test.log(Status.INFO,
				"Typing in the field : DateOfBirth" + "<br>" + "Entered date : " + OR.getProperty("dateOfBirth"));
	}

	// Method for validating Gender radio button
	public void gender(String gender) {
		WebElement elementGender = driver.findElement(by(OR.getProperty(gender)));
		try {
			// Asserting the gender radio button whether it is displayed or not
			Assert.assertTrue(elementGender.isDisplayed());
			test.log(Status.INFO, "Gender " + gender + " is displayed");
			// Asserting the gender radio button whether it is selected or not
			Assert.assertFalse(elementGender.isSelected());
			elementGender.click();
			test.log(Status.INFO, "Gender " + gender + " is selected");
		} catch (Throwable t) {
			test.log(Status.FAIL, t.getMessage());
		}
	}

	// Method for validating Street Address text box
	public void streetAddress(String streetAddress) {
		WebElement elementStreetAddress = driver.findElement(by(OR.getProperty("StreetAddress")));
		elementStreetAddress.sendKeys(streetAddress);
		test.log(Status.INFO, "Typing in the field : StreetAddress" + "<br>" + "Entered Address : " + streetAddress);
		// Getting the error message element of StreetAddress text box
		WebElement StreetAddressErrorMessage = driver.findElement(by(OR.getProperty("StreetAddressErrorMessage")));
		// Getting the value entered in Street Address text box
		String value = elementStreetAddress.getAttribute("value");
		// Getting the size of the value
		int size = value.length();
		// Condition for validating the error message
		if (size <= 2) {
			// Getting the text in error message
			String errorMessageText = StreetAddressErrorMessage.getAttribute("innerHTML");
			try {
				// Asserting the Street Address Error Message whether it is displayed or not
				Assert.assertTrue(StreetAddressErrorMessage.isDisplayed());
				test.log(Status.FAIL, "Error message is displayed");
				try {
					// Asserting the text in Street Address Error Message
					Assert.assertTrue(errorMessageText.equals("Must be at least 3 characters long"));
					test.log(Status.FAIL, "Error message has text : " + errorMessageText);
				} catch (Throwable t) {
					test.log(Status.FAIL, "Error message is not as expected : " + "<br>" + "Error message has text : "
							+ errorMessageText);
				}
			} catch (Throwable t) {
				test.log(Status.FAIL, "Error message not displayed");
			}
		}
	}

	// Method for validating country dropdown list
	public void country(String country) {
		WebElement elementCountry = driver.findElement(by(OR.getProperty("Country")));
		Select selectCountry = new Select(elementCountry);
		selectCountry.selectByVisibleText(country);
		test.log(Status.INFO, "Value selected from Country dropdown list : " + country);
	}

	// Method for validating zipCode text box
	public void zipCode(String zipCode) {
		WebElement elementZipCode = driver.findElement(by(OR.getProperty("ZipCode")));
		elementZipCode.sendKeys(zipCode);
		test.log(Status.INFO, "Typing in the field : Zip Code" + "<br>" + "Entered value : " + zipCode);
	}

	// Method for validating city text box
	public void city(String city) {
		WebElement elementCity = driver.findElement(by(OR.getProperty("City")));
		elementCity.sendKeys(city);
		test.log(Status.INFO, "Typing in the field : City" + "<br>" + "Entered City : " + city);
	}

	// Method for validating occupation dropdown list
	public void occupation(String occupation) {
		WebElement elementOccupation = driver.findElement(by(OR.getProperty("Occupation")));
		Select selectCountry = new Select(elementOccupation);
		selectCountry.selectByVisibleText(occupation);
		test.log(Status.INFO, "Value selected from Occupation dropdown list : " + occupation);
	}

	// Method for validating hobbies check box
	public void hobbies(String hobbie) {
		WebElement elementHobbies = driver.findElement(by(OR.getProperty(hobbie)));
		try {
			// Asserting the hobbies check box whether it is displayed or not
			Assert.assertTrue(elementHobbies.isDisplayed());
			test.log(Status.INFO, "Hobbie " + hobbie + " is displayed");
			// Asserting the hobbies check box whether it is selected or not
			Assert.assertFalse(elementHobbies.isSelected());
			elementHobbies.click();
			test.log(Status.INFO, "Hobbie " + hobbie + " is selected");
		} catch (Throwable t) {
			test.log(Status.FAIL, t.getMessage());
		}
	}

	// Method for validating website text box
	public void website() {
		WebElement elementHobbies = driver.findElement(by(OR.getProperty("Website")));
		elementHobbies.sendKeys(OR.getProperty("Url"));
		// Generating the entered URL as external link in extent report
		test.log(Status.INFO, "Typing in the field : Website" + "<br>" + "Entered URL : " + "<a href='"
				+ OR.getProperty("Url") + "'>" + OR.getProperty("Url") + "</a>");
	}

	// Method to validate picture uploading
	public void picture() {
		WebElement UploadImg = driver.findElement(by(OR.getProperty("Open")));
		UploadImg.click();
		WebElement frame = driver.switchTo().activeElement();
		frame.sendKeys(OR.getProperty("Path"));
		// Attaching the uploading image in extent report
		Media mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(OR.getProperty("Path")).build();
		test.info("Image Uploaded", mediaModel);
	}

	// Method to validate next button
	public void next() {
		WebElement element = driver.findElement(by(OR.getProperty("InsurantDataCounter")));
		// Getting the no.of fields left empty in EnterInsurantData tab
		System.out.println("EnterInsurantData---->" + element.getText());
		WebElement elementNext = driver.findElement(by(OR.getProperty("InsurantNext")));
		elementNext.click();
		test.log(Status.INFO, "Clicking on : Next");
	}

	// Method to validate previous button
	public void previous() {
		WebElement elementPrevious = driver.findElement(by(OR.getProperty("PriceOptionNext")));
		elementPrevious.click();
		test.log(Status.INFO, "Clicking on : Previous");
	}
}
