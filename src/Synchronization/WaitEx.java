package Synchronization;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//암묵적 대기는 기본 대기값, 명시적 대기는 특정 요소의 조건에 맞춰 대기할 수 있다.
//암묵적 대기는 성능을 파악하기가 힘들다. 하지만 코드는 더 읽기 쉬워진다.
//플루언트 대기는 명시적 대기 기법 중 하나다. 
//폴링 방식으로 조건 만족을 기다린다. 즉 일정간격으로 콜백함수를 실행해서 조건에 맞게 요소를 불러올 수 있다.
//대부분의 경우엔 WebDriverWait방식으로 명시적 대기가 가능하지만,
public class WaitEx {
	public static void main(String[] args) throws InterruptedException {
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		
		// default wait time: 5s
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    // 명시적 대기를 위한 WebDriverWait 객체 생성
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
		// Items to add to the cart
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		// Navigate to the website
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// Add items to the cart
		addItems(driver, itemsNeeded);

		//click cart icon, click proceed to checkout
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//enter coupon code
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		//click apply button
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//explicit wait, wait for coupon apply
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		//System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		//click place order
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int itemCount = 0;

		// Get the list of products displayed on the page
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			// Extract the product name (e.g., "Brocolli - 1 Kg" -> "Brocolli")
			String[] nameParts = products.get(i).getText().split("-");
			String formattedName = nameParts[0].trim();

			// Convert array to a list for easy searching
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			// Check if the current product is in the list of items needed
			if (itemsNeededList.contains(formattedName)) {
				itemCount++;

				// Click "Add to cart" button for the product
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// Exit the loop if all items have been added
				if (itemCount == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
