package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ProviderClass {
	ExcelReader excelreader=new ExcelReader();
	@DataProvider(name = "newsubcategory")
	public Object[][] products() {
		excelreader.setExcelFile("SubCategory", "InvalidSearch");
		return excelreader.getMultidimentinalData(3, 2);
		
	}

}
