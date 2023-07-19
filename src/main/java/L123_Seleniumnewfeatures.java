import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
// By default eclipse will not give autosuggestion for this package as it is static hence we have to manually type it

public class L123_Seleniumnewfeatures {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium learning\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameFiled = driver.findElement(By.xpath("//input[@name='name']"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameFiled)).getText());
//		We can find relative locators only with tagname hence the code is with(By.tagName("label")
//		After writing the tagName we should add the relative locator like .above(nameFiled)
		
		WebElement DOBlabel = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(DOBlabel)).click();
/*		As the WebElement is flex and relative locators does not support flex html component
		so it will go to next element which is button and we will click it*/
		
		WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
		
		WebElement label = driver.findElement(By.id("inlineRadio1"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(label)).getText());
		
		System.out.println("Hello");
		
	}

}
