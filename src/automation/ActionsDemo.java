package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

//Actions API는 키보드, 마우스 (휠 포함), 펜이나 터치 장치 처리가 가능하다.
//즉 복잡한 상호작용 처리를 위해 만들어져있다.
public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naver.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Actions a = new Actions(driver);
		// 타겟
		WebElement targetEle = driver.findElement(By.id("query"));

		// cafe 복합 액션
		a.moveToElement(targetEle).pause(Duration.ofSeconds(1)).click().keyDown(Keys.SHIFT).sendKeys("selenium").build().perform();
		//드래그앤드롭, 더블클릭 등도 수행가능하다.

	}
}
