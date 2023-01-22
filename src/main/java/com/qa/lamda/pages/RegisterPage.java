package com.qa.lamda.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.lamda.utils.Constants;
import com.qa.lamda.utils.ElementUtil;

public class RegisterPage {


	private WebDriver driver;
	private ElementUtil elementUtil;

	private By firstname = By.cssSelector("#input-firstname");
	private By lastname = By.cssSelector("#input-lastname");
	private By email = By.cssSelector("#input-email");
	private By telephone = By.cssSelector("#input-telephone");
	private By password = By.cssSelector("#input-password");
	private By confirmpassword = By.cssSelector("#input-confirm");
	private By subscribeYes = By.xpath("//label[@for='input-newsletter-yes']");
	private By subscribeNo = By.xpath("//label[@for='input-newsletter-no']");
	private By agree = By.xpath("//label[@for='input-agree']");
	private By ContinueButton = By.xpath("//input[@value='Continue']");
	private By AccountSuccessMessage = By.cssSelector("div#content h1");
	private By LogoutLink = By.cssSelector("a:nth-child(14)");
	private By RegisterLink = By.xpath("//div[@class='list-group mb-3']//a[text()=' Register'] ");





	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getRandomNumber() {
		System.out.println(RandomStringUtils.random(
				5, true, true)+ "@gmail.com");
		return RandomStringUtils.random(
				5, true, true)+ "@gmail.com";

	}

	public boolean userRegisteration(String firstname, String lastname, String email, 
			String telephone, String password, String subscribe) {
		//email = "automation" + getRandomNumber() + "@gmail.com";
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.email, getRandomNumber());
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmpassword, password);

		if(subscribe.equals(subscribe)) {
			elementUtil.doClick(subscribeYes);	
		}else {
			elementUtil.doClick(subscribeNo);	

		}

		elementUtil.doClick(agree);
		elementUtil.doClick(ContinueButton);

		String text = elementUtil.doGetText(AccountSuccessMessage);
		if(text.equals(Constants.ACCOUNT_SUCCESS_MESSAGE)) {
			elementUtil.doClick(LogoutLink);
			elementUtil.doClick(RegisterLink);
		}


		return true;

	}



}
