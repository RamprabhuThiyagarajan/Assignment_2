package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	// Method for reading data in Excel
	public Object[][] readData(String excelSheetName) throws EncryptedDocumentException, IOException {
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		// System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		// System.out.println(totalCols);

		DataFormatter format = new DataFormatter();

		Object testData[][] = new Object[totalRows][1];
		Hashtable<String, String> table = null;
		for (int i = 0; i < totalRows; i++) {
			table = new Hashtable<String, String>();
			for (int j = 0; j < totalCols; j++) {
				// System.out.println(sheetName.getRow(0).getCell(j)+"------"+sheetName.getRow(i).getCell(j));
				table.put(format.formatCellValue(sheetName.getRow(0).getCell(j)),
						format.formatCellValue(sheetName.getRow(i + 1).getCell(j)));
			}
			testData[i][0] = table;
		}
		return testData;
	}

	// Data provider method
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		ExcelReader r = new ExcelReader();
		Object[][] data = null;
		try {
			data = r.readData(m.getName());
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	// Method for reading the test suite runMode data in Excel
	public static boolean isTestRunnable(String testName) throws EncryptedDocumentException, IOException {
		String sheetName = "Test_suite";
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet SheetName = wb.getSheet(sheetName);

		int totalRows = SheetName.getLastRowNum();
		// Row rowCells = SheetName.getRow(0);
		// int totalCols = rowCells.getLastCellNum();
		DataFormatter format = new DataFormatter();
		for (int r = 1; r <= totalRows; r++) {
			String testcase = format.formatCellValue(SheetName.getRow(r).getCell(0));
			if (testcase.equalsIgnoreCase(testName)) {
				String runMode = format.formatCellValue(SheetName.getRow(r).getCell(1));
				if (runMode.equalsIgnoreCase("YES")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
