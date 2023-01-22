 package com.qa.lamda.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.lamda.base.BasePage;
import com.qa.lamda.utils.Constants;

public class LoginPageTest extends BasePage {

	//	@Test
	//	public void clickmyaccountLinkTest() {
	//		loginpage.clickMyAccountLink();
	//	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Login Page Title is :" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginpage.isForgotLinkExist());
	}
	
	public String getRandomNumber() {
		System.out.println(RandomStringUtils.random(
				5, true, true)+ "@gmail.com");
		return RandomStringUtils.random(
				5, true, true)+ "@gmail.com";

	}

	@Test(priority = 3)
	public void LoginTest() {
		myAccountsPage = loginpage.Login(prop.getProperty("userName"), prop.getProperty("password"));
		Assert.assertEquals(myAccountsPage.MyAccountsPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);


	}



}
