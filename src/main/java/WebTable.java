import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/checkout");

				List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\\\"checkout-total\\\"]/tbody/tr"));
				int rowCount = rows.size();
				System.out.println("Total Rows in Web Table is :" + rowCount);
		
				String beforeXpath = "//*[@id=\"checkout-total\"]/tbody/tr[";
				String afterXpath = "]/td[1]";
		
				for(int i=0; i<=rowCount; i++){
					String actualXpath = beforeXpath+i+afterXpath;
					WebElement element = driver.findElement(By.xpath(actualXpath));
					System.out.println(element.getText());
		
				}
		
				String afterXpath2 = "]/td[2]/strong";
		
				for(int i=0; i<=rowCount; i++){
					String actualXpath = beforeXpath+i+afterXpath2;
					WebElement element = driver.findElement(By.xpath(actualXpath));
					System.out.println(element.getText());
		
					

		


		}

	}






}
