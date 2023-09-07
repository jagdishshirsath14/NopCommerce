package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.actiondriver.Action;
import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.utilities.Excel;

public class RegisterPage extends BaseClass {

	public static Excel xl;
	Logger log = (Logger) LogManager.getLogger("RegisterPage.class");
	
//	Page Factory

	@FindBy(id = "gender-male")
	WebElement maleCheckbox;

	@FindBy(id = "FirstName")
	WebElement fNameField;

	@FindBy(id = "LastName")
	WebElement lNameField;

	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement dayDropdown;

	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement monthDropdown;

	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement yearDropdown;

	@FindBy(id = "Email")
	WebElement emailField;

	@FindBy(id = "Password")
	WebElement passwordField;

	@FindBy(id = "ConfirmPassword")
	WebElement cPasswordField;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillPersonalDetails() {
		xl = new Excel("D:\\MyTestData\\NopCommerceTestData.xlsx");
		xl.setSheet("RegisterData");
		maleCheckbox.click();
		log.info("Checked male checkbox");
		fNameField.sendKeys(xl.getCellData(1, "FirstName"));
		log.info("Entered first name");
		lNameField.sendKeys(xl.getCellData(1, "LastName"));
		log.info("Entered last name");
		Action.selectByValue(driver, dayDropdown, "21");
		log.info("Day selected");
		Action.selectByValue(driver, monthDropdown, "8");
		log.info("Month selected");
		Action.selectByValue(driver, yearDropdown, "1991");
		log.info("Year selected");
		emailField.sendKeys(xl.getCellData(1, "Email"));
		log.info("Entered email id");
	}
	
	public void fillPersonalDetails2() {
		xl = new Excel("D:\\MyTestData\\NopCommerceTestData.xlsx");
		xl.setSheet("RegisterData");
		maleCheckbox.click();
		log.info("Checked male checkbox");
		fNameField.sendKeys(xl.getCellData(1, "FirstName"));
		log.info("Entered first name");
		lNameField.sendKeys(xl.getCellData(1, "LastName"));
		log.info("Entered last name");
		Action.selectByValue(driver, dayDropdown, "21");
		log.info("Day selected");
		Action.selectByValue(driver, monthDropdown, "8");
		log.info("Month selected");
		Action.selectByValue(driver, yearDropdown, "1991");
		log.info("Year selected");
		emailField.sendKeys(xl.getCellData(4, "Email"));
		log.info("Entered email id");
	}
	
	public void enteredPassword() {
		xl = new Excel("D:\\MyTestData\\NopCommerceTestData.xlsx");
		xl.setSheet("RegisterData");
		passwordField.sendKeys(xl.getCellData(1, "Password"));
		log.info("Entered password");
		cPasswordField.sendKeys(xl.getCellData(1, "ConfirmPassword"));
		log.info("Entered confirm password");
	}
	
	public ConfirmRegisterPage clickOnRegister() {
		registerBtn.click();
		log.info("Click on Register");
		return new ConfirmRegisterPage();
	}

}
