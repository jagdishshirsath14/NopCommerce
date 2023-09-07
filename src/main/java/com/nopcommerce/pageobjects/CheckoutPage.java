package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.actiondriver.Action;
import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.utilities.Excel;

public class CheckoutPage extends BaseClass{
	
	public static Excel xl;
	Logger log = (Logger) LogManager.getLogger("CheckoutPage.class");
	
//	Page Factory
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryDropdown;
	
	@FindBy(xpath = "//input[contains(@name,'City')]")
	WebElement cityField;
	
	@FindBy(xpath = "//input[contains(@name,'Address1')]")
	WebElement address1Field;
	
	@FindBy(xpath = "//input[contains(@name,'PostalCode')]")
	WebElement postalCodeField;
	
	@FindBy(xpath = "//input[contains(@name,'PhoneNumber')]")
	WebElement phoneNumberField;
	
	@FindBy(xpath = "//button[@onclick='Billing.save()']")
	WebElement continueBtn;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void fillCheckoutDetails() {
		xl = new Excel("D:\\MyTestData\\NopCommerceTestData.xlsx");
		xl.setSheet("CheckoutData");
		Action.selectByValue(driver, countryDropdown, "163");
		log.info("Country selected");
		cityField.sendKeys(xl.getCellData(1, "City"));
		log.info("Entered city");
		address1Field.sendKeys(xl.getCellData(1, "Address"));
		log.info("Entered address");
		postalCodeField.sendKeys("123456");
		log.info("Entered zip code");
		phoneNumberField.sendKeys("0123456789");
		log.info("Entered phone number");
	}
	
	public ShippingPage clickOnContinue() {
		continueBtn.click();
		log.info("Click on Continue");
		return new ShippingPage();
	}

}
