package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {
	ExcelReader excelreader=new ExcelReader();
	LoginPage loginpage;
	HomePage homepage;
	
	@Test(groups="smoke")
	public void verifyAdminUserLogin() {
		excelreader.setExcelFile("LoginPageData","SignInData");
		String usernameData=excelreader.getCellData(1,0);
		String passwordData=excelreader.getCellData(1,1);
		loginpage = new LoginPage(driver);
		homepage=new HomePage(driver);
		
		loginpage.login(usernameData,passwordData);
		String actualProfilename=homepage.getProfileName();
		String expectedProfileName="Admin";
		Assert.assertEquals(actualProfilename, expectedProfileName);
		
		
	}
	@Test(groups="sanity") 
	public void verifyloginButtonIsEnabled() {
		loginpage=new LoginPage(driver);
		boolean actualValue=loginpage.signInButtonEnabled();
		Assert.assertTrue(actualValue);
	}
	@Test(groups="regression")
	public void verifyCkeckboxIsEnabled() {
		loginpage=new LoginPage(driver);
		boolean actualStatus=loginpage.checkBoxEnabled();
		Assert.assertTrue(actualStatus);
	}
	
	@Test(groups= {"smoke","regression"})
	public void verifyInvalidLoginDetails() { 
		loginpage=new LoginPage(driver);
		loginpage.login("invalid", "invalid");
		
		
		String actualalert=loginpage.getAlertText();
		System.out.println(actualalert);
		String expectedalert="Alert!";
		System.out.println(expectedalert);
		Assert.assertEquals(actualalert, expectedalert);		
				
		
	}

}
