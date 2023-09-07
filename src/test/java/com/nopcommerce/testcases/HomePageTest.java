package com.nopcommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.baseclass.BaseClass;
import com.nopcommerce.pageobjects.HomePage;
import com.nopcommerce.pageobjects.SearchResultPage;

public class HomePageTest extends BaseClass{
	
	public HomePage homePage;
	public SearchResultPage searchResultPage;

	@Test(priority = 1)
	public void verifyPageTitle() {
		homePage = new HomePage();
		Assert.assertEquals(homePage.getTitle(), "nopCommerce demo store");
	}
	
	@Test(priority = 2)
	public void verifyLogo() {
		homePage = new HomePage();
		homePage.checkLogo();
	}
	
	@Test(priority = 3)
	public void verifyProductSearchFunctionality() {
		homePage = new HomePage();
		homePage.searchProduct("macbook");
		homePage.clickOnSearch();
		searchResultPage = new SearchResultPage();
		searchResultPage.clickOnProduct();
	}

}
