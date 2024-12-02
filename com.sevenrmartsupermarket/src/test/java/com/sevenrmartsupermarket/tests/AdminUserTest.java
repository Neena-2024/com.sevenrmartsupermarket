package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUserTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	AdminUserPage adminuserpage;
	
	@Test(priority=2)
	public void verfyAlertBoxIsPresentWhenClickDeleteIconOfAdminUser()  {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserpage=new AdminUserPage(driver);
		loginpage.login();
		homepage.clickAdminUsers();
		String actualText=adminuserpage.clickOnDeleteAdminUserButton("super", "Admin");
		String expectedText="Do you want to delete this User?";
		Assert.assertEquals(actualText, expectedText);
	}
	@Test(priority=1)
	public void searchAdminUser() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserpage=new AdminUserPage(driver);
		loginpage.login();
		homepage.clickAdminUsers();
		adminuserpage.clickOnadminUserSearch().serachAdminUsers("Devon", "Staff").editAdminUserName("Devon", "Devan");
		String actualText=adminuserpage.getTextOfTheAlert();
		Assert.assertEquals(actualText, "Alert!");
		
		
	}

}
