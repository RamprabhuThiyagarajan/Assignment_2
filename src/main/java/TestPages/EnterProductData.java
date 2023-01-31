package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import Utilities.DatePicker;

public class EnterProductData extends TestBase {

	// Method for selecting EnterProductData tab
	public void enterProductData() {
		WebElement elementEnterProductData = driver.findElement(by(OR.getProperty("EnterProductData")));
		elementEnterProductData.click();
		// Log for extent report
		test.log(Status.INFO, "Clicking on : EnterProductData");
	}

	// Method for validating StartDate datePicker
	public void StartDate(String date) {
		WebElement elementStartDate = driver.findElement(by(OR.getProperty("ProductDatePicker")));
		elementStartDate.click();
		// Calling the pickDate method in DatePicker class(utility file)
		// for picking the date
		DatePicker.pickDate(date);
		test.info("Picked the date : " + date);
	}

	// Method for validating InsuranceSum dropdown list
	public void insuranceSum(String insuranceSum) {
		WebElement elementInsuranceSum = driver.findElement(by(OR.getProperty("InsuranceSum")));
		Select selectCountry = new Select(elementInsuranceSum);
		selectCountry.selectByVisibleText(insuranceSum);
		test.log(Status.INFO, "Value selected from InsuranceSum dropdown list : " + insuranceSum);
	}

	// Method for validating MeritRating dropdown list
	public void meritRating(String meritRating) {
		WebElement elementMeritRating = driver.findElement(by(OR.getProperty("MeritRating")));
		Select selectCountry = new Select(elementMeritRating);
		selectCountry.selectByVisibleText(meritRating);
		test.log(Status.INFO, "Value selected from MeritRating dropdown list : " + meritRating);
	}

	// Method for validating DamageInsurance dropdown list
	public void damageInsurance(String damageInsurance) {
		WebElement elementDamageInsurance = driver.findElement(by(OR.getProperty("DamageInsurance")));
		Select selectCountry = new Select(elementDamageInsurance);
		selectCountry.selectByVisibleText(damageInsurance);
		test.log(Status.INFO, "Value selected from DamageInsurance dropdown list : " + damageInsurance);
	}

	// Method for validating OptionalProducts check box
	public void optionalProducts(String optionalProduct) {
		WebElement elementOptionalProducts = driver.findElement(by(OR.getProperty(optionalProduct)));
		try {
			// Asserting the OptionalProducts check box whether it is displayed or not
			Assert.assertTrue(elementOptionalProducts.isDisplayed());
			test.log(Status.INFO, "OptionalProduct " + optionalProduct + " is displayed");
			// Asserting the OptionalProducts check box whether it is selected or not
			Assert.assertFalse(elementOptionalProducts.isSelected());
			elementOptionalProducts.click();
			test.log(Status.INFO, "OptionalProduct " + optionalProduct + " is selected");
		} catch (Throwable t) {
			test.log(Status.FAIL, t.getMessage());
		}
	}

	// Method for validating courtesyCar dropdown list
	public void courtesyCar(String courtesyCar) {
		WebElement elementCourtesyCar = driver.findElement(by(OR.getProperty("CourtesyCar")));
		Select selectCountry = new Select(elementCourtesyCar);
		selectCountry.selectByVisibleText(courtesyCar);
		test.log(Status.INFO, "Value selected from CourtesyCar dropdown list : " + courtesyCar);
	}

	// Method for validating previous button
	public void previous() {
		WebElement elementPrevious = driver.findElement(by(OR.getProperty("ProductPrevious")));
		elementPrevious.click();
		test.log(Status.INFO, "Clicking on : Previous");
	}

	// Method for validating next button
	public void next() {
		WebElement element = driver.findElement(by(OR.getProperty("ProductDataCounter")));
		// Getting the no.of fields left empty in EnterProductData tab
		System.out.println("EnterProductData---->" + element.getText());
		WebElement elementNext = driver.findElement(by(OR.getProperty("ProductNext")));
		elementNext.click();
		test.log(Status.INFO, "Clicking on : Next");
	}
}
