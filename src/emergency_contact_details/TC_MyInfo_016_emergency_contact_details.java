package emergency_contact_details;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_016_emergency_contact_details {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Emergency_Contacts.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_016");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 19).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 20).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			// emergency contacts
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// name
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).sendKeys(s.getCell(1, 21).getContents());
			Thread.sleep(2000);
			// relation
			driver.findElement(By.xpath(s.getCell(1, 10).getContents())).sendKeys(s.getCell(1, 22).getContents());
			Thread.sleep(2000);
			// mobile
			driver.findElement(By.xpath(s.getCell(1, 11).getContents())).sendKeys(s.getCell(1, 23).getContents());
			Thread.sleep(2000);
			// save
			driver.findElement(By.xpath(s.getCell(1, 12).getContents())).click();
			Thread.sleep(2000);

			Thread.sleep(2000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).click();
			Thread.sleep(2000);
			// name
			driver.findElement(By.xpath(s.getCell(1, 14).getContents())).sendKeys(s.getCell(1, 24).getContents());
			Thread.sleep(2000);
			// relation
			driver.findElement(By.xpath(s.getCell(1, 15).getContents())).sendKeys(s.getCell(1, 25).getContents());
			Thread.sleep(2000);
			// mobile
			driver.findElement(By.xpath(s.getCell(1, 16).getContents())).sendKeys(s.getCell(1, 26).getContents());
			Thread.sleep(2000);
			// save
			driver.findElement(By.xpath(s.getCell(1, 17).getContents())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			if (driver.getPageSource().contains("Successfully Saved")) {
				System.out.println("Details are saved");
			} else {
				System.out.println("Details are not saved");
			}
			driver.close();
		}
	}

}
