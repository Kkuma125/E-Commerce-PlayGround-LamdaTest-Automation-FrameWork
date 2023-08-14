package com.qa.lamda.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.lamda.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By myAccountmenuLink = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(),' My account')]");
	private By LoginLink = By.xpath("//span[normalize-space()='Login']");
	private By emailid = By.xpath("//input[@id='input-email']");
	private By password = By.xpath("//input[@id='input-password']");
	private By LoginButton = By.xpath("//input[@type='submit' and @value='Login']");
	private By ForgotPwdLink = By.xpath("//a[text()='Forgotten Password']");
	private By RegisterLink = By.xpath("//div[@class='list-group mb-3']//a[text()=' Register'] ");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public void clickMyAccountLink() {
		Actions act = new Actions(driver);
		act.moveToElement(elementUtil.getElement(myAccountmenuLink)).perform();
		elementUtil.doClick(LoginLink);

	}

	public String getLoginPageTitle() {
		String Title = driver.getTitle();
		System.out.println("Title is :" + Title);
		return Title;

	}

	public boolean isForgotLinkExist() {
		return elementUtil.doIsDisplayed(ForgotPwdLink);
	}

	public MyAccountsPage Login(String username, String pwd) {
		System.out.println("Login with : " + username + " " + pwd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(emailid));
		elementUtil.doSendKeys(emailid, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(LoginButton);
		return new MyAccountsPage(driver);

	}

	public RegisterPage navigateToRegisterPage() {
		System.out.println("Navigating to RegisterPage....");
		elementUtil.doClick(RegisterLink);
		return new RegisterPage(driver);
	}

}
