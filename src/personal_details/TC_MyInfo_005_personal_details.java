package personal_details;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_005_personal_details {

	public static void main(String[] args) {

		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Personal_Details.xls");
			
			Workbook wb =  Workbook.getWorkbook(f);
			
			Sheet s = wb.getSheet("TC_MyInfo_005");
			
			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(3000);
			driver.manage().window().maximize();
			//login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 8).getContents());
			Thread.sleep(2000);
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 9).getContents());
			Thread.sleep(2000);
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			//my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(5000);
		} 
		catch (Exception e) {
			System.out.println("Try with other locator");
		}
		
		finally {
		driver.close();
		}
	}

}
