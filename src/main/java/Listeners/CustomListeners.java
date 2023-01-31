package Listeners;



import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base.TestBase;
import Utilities.ScreenshotUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getName();
		String Text = "<b>" + "TESTCASE : " + methodName + "</b>" + "<b>" + " Passed" + "</b>";

		Markup m = MarkupHelper.createLabel(Text, ExtentColor.GREEN);
		test.pass(m);

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String name = result.getName().toString().trim();
		ScreenshotUtil.CaptureScreenShot(name);
		String file = System.getProperty("user.dir") + "\\reports\\screenshots\\" + ScreenshotUtil.Filename;

		//String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		//excepionMessage.replaceAll(", ", "<br>")
		test.fail("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception Occured: Click to see"
				+ "</font>" + "</b>" + "</summary>" +result.getThrowable().getMessage() + "</details>" + "\n");
		String failureLogg = "<b>" + "TESTCASE : " + result.getName() + "</b>" + " Failed" + "</b>";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		test.log(Status.FAIL, m);
		test.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(file).build());

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();
		String message = result.getThrowable().toString();
		String Text = "<b>" + "TESTCASE : " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(Text, ExtentColor.BLUE);
		test.skip(m);
		test.skip(message);
	}

}
