package com.qa.lamda.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.lamda.base.BasePage;
import com.qa.lamda.utils.Constants;
import com.qa.lamda.utils.ExcelUtil;

public class CheckOutPageTest extends BasePage {

	@BeforeClass
	public void checkoutPageSetup() {
		myAccountsPage = loginpage.Login(prop.getProperty("userName"), prop.getProperty("password"));
		myAccountsPage.searchProduct("iMac");
		productInfoPage = myAccountsPage.selectProductsFromList("iMac");
		productInfoPage.selectQuantity("2");
		productInfoPage.addToCart();
		CheckOutPage = productInfoPage.clickCheckout();
	}	

	@Test(priority = 1)
	public void getcheckOutPageTitleTest() {
		String Title = CheckOutPage.getcheckOutTitle(); 
		System.out.println(Title);
		Assert.assertEquals(Title, Constants.CHECKOUT_PAGE_TITLE);


	}

	@Test(priority = 2)
	public void getProductDetailsTest() {
		List<WebElement> Map = CheckOutPage.getProductDetails();
		System.out.println(Map);
		Assert.assertEquals("Sub-Total:", "Sub-Total:");
		Assert.assertEquals("$280.00", "$280.00");
		Assert.assertEquals("Flat Shipping Rate:", "Flat Shipping Rate:");
		Assert.assertEquals("$5.00", "$5.00");
		Assert.assertEquals("Total:", "Total:");
		Assert.assertEquals("$285.00", "$285.00");
		SoftAssert asst = new SoftAssert();
		asst.assertAll();

	}

	@DataProvider
	public Object[][] userCheckOutData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CHECKOUT_SHEET_NAME);
		return data;

	}

	@Test(dataProvider ="userCheckOutData")
	public void userCheckOutDetailsTest(String telePhone, String firstName,String lastName, String Company,
			String address1,String City, String postCode,String Country,String Region)  {

		Assert.assertTrue(CheckOutPage.userCheckOutDetails(telePhone, firstName, lastName, Company, address1, City, postCode, Country, Region));

	} 


}
