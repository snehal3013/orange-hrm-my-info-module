package immigration;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_029_immigration {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Immigration.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_029");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 12).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 13).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			// immigration
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,900)", "");
			Thread.sleep(2000);
			// select
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// trash button
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).click();
			Thread.sleep(2000);
			// confirm delete
			driver.findElement(By.xpath(s.getCell(1, 10).getContents())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {

			if (driver.getPageSource().contains("Successfully Deleted")) {
				System.out.println("File is deleted");
			} else {
				System.out.println("File is not deleted");
			}
			driver.close();
		}

	}

}
