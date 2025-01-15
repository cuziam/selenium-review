package automation;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KartAuto {
	public static void main(String[] args) throws InterruptedException {
		// Set ChromeDriver path
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// Items to add to the cart
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		// Navigate to the website
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);

		// Add items to the cart
		addItems(driver, itemsNeeded);

		// Close the browser
		driver.quit();
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
