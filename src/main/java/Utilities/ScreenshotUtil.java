package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.TestBase;

public class ScreenshotUtil extends TestBase {
	public static File ScreenShot;
	public static String Filename;

	// Method for capturing the screenshot
	public static void CaptureScreenShot(String name) {

		Date d = new Date();
		Filename = name + "_" + d.toString().replace(":", " ").replace(" ", "_") + ".jpg";
		ScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenShot, new File(".//reports//screenshots//" + Filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
