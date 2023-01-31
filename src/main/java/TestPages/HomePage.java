package TestPages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.TestBase;

public class HomePage extends TestBase {

	// Method for validating home page title
	public void homePageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		try {
			// Asserting the home page title
			Assert.assertEquals(actualTitle, expectedTitle);
			// Log for extent report
			test.log(Status.PASS, "Application title is same as expected" + "<br>" + "ActualTitle is : " + actualTitle);
		} catch (Throwable t) {
			// Log for extent report
			test.log(Status.FAIL, "Application title is not same as expected");
			test.log(Status.FAIL, "ActualTitle is : " + actualTitle + "<br>" + "Expected : " + expectedTitle);
		}
	}

	// Method for validating automobile tab button
	public void automobile() {
		WebElement elementAutomobile = driver.findElement(by(OR.getProperty("Automobile")));
		elementAutomobile.click();
		test.log(Status.INFO, "Clicking on : Automobile");
	}

	// Method for validating truck tab button
	public void truck() {
		WebElement elementTruck = driver.findElement(by(OR.getProperty("Truck")));
		elementTruck.click();
		test.log(Status.INFO, "Clicking on : Truck");
	}

	// Method for validating motorcycle tab button
	public void motorcycle() {
		WebElement elementMotorcycle = driver.findElement(by(OR.getProperty("Motorcycle")));
		elementMotorcycle.click();
		test.log(Status.INFO, "Clicking on : Motorcycle");
	}

	// Method for validating camper tab button
	public void camper() {
		WebElement elementCamper = driver.findElement(by(OR.getProperty("Camper")));
		elementCamper.click();
		test.log(Status.INFO, "Clicking on : Camper");
	}

}
