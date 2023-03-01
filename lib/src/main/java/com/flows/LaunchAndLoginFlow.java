package com.flows;

import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.SearchPage;
import com.utils.ExcelWorkbookUtils;

public class LaunchAndLoginFlow {
	
	private WebDriver webDriver;
	private ExcelWorkbookUtils excelWorkbookUtils;

	public LaunchAndLoginFlow(WebDriver webDriver, ExcelWorkbookUtils excelWorkbookUtils) {
		this.webDriver = webDriver;
		this.excelWorkbookUtils = excelWorkbookUtils;
	}
	
	/**
	 * @throws InterruptedException
	 * Flow to login the application and search for a TV Product and use filters 
	 */
	public void homePageFlow() throws InterruptedException {
		
		HomePage homepage = new HomePage(webDriver,excelWorkbookUtils);
		homepage.email();
		homepage.password();
		homepage.createsession();
		homepage.sleep();
		homepage.continuelogin();
		
		SearchPage searchPage = new SearchPage(webDriver,excelWorkbookUtils);
		searchPage.search();
		searchPage.clickSearch();
		searchPage.selectBrand();
		searchPage.selectSize();
		
	}

}
