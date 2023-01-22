import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraphHandle {
 
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		String verticalXpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		String textTooltip = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";

		List<WebElement> barslist =driver.findElements(By.xpath(verticalXpath));
		System.out.println("Total Bars is: " + barslist.size());

		Actions act = new Actions(driver);		 
		for(WebElement e : barslist) {
			act.moveToElement(e).perform();
			String text = driver.findElement(By.xpath(textTooltip)).getText();
			Thread.sleep(500);
			System.out.println(text);
f
		}
	}
}