package com.qa.lamda.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.lamda.base.BasePage;
import com.qa.lamda.utils.Constants;

import io.qameta.allure.Description;

public class MyAccountsPageTest extends BasePage {

	@BeforeClass
	public void accountsPageSetup() {
		myAccountsPage = loginpage.Login(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	@Description("Verify AccountsPage Title Test")
	public void MyAccountsPageTitleTest() {
		String ActualTitle =myAccountsPage.MyAccountsPageTitle();
		System.out.println("MyAccounts Page Title is : " + "" + ActualTitle);
		Assert.assertEquals(ActualTitle, Constants.ACCOUNTS_PAGE_TITLE);

	}
	@Test(priority =2)
	@Description("Verify Header Display Value")
	public void getHeaderDisplayTest() {
		String HeaderValue =myAccountsPage.getHeaderDisplay();
		System.out.println("AccountsPage Header Value is :" + HeaderValue);
		Assert.assertEquals(HeaderValue, Constants.ACCOUNTS_PAGE_HEADER);

	}

	@Test(priority = 3)
	@Description("Verify AccountsPage List Count Test")
	public void getAccountsListCountTest() {
		Assert.assertTrue(myAccountsPage.getAccountsListCount()== Constants.ACCOUNTS_PAGE_LIST_COUNT);

	}

	@Test(priority = 4)
	@Description("Verify AccountsList Text")
	public void getAccountsListTextTest() {
		List<String> ListView = myAccountsPage.getAccountsListText();
		System.out.println(ListView);

	}	

	@Test(priority = 5)
	@Description("Click On Category Link")
	public void clickOnCategoryTest()  {
		Assert.assertTrue(myAccountsPage.clickOnCategory());
	}

	@Test(priority = 6)
	@Description("Click On Software Link")
	public void clickOnSoftwareTest() {
		myAccountsPage.clickOnSoftware();
	}

	@Test(priority = 7)
	@Description("Click On Palm Camera Link")
	public void clickOnPalmCameraTest() {
		myAccountsPage.clickOnPalmCamera();
	}
	@DataProvider
	public Object[][] searchData() {
		return new Object[][] {{"iMac"},{"iPhone"},{"Samsung"}};
	}

	@Test(priority = 8,dataProvider = "searchData")
	@Description("Search Products Test")
	public void searchProductTest(String productName) {
		Assert.assertTrue(myAccountsPage.searchProduct(productName));
	}

	@Test(priority = 9)
	@Description("Select Products From List")
	public void selectProductsFromListTest() {
		myAccountsPage.searchProduct("iPhone");
		productInfoPage = myAccountsPage.selectProductsFromList("iPhone");
		Assert.assertEquals(myAccountsPage.MyAccountsPageTitle(), "iPhone");
	}
}	
