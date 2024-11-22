package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String getgAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getCssVAlue(WebElement element, String cssproperty) {
		return element.getCssValue(cssproperty);
	}

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}
	public String getTextValue(WebElement element) {
		return element.getText();
	}
	
	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	public static String getRandomName() { //for adding random data(dynamically adding data)
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	
}
