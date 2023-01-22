package com.qa.lamda.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.lamda.driverfactory.DriverFactory;
import com.qa.lamda.pages.LoginPage;
import com.qa.lamda.pages.MyAccountsPage;
import com.qa.lamda.pages.ProductInfoPage;
import com.qa.lamda.pages.RegisterPage;
import com.qa.lamda.pages.checkOutPage;

public class BasePage {

	DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginpage;
	public MyAccountsPage myAccountsPage;
	public ProductInfoPage productInfoPage;
	public checkOutPage CheckOutPage;
	public RegisterPage registerPage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop =df.init_prop();
		String browserName = prop.getProperty("browser");
		driver = df.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		productInfoPage = new ProductInfoPage(driver);

	}	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}



}
