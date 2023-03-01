package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flows.LaunchAndLoginFlow;
import com.utils.ExcelWorkbookUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchAndLogin {

	private WebDriver webDriver;
	private ExcelWorkbookUtils excelWorkbookUtils;

	/**
	 * Setting up a Driver Server with the desired options
	 */
	@Deprecated
	@BeforeTest
	public void setup() {

		// Calling method Excelworkbookutils from Utils package to specify the datasheet location
		excelWorkbookUtils = new ExcelWorkbookUtils("./datafiles/DataSheet.xlsx", "Sheet1");

		// setting up a chrome driver with required version using webdrivermanager
		WebDriverManager.chromedriver().driverVersion("95").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");
		webDriver = new ChromeDriver(options);
		webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		System.out.println("Chromedriver V95 is launched with options");

	}

	/**
	 * Launching the application and asserting the title
	 */
	@Test(priority = 1)
	public void launchTest() {

		// open the Liver pool login page
		webDriver.get(excelWorkbookUtils.getCellDataValueAsaString(0, 1));
		webDriver.manage().window().maximize();
		System.out.println("Launched URL : " + excelWorkbookUtils.getCellDataValueAsaString(0, 1));
		Assert.assertEquals("Iniciar sesión en Liverpool", webDriver.getTitle());
	}

	/**
	 * @throws InterruptedException Login the application using credentials and
	 *                              search for a desired product
	 */
	@Test(priority = 2)
	public void selectStore() throws InterruptedException {
		LaunchAndLoginFlow launchAndLoginFlow = new LaunchAndLoginFlow(webDriver, excelWorkbookUtils);
		launchAndLoginFlow.homePageFlow();
	}

	/**
	 * Closing the browser properly without holding java heap memory
	 */
	@AfterTest
	public void shutdown() {
		// Closing the WebDriver
		webDriver.quit();
	}

}
