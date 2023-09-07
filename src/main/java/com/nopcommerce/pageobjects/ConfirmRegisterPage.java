package com.nopcommerce.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.baseclass.BaseClass;

public class ConfirmRegisterPage extends BaseClass{

	Logger log = (Logger) LogManager.getLogger("ConfirmRegisterPage.class");
	
//	Page factory
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement RegistrationSucsMsg;
	
	@FindBy(xpath = "//a[.='Continue']")
	WebElement continueBtn;
	
	public ConfirmRegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getRegistrationSuccessMessage() {
		String successMsg = RegistrationSucsMsg.getText();
		return successMsg;
	}
	
	public HomePage clickOnContinue() {
		continueBtn.click();
		log.info("Click on Continue");
		return new HomePage();
	}
}
