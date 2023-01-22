package com.qa.lamda.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.lamda.base.BasePage;
import com.qa.lamda.utils.Constants;
import com.qa.lamda.utils.ExcelUtil;

public class RegisterPageTest extends BasePage {


	@BeforeClass
	public void registerationPageSetUp() {
		registerPage = loginpage.navigateToRegisterPage();

	}

	@DataProvider
	public Object[][] getRegisterData() {
		Object data [][] = ExcelUtil.getRegisterExcelData(Constants.REGISTER_SHEET_NAME);
		return data;
	}		



	@Test(dataProvider="getRegisterData")
	public void userRegisterationTest(String firstName, String lastName, 
			String emailID, String telePhone, String password, String subscribe) {

		Assert.assertTrue(registerPage.userRegisteration(firstName, lastName, emailID, telePhone, password, subscribe));


	}

}
