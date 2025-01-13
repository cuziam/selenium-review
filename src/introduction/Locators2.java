package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String username = "rahul";

		// global setting
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// enter id,password , try login , click forgot your password
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);

		// print login success message
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + username + ',');
		
		//click LOG OUT
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(1000);
		
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(1000);
		
		String text=driver.findElement(By.cssSelector("form p")).getText();
		
		return text.split("'")[1].split("'")[0];
		
	}
	
}
