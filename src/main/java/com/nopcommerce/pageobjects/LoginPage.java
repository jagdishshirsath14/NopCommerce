package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.utilities.Excel;

public class LoginPage extends BaseClass {
	
	public static Excel xl;
	Logger log = (Logger) LogManager.getLogger("LoginPage.class");
	
//	Page Factory

	@FindBy(id = "Email")
	WebElement emailField;

	@FindBy(id = "Password")
	WebElement passwordField;

	@FindBy(xpath = "//div[@class='buttons']//button[@type='submit']")
	WebElement logInBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginApplication() {
		xl = new Excel("D:\\MyTestData\\NopCommerceTestData.xlsx");
		xl.setSheet("RegisterData");
		emailField.sendKeys(xl.getCellData(1, "Email"));
		log.info("Emai ID is entered");
		passwordField.sendKeys(xl.getCellData(1, "Password"));
		log.info("Password is entered");
		logInBtn.click();
		log.info("Click on login");
		return new HomePage();
		}
	
}
