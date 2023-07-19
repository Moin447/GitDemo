import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsTabs_PartialScreenshot {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium learning\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
/*		This feature is only available in selenium 4
		you can use .newWindow(WindowType.WINDOW) to open new window and .newWindow(WindowType.TAB) to open new tab*/
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		
		driver.switchTo().window(childid);
		
		driver.get("https://rahulshettyacademy.com/");
		
		String courseName = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p')]"))
				.get(1).getText();
		
		driver.switchTo().window(parentid);
		
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
//		Here we get the element we want the screen shot of

//		We send the keys
		name.sendKeys(courseName);
		
// L126_This below code will generate partial screenshot ie screenshot of the element that has been failed
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

//		L127_Here we enter name(WebElement).getScreenshotAs(OutputType.FILE) to get the screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
//		File srcFile = name.getScreenshotAs(OutputType.FILE);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
//		Here we give the above srcfile and path 
//		FileUtils.copyFile(srcFile,new File("C:\\Users\\Moin\\Screenshot123.png"));
		File file1 = new File("C:\\Users\\Moin\\logo.png");
		FileUtils.copyFile(srcFile, file1);
		
//		L128_The below code is used to get height and width of element
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());
		
		driver.quit();
				
	}

}
