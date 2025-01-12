package introduction;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class SellInroduction{

	public static void main(String[] args) {
		//Invoking Browser
		//Chrome - ChromeDriver -> Methods
		//Webdriver close get
		//Webdriver methods + class methods
		
		
		//chromedriver.exe -> chrome browser.
		
		//webdriver.chrome.driver->value of path
		WebDriver driver=new ChromeDriver();
		/*		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		 */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUserName")).sendKeys("yameame320");
		driver.findElement(By.id("inputPassword")).sendKeys("nanatuyis");
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.
		
		
		//driver.findElement(By.id("Changsoo")).getSize();//defect
		//driver.findElement(By.xpath("//*[@id=\"otp-login\"]/div/div[2]/a")).click();/ /Xpath와 css selector는 id가 없을 떄 사용하는 게 좋다.
		//Warning: timeout
		//quit method: close associated all windows
		driver.quit();
	}

}
