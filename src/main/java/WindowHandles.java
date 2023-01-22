import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		String ParentWindowID = driver.getWindowHandle();

		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[3]")).click();
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]")).click();

		Set<String> handles = 	driver.getWindowHandles();
		List<String> hList = new ArrayList<>(handles);
		
		if(switchToRightWindow("Twitter", hList)) {
			System.out.println(driver.getCurrentUrl() + ": " + driver.getTitle());
		}

		closeAllWindows(hList, ParentWindowID);
		switchToParentWindow(ParentWindowID);
		System.out.println(driver.getCurrentUrl() + ": " + driver.getTitle());
 
		


	}

	public static void closeAllWindows(List<String> hList, String parentWindow) {
		for(String e : hList) {
			if(!e.equals(parentWindow)) {
				driver.switchTo().window(e).close();
			}
		}

	}



	public static void switchToParentWindow(String ParentWindowID) {
		driver.switchTo().window(ParentWindowID);
	}


	public static boolean switchToRightWindow(String windowTitle,List<String> hList ) {
		for(String e : hList) {
			String Title = driver.switchTo().window(e).getTitle();
			if(Title.contains(windowTitle)) {
				System.out.println("Found the Right Window ....");
				return true;
			}
		}
		return false;

	}



}
