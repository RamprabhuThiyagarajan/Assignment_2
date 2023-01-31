package TestPages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.TestBase;

public class SelectPriceOption extends TestBase {

	// Method for selecting SelectPriceOption tab
	public void selectPriceOption() {
		WebElement elementSelectPriceOption = driver.findElement(by(OR.getProperty("SelectPriceOption")));
		elementSelectPriceOption.click();
		// Log for extent report
		test.log(Status.INFO, "Clicking on : SelectPriceOption");
	}

	// Method for validating the priceOptions radio button
	public void priceOption(String priceOption) {
		WebElement elementpriceOption = driver.findElement(by(OR.getProperty(priceOption)));
		try {
			// Asserting the priceOption radio button whether the button is displayed or not
			Assert.assertTrue(elementpriceOption.isDisplayed());
			test.log(Status.INFO, "PriceOption " + priceOption + " is displayed");
			// Asserting the priceOption radio button whether the button is selected or not
			Assert.assertFalse(elementpriceOption.isSelected());
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			// Doing click operation on radio button using JavascriptExecutor
			executor.executeScript("arguments[0].click();", elementpriceOption);
			test.log(Status.INFO, "PriceOption " + priceOption + " is selected");
		} catch (Throwable t) {
			test.log(Status.FAIL, t.getMessage());
		}
	}

	// Method for validating the next button
	public void next() {
		WebElement element = driver.findElement(by(OR.getProperty("PriceOptionCounter")));
		// Getting the no.of fields left empty in SelectPriceOption tab
		System.out.println("SelectPriceOption---->" + element.getText());
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement elementNext = wait
				.until(ExpectedConditions.elementToBeClickable(by(OR.getProperty("PriceOptionNext"))));
		elementNext.click();
		test.log(Status.INFO, "Clicking on : Next");
	}

	// Method for validating the previous button
	public void previous() {
		WebElement elementPrevious = driver.findElement(by(OR.getProperty("PriceOptionPrevious")));
		elementPrevious.click();
		test.log(Status.INFO, "Clicking on : Previous");
	}
}
