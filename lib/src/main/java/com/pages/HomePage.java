package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.Encryption;
import com.utils.ExcelWorkbookUtils;

public class HomePage {

	private WebDriver webDriver;
	private ExcelWorkbookUtils excelWorkbookUtils;
	final String secretKey = "secret";
	
	private static final By EMAIL = By.xpath("//input[@id='username']");
	private static final By PASSWORD = By.xpath("//input[@id='password']");
	private static final By SUBMIT = By.xpath("//button[text()='Iniciar sesión']");
	
	private static final By CONTINUE = By.xpath("//button[@type='submit' and @value='default']");
	
	/**
	 * @param webDriver
	 * @param excelWorkbookUtils
	 * Constructor to assign the local variables to the parsed variables
	 */
	public HomePage(WebDriver webDriver, ExcelWorkbookUtils excelWorkbookUtils) {
		//assigning the local variables to the parsed variable content
		this.webDriver = webDriver;
		this.excelWorkbookUtils = excelWorkbookUtils;
	}
	
	
	/**
	 * Method to identify the Email input block and parse the value
	 */
	public void email() {
		webDriver.findElement(EMAIL).sendKeys(excelWorkbookUtils.getCellDataValueAsaString(1, 1));
		System.out.println("User Email Entered");
	}
	
	/**
	 * Method to identify the Password input block and parse the Decrypted value
	 */
	public void password() {
		webDriver.findElement(PASSWORD).sendKeys(Encryption.decrypt(excelWorkbookUtils.getCellDataValueAsaString(2, 1), secretKey));
		System.out.println("User Password Entered");
	}
	
	/**
	 * Method to submit the entered values and perform login
	 */
	public void createsession() {
		webDriver.findElement(SUBMIT).click();
		System.out.println("User deatils are submitted sucessfully");
	}
	
	/**
	 * Method to continue after a user inputs the OTP
	 */
	public void continuelogin () {
		webDriver.findElement(CONTINUE).click();
		System.out.println("User Logged in");
	}
	
	/**
	 * Method to create a sleep for 15 Seconds
	 */
	public void sleep() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
