package Eval1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eval1 {
	@Test(enabled = false)
	public void uploadfile() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver() ;
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement file = driver.findElement(By.id("file-upload"));
		file.sendKeys(("C:\\Users\\user\\Downloads\\Github team star-catcher.postman_collection.json"));
		driver.findElement(By.id("file-submit")).click();
		driver.close();
	}
	
	@Test
	public void radiobutton() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver() ;
		driver.get("https://designsystem.digital.gov/components/radio-buttons/");
		driver.findElement(By.xpath("(//label[@for='historical-washington'])[1]")).click();
		driver.close();
	}
	
	@Test
	public void alert() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver() ;
		driver.get(" https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button[normalize-space()='Click for JS Confirm'])[1]")).click();
		driver.switchTo().alert().dismiss();
		driver.close();
	}
	
	@Test(enabled = false)
	public void maketrip() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver() ;
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("(//a[normalize-space()='Search'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		driver.findElement(By.xpath("(//input[@id='listingFilterCheckbox'])[1]")).click();
		//driver.close();
	}
}
