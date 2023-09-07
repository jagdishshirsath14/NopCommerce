package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.pageobjects.CartPage;
import com.nopcommerce.pageobjects.CheckoutPage;
import com.nopcommerce.pageobjects.ConfirmOrderPage;
import com.nopcommerce.pageobjects.ConfirmRegisterPage;
import com.nopcommerce.pageobjects.HomePage;
import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.pageobjects.OrderPlacePage;
import com.nopcommerce.pageobjects.PaymentInfoPage;
import com.nopcommerce.pageobjects.PaymentPage;
import com.nopcommerce.pageobjects.ProductDetailsPage;
import com.nopcommerce.pageobjects.RegisterPage;
import com.nopcommerce.pageobjects.SearchResultPage;
import com.nopcommerce.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	
	public HomePage homePage;
	public RegisterPage registerPage;
	public ConfirmRegisterPage confirmRegisterPage;
	public LoginPage loginPage;
	public CartPage cartPage;
	public SearchResultPage searchResultPage;
	public ProductDetailsPage productDetailsPage;
	public CheckoutPage checkoutPage;
	public ShippingPage shippingPage;
	public PaymentPage paymentPage;
	public PaymentInfoPage paymentInfoPage;
	public ConfirmOrderPage confirmOrderPage;
	public OrderPlacePage orderPlacePage;
	
	@Test
	public void verifyEndToEndApplicationFunctionality() throws IOException {
		homePage = new HomePage();
		homePage.clickOnRegister();
		registerPage = new RegisterPage();
		registerPage.fillPersonalDetails();
		registerPage.enteredPassword();
		registerPage.clickOnRegister();
		confirmRegisterPage = new ConfirmRegisterPage();
		confirmRegisterPage.clickOnContinue();
		homePage.clickOnLogin();
		loginPage = new LoginPage();
		loginPage.loginApplication();
		homePage.searchProduct("macbook");
		homePage.clickOnSearch();
		searchResultPage = new SearchResultPage();
		searchResultPage.clickOnProduct();
		productDetailsPage = new ProductDetailsPage();
		productDetailsPage.clickOnAddToCart();
		cartPage = new CartPage();
		cartPage.clickOnCheckout2();
		checkoutPage = new CheckoutPage();
		checkoutPage.fillCheckoutDetails();
		checkoutPage.clickOnContinue();
		shippingPage = new ShippingPage();
		shippingPage.clickOnContinue();
		paymentPage = new PaymentPage();
		paymentPage.clickOnContinue();
		paymentInfoPage = new PaymentInfoPage();
		paymentInfoPage.clickOnContinue();
		confirmOrderPage = new ConfirmOrderPage();
		confirmOrderPage.clickOnConfirm();
		orderPlacePage = new OrderPlacePage();
		Assert.assertEquals(orderPlacePage.getOrderSuccessMessage(), "Your order has been successfully processed!");
		orderPlacePage.clickOnContinue();
	}

}
