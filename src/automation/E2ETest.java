package automation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2ETest {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the target URL
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Select one-way trip option
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // Select origin station
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        // Pause for 2 seconds to allow UI update
        Thread.sleep(2000);

        // Select destination station
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        // Select the current date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        // Check if the return date field is disabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("Return date selection is disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        // Select senior citizen discount option
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Open passenger selection dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        // Increment adult passenger count to 5
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Close passenger selection dropdown
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Assert that the selected passenger count is correct
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Click the search button
        driver.findElement(By.cssSelector("input[value='Search']")).click();

        // Close the browser
        driver.quit();
        
        //추가정보 alert요소를 테스트 하려면 driver.switchTo().alert().getText()이런 식으로 alert의 메세지를 가지고 올 수 있다.
        //alert는 webelement가 아니라서 메소드가 달라지는 것임
        //driver.switchTo().alert().dismiss() 콘텍스트 전환.
    }
}
