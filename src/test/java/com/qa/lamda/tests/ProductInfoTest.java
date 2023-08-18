package com.qa.lamda.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.lamda.base.BasePage;

public class ProductInfoTest extends BasePage {

	@BeforeClass
	public void productPageSetup() {
		myAccountsPage = loginpage.Login(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void getProductInfoPageTitleTest_iMac() {
		myAccountsPage.searchProduct("iMac");
		productInfoPage = myAccountsPage.selectProductsFromList("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");


	}

	public void goToProductpage(String productName) {
		myAccountsPage.searchProduct(productName);
		productInfoPage = myAccountsPage.selectProductsFromList(productName);

	}

	@Test(priority = 2)
	public void getProductInfoPageTitleTest_MacBookAir() {
		myAccountsPage.searchProduct("MacBook Air");
		productInfoPage = myAccountsPage.selectProductsFromList("MacBook Air");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("MacBook Air"), "MacBook Air");

	}

	@Test(priority = 3)
	public void verifygetProductImageTest() {
		Assert.assertTrue(productInfoPage.getProductImage()== 5);

	}

	@Test(priority = 4)
	public void getProductInformationTest() {
		String productName = "iMac";
		goToProductpage(productName);
		HashMap<String, String> productinformap = productInfoPage.getProductInformation();
		System.out.println(productinformap);
		productinformap.forEach((k,v)-> System.out.println(k+ " : "+v));

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(productinformap.get("name"), productName);
		softAssert.assertEquals(productinformap.get("Product Code"), "Product 14");
		softAssert.assertEquals(productinformap.get("Brand"), "Apple");
		softAssert.assertEquals(productinformap.get("Availability"), "In Stock");
		softAssert.assertEquals(productinformap.get("price"), "$140.00");
		softAssert.assertAll();

	}	

	@Test(priority = 5)
	public void selectQuantityTest() {
		getProductInfoPageTitleTest_MacBookAir();
		String qty = productInfoPage.selectQuantity("2");
		Assert.assertEquals(qty, "2");

	}

	@Test(priority = 6)
	public void addToCartTest() {
		productInfoPage.addToCart();
	}

	@Test(priority = 7)
	public void clickCheckoutTest() {
		productInfoPage.clickCheckout();

	}



}

