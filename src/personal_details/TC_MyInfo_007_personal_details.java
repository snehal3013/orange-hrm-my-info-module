package personal_details;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_007_personal_details {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Personal_Details.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_007");
			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 13).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 14).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(3000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(3000);
			// Employee Id
			boolean empid = driver.findElement(By.xpath(s.getCell(1, 7).getContents())).isEnabled();
			if (empid == false) {
				System.out.println("Employee Id field is disabled");
			} else {
				System.out.println("Employee Id field is enabled");
			}
			// Driving License Number
			boolean dlnumber = driver.findElement(By.xpath(s.getCell(1, 8).getContents())).isEnabled();
			if (dlnumber == false) {
				System.out.println("Driving License Number field is disabled");
			} else {
				System.out.println("Driving License Number  field is enabled");
			}
			// SSN Number
			boolean ssnnumber = driver.findElement(By.xpath(s.getCell(1, 9).getContents())).isEnabled();
			if (ssnnumber == false) {
				System.out.println("SSN Number field is disabled");
			} else {
				System.out.println("SSN Number  field is enabled");
			}
			// SIN Number
			boolean sinnumber = driver.findElement(By.xpath(s.getCell(1, 10).getContents())).isEnabled();
			if (sinnumber == false) {
				System.out.println("SIN Number field is disabled");
			} else {
				System.out.println("SIN Number  field is enabled");
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			// DOB
			boolean dob = driver.findElement(By.xpath(s.getCell(1, 11).getContents())).isEnabled();
			if (dob == false) {
				System.out.println("DOB field is disabled");
			} else {
				System.out.println("DOB field is enabled");
			}
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			driver.close();
		}
	}

}
