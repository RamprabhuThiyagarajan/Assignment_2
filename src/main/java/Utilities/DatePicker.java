package Utilities;

import java.util.Calendar;

import org.openqa.selenium.By;

import TestPages.EnterVehicleData;

public class DatePicker extends EnterVehicleData {
	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	static int currentDay = 0, currentMonth = 0, currentYear = 0;
	static int jumpMonthBy = 0;
	static int year, month, total;
	static boolean increment = true;

	// Method for picking the date
	public static void pickDate(String DateToSet) {
		getCurrentDate();
		getTargetDate(DateToSet);
		MonthsToJump();
		for (int i = 1; i <= jumpMonthBy; i++) {
			if (targetYear > currentYear) {
				driver.findElement(by(OR.getProperty("IncrementButton"))).click();
			} else if (targetYear < currentYear) {
				driver.findElement(by(OR.getProperty("DecrementButton"))).click();
			} else {
				if (increment) {
					driver.findElement(by(OR.getProperty("IncrementButton"))).click();
				} else {
					driver.findElement(by(OR.getProperty("DecrementButton"))).click();
				}
			}
		}
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();
		increment = true;
	}

	// Method for getting currentDay, currentMonth, currentYear
	public static void getCurrentDate() {
		Calendar calender = Calendar.getInstance();
		currentDay = calender.get(Calendar.DAY_OF_MONTH);
		currentMonth = calender.get(Calendar.MONTH) + 1;
		currentYear = calender.get(Calendar.YEAR);
	}

	// Method for getting targetDay, targetMonth, targetYear
	public static void getTargetDate(String dateString) {

		int First_index = dateString.indexOf("/");
		int Last_index = dateString.lastIndexOf("/");

		String day = dateString.substring(0, First_index);
		targetDay = Integer.parseInt(day);

		String month = dateString.substring(First_index + 1, Last_index);
		targetMonth = Integer.parseInt(month);

		String year = dateString.substring(Last_index + 1, dateString.length());
		targetYear = Integer.parseInt(year) + 2000;
	}

	// Method for calculating the count of months to jump
	public static void MonthsToJump() {
		if (targetYear > currentYear) {
			year = targetYear - currentYear;
			total = 12 - currentMonth;
			jumpMonthBy = (total + (12 * (year - 1)) + targetMonth);
		} else if (targetYear < currentYear) {
			year = currentYear - targetYear;
			total = 12 - targetMonth;
			jumpMonthBy = (total + (12 * (year - 1)) + currentMonth);
		} else {
			if ((targetMonth - currentMonth) > 0) {
				jumpMonthBy = targetMonth - currentMonth;
			} else {
				jumpMonthBy = currentMonth - targetMonth;
				increment = false;
			}
		}
	}
}
