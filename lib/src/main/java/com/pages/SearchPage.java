package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ExcelWorkbookUtils;

public class SearchPage {
	
	private WebDriver webDriver;
	private ExcelWorkbookUtils excelWorkbookUtils;
	
	private static final By SEARCH = By.xpath("//input[@id='mainSearchbar']");
	private static final By SELECTTV = By.xpath("//span[text()='tv']");
	private static final By SELECTSONY = By.xpath("//input[@id='brand-SONY']");
	private static final By SELECTSIZE = By.xpath("//input[@id='variants.normalizedSize-55 Pulgadas']");
	
	/**
	 * @param webDriver
	 * @param excelWorkbookUtils
	 * Constructor to assign the local variables to the parsed variables
	 */
	public SearchPage(WebDriver webDriver, ExcelWorkbookUtils excelWorkbookUtils) {
		this.webDriver = webDriver;
		this.excelWorkbookUtils = excelWorkbookUtils;
	}
	
	
	/**
	 * Method to find the search box and parse the desired product from datasheet
	 */
	public void search() {
		webDriver.findElement(SEARCH).sendKeys(excelWorkbookUtils.getCellDataValueAsaString(3, 1));
		System.out.println("Searching for : " + excelWorkbookUtils.getCellDataValueAsaString(3, 1));
	}
	
	/**
	 * Method to identify the searched product and open the search
	 */
	public void clickSearch() {
		webDriver.findElement(SELECTTV).click();
		System.out.println("Selected the Product");
	}
	
	/**
	 * Method to filter the brand SONY from the list of products avilabe
	 */
	public void selectBrand() {
		webDriver.findElement(SELECTSONY).click();
		System.out.println("Brand Filter applied");
	}
	
	/**
	 * Method to filter the Size of the screen from SONY brand TV
	 */
	public void selectSize() {
		webDriver.findElement(SELECTSIZE).click();
		System.out.println("Screen size Filter applied");
	}

}
