package introduction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowsActvities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://google.com");//새로운 웹페이지 로드
		driver.navigate().to("https://rahulshettyacademy.com");//이동
		driver.navigate().back();//뒤로가기
		driver.navigate().forward();//앞으로가기
	}

}
