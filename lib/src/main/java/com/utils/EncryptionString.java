package com.utils;

public class EncryptionString {

	/**
	 * Sample Method used to encrypt the data and store the values to datafiles
	 */
	public static void main(String[] args) {
		final String secretKey = "secret";

		//Enter the value to Original String to convert the string into encryption 
		String originalString = "Enter your string value here to convert";
		String encryptedString = Encryption.encrypt(originalString, secretKey);
		String decryptedString = Encryption.decrypt(encryptedString, secretKey);

		System.out.println(originalString);
		System.out.println(encryptedString);
		System.out.println(decryptedString);
	}

}
