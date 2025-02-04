package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
/*
		// 1
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		WebElement columnDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		// 테이블에 있는 모든 링크가 접속되었는지 확인하기 위해서 단순히 for문으로 click만 하면 이동을 하기 때문에
		// 차례대로 접근이 안된다.
		// 그렇다고 일일이 클릭하고 뒤로 가기를 누르기도 좀 그렇다.
		// 따라서 윈도우 핸들 메소드를 사용하는 게 좋을 것이다.
		*/
		//일단 열고
		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(Duration.ofSeconds(2));
		}

		// 윈도우 핸들러 생성 및 윈도우 선택 조작
		Set<String> abc = driver.getWindowHandles();// 4
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}
	}

}
