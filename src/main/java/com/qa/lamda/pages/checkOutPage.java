package com.qa.lamda.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.lamda.utils.ElementUtil;


public class checkOutPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productDetailsList = By.xpath("//table[@id='checkout-total']//tr//td");
	private By telephone = By.xpath("//input[@id='input-telephone']");
	private By firstname = By.cssSelector("#input-payment-firstname");
	private By lastname = By.cssSelector("input#input-payment-lastname");
	private By company = By.cssSelector("input#input-payment-company");
	private By address1 = By.cssSelector("input#input-payment-address-1");
	private By city = By.cssSelector("input#input-payment-city");
	private By postcode = By.cssSelector("input#input-payment-postcode");
	private By country = By.cssSelector("select#input-payment-country");
	private By region = By.xpath("//select[@id='input-payment-zone']");
	private By agreeCheckBox = By.cssSelector("label[for='input-agree']");
	private By Continue = By.cssSelector("button#button-save");



	public checkOutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getcheckOutTitle() {
		String title = driver.getTitle();
		System.out.println("Current Page Title is : " + title);
		return title;
	}

	public List<WebElement> getProductDetails() {

		List<WebElement> productMetaDataList  = elementUtil.getElements(productDetailsList);

		for(WebElement e : productMetaDataList) {
			String meta = e.getText();
			System.out.println(meta);

		}
		return productMetaDataList;

	}

	public int getRandomNumber() {
		return 1000;
	}

	public boolean userCheckOutDetails(String telephone,String firstname , String lastname, String company, 
			String address1, String city , String postcode, String country, String region)  {

		//String email ="automation" +getRandomNumber()+ "@gmail.com";

		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.company, company);
		elementUtil.doSendKeys(this.address1, address1);
		elementUtil.doSendKeys(this.city, city);
		elementUtil.doSendKeys(this.postcode, postcode);
		elementUtil.doDropDownSelectByVisibleText(this.country, country);
		elementUtil.selectDropDownWait(this.region, region);
		//elementUtil.doDropDownSelectByVisibleText(this.region, region);
		elementUtil.doClick(agreeCheckBox);
		elementUtil.doClick(Continue);

		return true;


	}

}


