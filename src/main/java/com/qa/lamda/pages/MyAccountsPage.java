package com.qa.lamda.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.lamda.utils.ElementUtil;

public class MyAccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By ShopCategory = By.xpath("//div[@id='entry_217832']");
	private By Software  = By.xpath("//span[normalize-space()='Software']");
	private By PalmCamera = By.xpath("//div[@id='entry_212408']//a[text()='Palm Treo Pro']");
	private By MyAccountsList = By.xpath("//div[@id='content']/div");
	private By HeaderValue = By.xpath("//img[@alt='Poco Electro']");
	private By search =By.xpath("//div[@id='entry_217822']//input[@aria-label='Search For Products']");
	private By searchButton = By.xpath("//button[@type='submit' and text()='Search']");
	private	By searchProductsresult = By.cssSelector("div.product-thumb h4 a");



	public MyAccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String MyAccountsPageTitle() {
		String Title = driver.getTitle();
		System.out.println("My Account Title is :"+ "" + Title);
		return Title;

	}

	public String getHeaderDisplay() {
		String Header = elementUtil.doGetText(HeaderValue);
		System.out.println(Header);
		return Header;

	}

	public int getAccountsListCount() {
		int count= elementUtil.getElements(MyAccountsList).size();
		System.out.println(count);
		return count;
	}

	public List<String> getAccountsListText() {

		List<String> accountsList = new ArrayList<>();
		List<WebElement> AllaccountsList =elementUtil.getElements(MyAccountsList);

		for (WebElement e : AllaccountsList) {
			String SectionList = e.getText();
			System.out.println(SectionList);
			accountsList.add(SectionList);

		}

		return accountsList;


	}

	public boolean clickOnCategory() {
		elementUtil.doClick(ShopCategory);
		return true;

	}

	public void clickOnSoftware() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Software));
		elementUtil.doClick(Software);

	}

	public void clickOnPalmCamera() {
		elementUtil.doClick(PalmCamera);

	}

	public boolean searchProduct(String ProductName) {
		elementUtil.doSendKeys(search, ProductName);
		elementUtil.doClick(searchButton);
		if(elementUtil.getElements(searchProductsresult).size()>0) {
			return true;
		}
		return false;

	}

	public ProductInfoPage selectProductsFromList(String ProductName) {
		List<WebElement> SearchResultsList =elementUtil.getElements(searchProductsresult);
		System.out.println("Total Number of Products Displayed : " + SearchResultsList.size());

		for (WebElement e : SearchResultsList) {
			if(e.getText().equals(ProductName)) {
				e.click();
				break;

			}
		}

		return new ProductInfoPage(driver);
	}



}	
