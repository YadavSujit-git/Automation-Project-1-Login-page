package com.in;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);

		// Username operation
		String user = "olama@gmail.com";
		driver.findElement(By.id("inputUsername")).sendKeys(user);

		// Password operation
		String password = "123456789";
		driver.findElement(By.name("inputPassword")).sendKeys(password);

		// Remember my username
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		// agree terms and condition.
		driver.findElement(By.cssSelector("#chkboxTwo")).click();

		// sign button
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);

		// getting error message
		WebElement errorMsg = driver.findElement(By.cssSelector("div.form-container p.error"));
		String display = errorMsg.getText();
		System.out.println(display);

		// forget passoward test
		driver.findElement(By.xpath("//div[@class='forgot-pwd-container']")).click();

		// forget password : name module
		WebElement name = driver
				.findElement(By.cssSelector(".form-container.sign-up-container input[placeholder= Name]"));
		name.sendKeys("Maradona");

		// email module
		WebElement email = driver
				.findElement(By.cssSelector(".form-container.sign-up-container input[placeholder= Email]"));
		email.sendKeys("maradona10@football.com");

		// phone module
		WebElement phone = driver
				.findElement(By.cssSelector(".form-container.sign-up-container input[placeholder='Phone Number']"));
		phone.sendKeys("1111111");

		// Reset login button
		 driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//driver.findElement(By.xpath("//button[contains(@class, 'reset-pwd-btn')]")).click();

		// extracting forget message
		WebElement resetpass = driver.findElement(By.className("infoMsg"));
		String reset = resetpass.getText();
		System.out.println(reset);
		String[] GetPass = reset.split("'");
		System.out.println(GetPass[1]);

		// getting back to login page
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(3000);

		// test 2
		driver.findElement(By.id("inputUsername")).sendKeys(user);// username
		// new password input
		String NewPassword = GetPass[1];
		driver.findElement(By.name("inputPassword")).sendKeys(NewPassword);
		// sign button
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3000);

		// Extracting the message of successfull login
		WebElement Login = driver.findElement(By.className("login-container"));
		String log = Login.getText();
		System.out.println(log);

		// Logout operation
		driver.findElement(By.className("logout-btn")).click();
		Thread.sleep(2000);

		driver.quit();

	}

}
