package genricUtilities;

import java.io.FileInputStream;
import java.sql.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_lOAD_TIME=5;
	public static String generateEmailWithTimeStamp() {
        Date date = new Date(0);
        String timestamp = date.toString().replace(" ","_").replace(":","_");
        return "sunitamath.math" + timestamp + "@gmail.com";
    }
	
	
	
}