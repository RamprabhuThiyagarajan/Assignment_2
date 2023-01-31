package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import Utilities.DatePicker;

public class EnterVehicleData extends TestBase {

	// Method for selecting EnterVehicleData tab
	public void enterVehicleData() {
		WebElement elementEnterVehicleData = driver.findElement(by(OR.getProperty("EnterVehicleData")));
		elementEnterVehicleData.click();
		// Log for extent report
		test.log(Status.INFO, "Clicking on : EnterVehicleData");
	}

	// Method for validating make dropdown list
	public void make(String make) {
		WebElement elementMake = driver.findElement(by(OR.getProperty("Make")));
		WebElement defaultMake = driver.findElement(by(OR.getProperty("DefaultMake")));
		// Getting the default option in the make dropdown list
		String defaultMakeText = defaultMake.getText();
		try {
			// Asserting the default option in make dropdown list
			Assert.assertTrue(defaultMakeText.equals(OR.getProperty("DefaultMakeText")));
			test.log(Status.PASS, "Default option in Make dropdown list  : " + defaultMakeText);
		} catch (Throwable t) {
			test.log(Status.FAIL, t.getMessage());
			test.log(Status.FAIL, "Default option in Make dropdown list : " + defaultMakeText);
		}
		Select select = new Select(elementMake);
		select.selectByVisibleText(make);
		test.log(Status.INFO, "Value selected from Make dropdown list : " + make);
	}

	// Method for validating EnginePerformance text box
	public void enginePerformance(String enginePerformance) {
		WebElement elementEnginePerformance = driver.findElement(by(OR.getProperty("EnginePerformance")));
		WebElement errorMessage = driver.findElement(by(OR.getProperty("EnginePerformanceErrorMessage")));
		elementEnginePerformance.sendKeys(enginePerformance);
		test.log(Status.INFO,
				"Typing in the field : Engine Performance" + "<br>" + "Entered value : " + enginePerformance);
		// Getting the text in error message
		String errorMessageText = errorMessage.getAttribute("innerHTML");
		try {
			// Asserting the Engine Performance Error Message whether it is displayed or not
			Assert.assertTrue(errorMessage.isDisplayed());
			test.log(Status.FAIL, "Error message is displayed");
			try {
				// Asserting the text in Engine Performance Error Message
				Assert.assertTrue(errorMessageText.equals(OR.getProperty("EnginePerformanceErrorMessageText")));
				test.log(Status.FAIL, "Error message has text : " + errorMessageText);
			} catch (Throwable t) {
				test.log(Status.FAIL, "Error message text is not as expected" + "<br>" + "Error message has text : "
						+ errorMessageText);
			}
		} catch (Throwable t) {
			test.log(Status.INFO, "Error message not displayed");
		}
	}

	// Method for validating NumberOfSeats dropdown list
	public void numberOfSeats(String numberOfSeats) {
		WebElement elementNumberOfSeats = driver.findElement(by(OR.getProperty("NumberOfSeats")));
		Select select = new Select(elementNumberOfSeats);
		select.selectByVisibleText(numberOfSeats);
		test.log(Status.INFO, "Value selected from Number Of Seats dropdown list : " + numberOfSeats);
	}

	// Method for validating FuelType dropdown list
	public void fuelType(String fuelType) {
		WebElement elementFuelType = driver.findElement(by(OR.getProperty("FuelType")));
		Select select = new Select(elementFuelType);
		select.selectByVisibleText(fuelType);
		test.log(Status.INFO, "Value selected from Fuel Type dropdown list : " + fuelType);
	}

	// Method for validating FuelType dropdown list
	public void listPrice(String listPrice) {
		WebElement elementListPrice = driver.findElement(by(OR.getProperty("ListPrice")));
		WebElement errorMessage = driver.findElement(by(OR.getProperty("ListPriceErrorMessage")));
		elementListPrice.sendKeys(listPrice);
		test.log(Status.INFO, "Typing in the field : List Price" + "<br>" + "Entered value : " + listPrice);
		// Converting the listPrice string to integer
		int price = Integer.parseInt(listPrice);
		// Condition for displaying error message
		if (!(price >= 500 && price <= 1000)) {
			// Getting the text in error message
			String errorMessageText = errorMessage.getAttribute("innerHTML");
			try {
				// Asserting the Engine Performance Error Message whether it is displayed or not
				Assert.assertTrue(errorMessage.isDisplayed());
				test.log(Status.FAIL, "Error message is displayed");
				try {
					// Asserting the text in List Price Error Message
					Assert.assertTrue(errorMessageText.equals(OR.getProperty("ListPriceErrorMessageText")));
					test.log(Status.FAIL, "Error message has text : " + errorMessageText);
				} catch (Throwable t) {
					test.log(Status.FAIL, "Error message is not as expected" + "<br>" + "Error message has text : "
							+ errorMessageText);
				}
			} catch (Throwable t) {
				test.log(Status.FAIL, "Error message not displayed");
			}
		}
	}

	// Method for validating LicensePlate Number text box
	public void licensePlateNumber(String licensePlateNumber) {
		WebElement elementLicensePlateNumber = driver.findElement(by(OR.getProperty("LicensePlateNumber")));
		elementLicensePlateNumber.sendKeys(licensePlateNumber);
		test.log(Status.INFO,
				"Typing in the field : LicensePlateNumber" + "<br>" + "Entered date : " + licensePlateNumber);
	}

	// Method for validating AnnualMileage text box
	public void annualMileage(String annualMileage) {
		WebElement elementAnnualMileage = driver.findElement(by(OR.getProperty("AnnualMileage")));
		elementAnnualMileage.sendKeys(annualMileage);
		test.log(Status.INFO, "Typing in the field : AnnualMileage" + "<br>" + "Entered date : " + annualMileage);
	}

	// Method for validating datePicker
	public void datePicker(String date) {
		WebElement elementVehicleDatePicker = driver.findElement(by(OR.getProperty("VehicleDatePicker")));
		elementVehicleDatePicker.click();
		// Calling the pickDate method in DatePicker class(utility file)
		// for picking the date
		DatePicker.pickDate(date);
		test.info("Picked the date : " + date);
	}

	// Method for validating next button
	public void next() {
		WebElement element = driver.findElement(by(OR.getProperty("VehicleDataCounter")));
		// Getting the no.of fields left empty in EnterVehicleData tab
		System.out.println("EnterVehicleData---->" + element.getText());
		WebElement elementVehicleNext = driver.findElement(by(OR.getProperty("VehicleNext")));
		elementVehicleNext.click();
		test.info("Clicking on : Next");
	}
}
