package com.qa.lamda.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.lamda.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;


	private By itemsImageDisplayed = By.cssSelector("div#image-gallery-216811 img");
	private By itemNameHeader = By.cssSelector("div#entry_216815 h1");
	private By metaData = By.cssSelector("div#entry_216815 .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("div#entry_216815 h3");
	private By quantity = By.cssSelector("div#entry_216834 input");
	private By AddToCartButton = By.xpath("//div[@id='entry_216842']//button[text()='Add to Cart']");
	private By checkout = By.xpath("//div[@id='notification-box-top'] //a[text()='Checkout ']");	


	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public int getProductImage() {
		int imagecount = elementUtil.getElements(itemsImageDisplayed).size();
		System.out.println("Total Product Images is : " +imagecount);
		return imagecount;
	}

	public String getProductInfoPageTitle(String productName) {
		String title =elementUtil.waitForPageTitlePresent(productName, 5);
		System.out.println("Product page Title is :" + title);
		return title;
	}

	public HashMap<String, String> getProductInformation() {
		HashMap<String,String> productinfo = new HashMap<String,String>();
		productinfo.put("name", elementUtil.doGetText(itemNameHeader).trim());

		List<WebElement> productMetaDataList  = elementUtil.getElements(metaData);

		for(WebElement e : productMetaDataList) {

			String meta[] = e.getText().split(":");
			String metaName  = meta[0].trim();
			String metaValue   = meta[1].trim();

			productinfo.put(metaName, metaValue);

		}	

		List<WebElement> productPricelist = elementUtil.getElements(productPrice);

		productinfo.put("price", productPricelist.get(0).getText().trim());

		return productinfo;
	}

	public String selectQuantity(String qty) {
		elementUtil.doSendKeys(quantity, qty);
		System.out.println("Total Quantity is :" + qty);
		return qty;

	}

	public void addToCart() {
		System.out.println("Items Adding to Cart");
		elementUtil.doClick(AddToCartButton);
	}

	public checkOutPage clickCheckout() {
		elementUtil.clickWhenReady(checkout, 10);
		return new checkOutPage(driver);
	}


}
