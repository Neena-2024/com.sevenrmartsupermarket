package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.constants.ProviderClass;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubcategoryPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;

//import basics.ProviderClassEg;

public class SubcategoryTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	SubcategoryPage subcategorypage;
	
	@Test(groups="sanity")
	public void verifySearchResult() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.searchSubCategory("Electronics", "Mobile");
		List<String> actualList=new ArrayList<String>();
		actualList=subcategorypage.getSearchResult();
		System.out.println(actualList);
		List<String> expectedList=new ArrayList<String>();
		expectedList.add("Mobile");
		System.out.println(expectedList);
		Assert.assertEquals(actualList ,expectedList);
	}
	@Test(retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyInvalidSearch() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.searchSubCategory("Electronics", "hbdfhdgui");
		String actualMessage=subcategorypage.resultNotfoundMeggaseVerification();
		System.out.println(actualMessage);
		String expectedMessage=".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@Test
	public void verifyAddingNewSubCategory() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		String product=GeneralUtility.getRandomName();
		subcategorypage.addingNewSubCategory("Electronics", product);
		String actualValue=subcategorypage.subCtegoryCreatedSuccessfullyMessageVerification();
		Assert.assertEquals(actualValue, "Alert!");
	}
	
	@Test(groups="sanity")
	public void verifyResetButtonIsenabledOrNot() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		boolean actualvalue=subcategorypage.resetButtonIsEnabled();
		System.out.println(actualvalue);
		Assert.assertTrue(actualvalue);
	}
	
	@Test(dataProvider="newsubcategory",dataProviderClass=ProviderClass.class)
	public void verifyInvalidSearchUsingDataProvider(String category,String subCategory) {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.searchSubCategoryDataProvider(category, subCategory);
		String actualMessage=subcategorypage.resultNotfoundMeggaseVerification();
		System.out.println(actualMessage);
		String expectedMessage=".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test(retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyInvalidSearchUsingRetryAnalyzer() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.searchSubCategory("Electronics", "hbdfhdgui");
		String actualMessage=subcategorypage.resultNotfoundMeggaseVerification();
		System.out.println(actualMessage);
		String expectedMessage="RESULT NOT FOUND";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test
	public void verifyInsertingImageInNewSubcategory() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		String product=GeneralUtility.getRandomName();
		subcategorypage.addingNewSubcategoryWithImage("Electronics", product);	
		String actualValue=subcategorypage.subCtegoryCreatedSuccessfullyMessageVerification();
		Assert.assertEquals(actualValue, "Alert!");
	}
	@Test
	public void verifyUserIsAbleToDeleteSubcategoryDetails() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.searchSubCategory("Electronics", "Gertha");
		subcategorypage.clickDeleteSubcategoryDetails();
		String actualText=subcategorypage.subcategoryDeletedSuccessfullyMessageDeletion();
		Assert.assertEquals(actualText, "Alert!");
	}
}
