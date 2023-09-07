package com.nopcommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.pageobjects.CartPage;
import com.nopcommerce.pageobjects.HomePage;
import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.pageobjects.ProductDetailsPage;
import com.nopcommerce.pageobjects.SearchResultPage;

public class CartPageTest extends BaseClass{
	
	public HomePage homePage;
	public SearchResultPage searchResultPage; 
	public ProductDetailsPage productDetailsPage;
	public CartPage cartPage;
	public LoginPage loginPage;
	
	@Test
	public void verifyProductTotalPrice() {
		homePage = new HomePage();
		homePage.searchProduct("macbook");
		homePage.clickOnSearch();
		searchResultPage = new SearchResultPage();
		searchResultPage.clickOnProduct();
		productDetailsPage = new ProductDetailsPage();
		productDetailsPage.clickOnAddToCart();
		cartPage = new CartPage();
		Assert.assertEquals(cartPage.getTotalPrice(), "$3,600.00");
	}

}
