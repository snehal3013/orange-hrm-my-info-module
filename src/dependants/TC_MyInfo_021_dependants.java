package dependants;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_021_dependants {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Dependants.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_021");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();

			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 21).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 22).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			// dependants
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);

			// add
			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).click();
			Thread.sleep(2000);
			// name
			driver.findElement(By.xpath(s.getCell(1, 9).getContents())).sendKeys(s.getCell(1, 23).getContents());
			Thread.sleep(3000);
			// relation
			driver.findElement(By.xpath(s.getCell(1, 10).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> relation = driver.findElements(By.xpath(s.getCell(1, 11).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= relation.size() - 1; i++) {

				if (relation.get(i).getText().contains(s.getCell(1, 24).getContents())) {

					relation.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// date
			WebElement date = driver.findElement(By.xpath(s.getCell(1, 12).getContents()));
			date.click();
			Thread.sleep(2000);
			date.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			date.sendKeys(s.getCell(1, 25).getContents());
			Thread.sleep(2000);
			// save
			driver.findElement(By.xpath(s.getCell(1, 13).getContents())).click();
			Thread.sleep(2000);

			Thread.sleep(5000);
			// add
			driver.findElement(By.xpath(s.getCell(1, 14).getContents())).click();
			Thread.sleep(2000);
			// name
			driver.findElement(By.xpath(s.getCell(1, 15).getContents())).sendKeys(s.getCell(1, 26).getContents());
			Thread.sleep(3000);
			// relation
			driver.findElement(By.xpath(s.getCell(1, 16).getContents())).click();
			Thread.sleep(2000);
			List<WebElement> relation1 = driver.findElements(By.xpath(s.getCell(1, 17).getContents()));
			Thread.sleep(2000);
			for (int i = 0; i <= relation1.size() - 1; i++) {

				if (relation1.get(i).getText().contains(s.getCell(1, 27).getContents())) {

					relation1.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
			// date
			WebElement date1 = driver.findElement(By.xpath(s.getCell(1, 18).getContents()));
			date1.click();
			Thread.sleep(2000);
			date1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(2000);
			date1.sendKeys(s.getCell(1, 28).getContents());
			Thread.sleep(2000);
			// save
			driver.findElement(By.xpath(s.getCell(1, 19).getContents())).click();
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
