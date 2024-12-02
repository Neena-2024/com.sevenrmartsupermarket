package com.sevenrmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	
	@Test(priority=2)
	public void verifyAdminUsersIsEnabled() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		homepage.clickAdminUsers();
		String actualText=homepage.adminUserPageDisplay();
		Assert.assertEquals(actualText, "Admin Users");
	}
	@Test(priority=3)
	public void verifySubcategoryIsEnabled() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		homepage.clickSubCategory();
		String actualValue=homepage.subCategoryPageDisplay();
		Assert.assertEquals(actualValue, "List Sub Categories");
	}
	@Test(priority=4)
	public void verifyTitleOfApplicationIsPresent() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		String actualTitle=homepage.isTitlePresent();
		Assert.assertEquals(actualTitle, "Dashboard | 7rmart supermarket");
	}
	@Test(priority=1)
	public void verifyLogoutActionSuccefullyWorking() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		homepage.clickLogout();
		String actualText=homepage.loginPageText();
		Assert.assertEquals(actualText, "7rmart supermarket");
	}
	


}
