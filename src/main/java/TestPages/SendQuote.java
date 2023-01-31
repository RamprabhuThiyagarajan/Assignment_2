package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.TestBase;

public class SendQuote extends TestBase {

	// Method for selecting SelectPriceOption tab
	public void sendQuote() {
		WebElement elementSendQuote = driver.findElement(by(OR.getProperty("SendQuote")));
		elementSendQuote.click();
		// Log for extent report
		test.log(Status.INFO, "Clicking on : SendQuote");
	}

	// Method for validating Email text box
	public void email(String email) {
		WebElement elementEmail = driver.findElement(by(OR.getProperty("E-Mail")));
		elementEmail.sendKeys(email);
		test.log(Status.INFO, "Typing in the field : E-Mail" + "<br>" + "Entered value : " + email);
		WebElement emailErrorMessage = driver.findElement(by(OR.getProperty("EmailErrorMessage")));
		// Getting the text in error message
		String errorMessageText = emailErrorMessage.getAttribute("innerHTML");
		try {
			// Asserting the email Error Message whether it is displayed or not
			Assert.assertTrue(emailErrorMessage.isDisplayed());
			test.log(Status.FAIL, "Error message is displayed");
			try {
				// Asserting the text in email Error Message
				Assert.assertTrue(errorMessageText.equals(OR.getProperty("EmailErrorMessageText")));
				test.log(Status.FAIL, "Error message has text : " + errorMessageText);
			} catch (Throwable t) {
				test.log(Status.FAIL, "Error message is not as expected : " + "<br>" + "Error message has text : "
						+ errorMessageText);
			}
		} catch (Throwable t) {
			test.log(Status.INFO, "Error message not displayed");
		}
	}

	// Method for validating phone text box
	public void phone(String phone) {
		WebElement elementPhone = driver.findElement(by(OR.getProperty("Phone")));
		elementPhone.sendKeys(phone);
		test.log(Status.INFO, "Typing in the field : Phone" + "<br>" + "Entered value : " + phone);
	}

	// Method for validating username text box
	public void username(String username) {
		WebElement elementUsername = driver.findElement(by(OR.getProperty("Username")));
		elementUsername.sendKeys(username);
		test.log(Status.INFO, "Typing in the field : Username" + "<br>" + "Entered value : " + username);
		WebElement usernameErrorMessage = driver.findElement(by(OR.getProperty("UsernameErrorMessage")));
		// Getting the text in error message
		String errorMessageText = usernameErrorMessage.getAttribute("innerHTML");
		try {
			// Asserting the username Error Message whether it is displayed or not
			Assert.assertTrue(usernameErrorMessage.isDisplayed());
			test.log(Status.FAIL, "Error message is displayed");
			try {
				// Asserting the text in username Error Message
				Assert.assertTrue(errorMessageText.equals(OR.getProperty("UsernameErrorMessageText")));
				test.log(Status.FAIL, "Error message has text : " + errorMessageText);
			} catch (Throwable t) {
				test.log(Status.FAIL, "Error message is not as expected : " + "<br>" + "Error message has text : "
						+ errorMessageText);
			}
		} catch (Throwable t) {
			test.log(Status.INFO, "Error message not displayed");
		}
	}

	// Method for validating password text box
	public void password(String password) {
		WebElement elementPassword = driver.findElement(by(OR.getProperty("Password")));
		elementPassword.sendKeys(password);
		test.log(Status.INFO, "Typing in the field : Password" + "<br>" + "Entered value : " + password);
		WebElement passwordErrorMessage = driver.findElement(by(OR.getProperty("PasswordErrorMessage")));
		// Getting the text in error message
		String errorMessageText = passwordErrorMessage.getAttribute("innerHTML");
		try {
			// Asserting the password Error Message whether it is displayed or not
			Assert.assertTrue(passwordErrorMessage.isDisplayed());
			test.log(Status.FAIL, "Error message is displayed");
			try {
				// Asserting the text in password Error Message
				Assert.assertTrue(errorMessageText.equals(OR.getProperty("PasswordErrorMessageText")));
				test.log(Status.FAIL, "Error message has text : " + errorMessageText);
			} catch (Throwable t) {
				test.log(Status.FAIL, "Error message is not as expected : " + "<br>" + "Error message has text : "
						+ errorMessageText);
			}
		} catch (Throwable t) {
			test.log(Status.INFO, "Error message not displayed");
		}
	}

	// Method for validating confirmPassword text box
	public void confirmPassword(String confirmPassword) {
		WebElement elementConfirmPassword = driver.findElement(by(OR.getProperty("ConfirmPassword")));
		elementConfirmPassword.sendKeys(confirmPassword);
		test.log(Status.INFO, "Typing in the field : ConfirmPassword" + "<br>" + "Entered value : " + confirmPassword);
		WebElement confirmPasswordErrorMessage = driver.findElement(by(OR.getProperty("ConfirmPasswordErrorMessage")));
		// Getting the text in error message
		String errorMessageText = confirmPasswordErrorMessage.getAttribute("innerHTML");
		try {
			// Asserting the confirmPassword Error Message whether it is displayed or not
			Assert.assertTrue(confirmPasswordErrorMessage.isDisplayed());
			test.log(Status.FAIL, "Error message is displayed");
			try {
				// Asserting the text in confirmPassword Error Message
				Assert.assertTrue(errorMessageText.equals(OR.getProperty("ConfirmPasswordErrorMessageText")));
				test.log(Status.FAIL, "Error message has text : " + errorMessageText);
			} catch (Throwable t) {
				test.log(Status.FAIL, "Error message is not as expected : " + "<br>" + "Error message has text : "
						+ errorMessageText);
			}
		} catch (Throwable t) {
			test.log(Status.INFO, "Error message not displayed");
		}
	}

	// Method for validating comments text box
	public void comments(String comments) {
		WebElement elementComments = driver.findElement(by(OR.getProperty("Comments")));
		elementComments.sendKeys(comments);
		test.log(Status.INFO, "Typing in the field : Comments" + "<br>" + "Entered value : " + comments);
	}

	// Method for validating previous button
	public void previous() {
		WebElement elementPrevious = driver.findElement(by(OR.getProperty("QuotePrevious")));
		elementPrevious.click();
		test.log(Status.INFO, "Clicking on : Previous");
	}

	// Method for validating send button
	public void send() {
		WebElement element = driver.findElement(by(OR.getProperty("SendQuoteCounter")));
		// Getting the no.of fields left empty in SendQuote tab
		System.out.println("SendQuote---->" + element.getText());
		WebElement elementNext = driver.findElement(By.xpath(OR.getProperty("QuoteNext")));
		elementNext.click();
		test.log(Status.INFO, "Clicking on : Send");
	}

}
