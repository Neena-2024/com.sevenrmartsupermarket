package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}
	public void selectByvisibleText(WebElement element,String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void mousedoubleClick(WebElement element) {
		actions.doubleClick(element).build().perform();
	}

	public void scrollToelement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void acceptJSAlert() {
		driver.switchTo().alert().accept();
	}

	public boolean isClicked(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void scrollAndClick(WebElement element) {
		int index = 0;
		while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + index + ")");
			index = index + 2;
		}
	}
	public void waitAndClick(WebElement element) {
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.waitForElementToBeClickable(element, 20);
		element.click();
	}
}