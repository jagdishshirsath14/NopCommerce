package com.nopcommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.pageobjects.ConfirmRegisterPage;
import com.nopcommerce.pageobjects.HomePage;
import com.nopcommerce.pageobjects.RegisterPage;

public class RegisterPageTest extends BaseClass {

	public HomePage homePage;
	public RegisterPage registerPage;
	public ConfirmRegisterPage confirmRegisterPage;

	@Test
	public void verifyRegisterFunctionality() {
		homePage = new HomePage();
		homePage.clickOnRegister();
		registerPage = new RegisterPage();
		registerPage.fillPersonalDetails2();
		registerPage.enteredPassword();
		registerPage.clickOnRegister();
		confirmRegisterPage = new ConfirmRegisterPage();
		Assert.assertEquals(confirmRegisterPage.getRegistrationSuccessMessage(), "Your registration completed");
	}

}
