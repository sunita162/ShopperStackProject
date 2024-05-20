package genricUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ReadTestData {
	// Constants for wait times
	public static final int WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	// Generates an email with a unique timestamp
	public static final String PasswordGenerator = null;
	public static String generateEmailWithTimeStamp() {
        Date date = new Date(0);
        String timestamp = date.toString().replace(" ","_").replace(":","_");
        return "sunitamath.math" + timestamp + "@gmail.com";
    }
	
	// Generates a random phone number
    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();

        // Ensure the first digit is not 0
        phoneNumber.append(random.nextInt(9) + 1);

        // Generate the remaining 9 digits
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }

 // Inner class for generating passwords
	 public class PasswordGenerator {
        private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        private static final String DIGITS = "0123456789";
        private static final String SPECIAL = "!@#$%^&*()-_=+";

        private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;

        public void main(String[] args) {
            String password = generatePassword(12); // Change the length as needed
            System.out.println("Random password: " + password);
        }

     // Generates a password of specified length
        public String generatePassword(int length) {
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();

            // Ensure at least one character from each category
            password.append(UPPER.charAt(random.nextInt(UPPER.length())));
            password.append(LOWER.charAt(random.nextInt(LOWER.length())));
            password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
            password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

            // Fill the rest of the password with random characters
            for (int i = 4; i < length; i++) {
                password.append(ALL.charAt(random.nextInt(ALL.length())));
            }

            // Shuffle the characters in the password to make it more random
            return shuffleString(password.toString());
        }

        // Shuffle the characters in a string
        private String shuffleString(String string) {
            char[] characters = string.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                int randomIndex = (int) (Math.random() * characters.length);
                char temp = characters[i];
                characters[i] = characters[randomIndex];
                characters[randomIndex] = temp;
            }
            return new String(characters);
        }
    }
	// Reads test data from an Excel file
	public static Object[][] getTestDataFromExcel(String SheetName) {
	    File excelFile = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/ShoppersStackTestData1.xlsx");
	    XSSFWorkbook workbook = null;
	    try {
	        FileInputStream fisExcel = new FileInputStream(excelFile);
	        workbook = new XSSFWorkbook(fisExcel); // Correctly load the workbook from FileInputStream
	    } catch (Throwable e) {
	        e.printStackTrace();
	    }

	    XSSFSheet sheet = workbook.getSheet(SheetName);

	    int rows = sheet.getLastRowNum();
	    int cols = sheet.getRow(0).getLastCellNum();	

	    Object[][] data = new Object[rows][cols];
	    for (int i = 0; i < rows; i++) {
	        XSSFRow row = sheet.getRow(i + 1);

	        for (int j = 0; j < cols; j++) {
	            XSSFCell cell = row.getCell(j);
	            CellType cellType = cell.getCellType();
	            // Determine cell type and extract data accordingly
	            switch (cellType) {
	                case STRING:
	                    data[i][j] = cell.getStringCellValue();
	                    break;
	                case NUMERIC:
	                    data[i][j] = Integer.toString((int) cell.getNumericCellValue());
	                    break;
	                case BOOLEAN:
	                    data[i][j] = cell.getBooleanCellValue();
	                    break;
	            }
	        }
	    }
	    return data;
	}
	 // Method to capture a screenshot
	public static String captureScreenshot(WebDriver driver, String testName) {
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		
		try {
			FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}

	
}