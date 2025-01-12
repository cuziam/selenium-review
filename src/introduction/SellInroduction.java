package introduction;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

		
		driver.get("https://sso.teachable.com/secure/9521/identity/login/otp");
		driver.findElement(By.id("otp-login-btn")).click();
		
		//Warning: timeout
		//quit method: close associated all windows
		driver.quit();
	}

}
