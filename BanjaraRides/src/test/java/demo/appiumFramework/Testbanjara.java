package demo.appiumFramework;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
public class Testbanjara extends capability{
	
		AndroidDriver<AndroidElement> driver;
		
		@BeforeTest
		public void setup() throws IOException, InterruptedException {
			startAppium().start();
		driver = hybridCapability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
		
		@Test(priority=0)
		public void startup() throws IOException, InterruptedException{
			AndroidElement bo_now=driver.findElement(MobileBy.AndroidUIAutomator("text(\"BOOK NOW\")"));
			TouchAction tact=new TouchAction(driver);
			tact.tap(TapOptions.tapOptions().withElement(element(bo_now))).perform();
			
			AndroidElement Hire=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Hire Bike\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(Hire))).perform();
			
			AndroidElement hornet=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"CB Hornet 160R\"))"));
			tact.tap(TapOptions.tapOptions().withElement(element(hornet))).perform();
			
			AndroidElement days=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"7 days \"))"));
			tact.tap(TapOptions.tapOptions().withElement(element(days))).perform();
			
			AndroidElement now=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Book Now\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(now))).perform();
			
			AndroidElement date=driver.findElement(By.id("com.forbinary.banjararide:id/llDateContainer"));
			tact.tap(TapOptions.tapOptions().withElement(element(date))).perform();
			
			driver.findElementByAccessibilityId("10 June 2023").click();
			
			driver.findElement(By.xpath("//*[@text='OK']")).click();
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		}
		
		@Test(priority=1)
		public void bookings() throws IOException, InterruptedException{
			AndroidElement menu=driver.findElementByAccessibilityId("Open");
			TouchAction tact=new TouchAction(driver);
			tact.tap(TapOptions.tapOptions().withElement(element(menu))).perform();
			
			AndroidElement bookings=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Bookings\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(bookings))).perform();
			Thread.sleep(3000);
			AndroidElement search=driver.findElementByAccessibilityId("Search");
			tact.tap(TapOptions.tapOptions().withElement(element(search))).perform();
			Thread.sleep(3000);
			driver.findElementById("com.forbinary.banjararide:id/search_src_text").sendKeys("activa");
			Thread.sleep(3000);
	    	AndroidElement Clear =	driver.findElementById("com.forbinary.banjararide:id/search_close_btn");
		    tact.tap(TapOptions.tapOptions().withElement(element(Clear))).perform();
		    Thread.sleep(3000);
		    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
		}
		@Test(priority=2)
		public void callUs() throws InterruptedException {
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Call Us\"))"))))).perform();
			driver.activateApp("com.forbinary.banjararide");
			driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			touchAction.press(PointOption.point(300, 1400)).waitAction().moveTo(PointOption.point(1050, 1400)).release().perform();
			touchAction.press(PointOption.point(500, 1400)).waitAction().moveTo(PointOption.point(1050, 1400)).release().perform();
			driver.findElement(By.xpath("//*[@resource-id='com.miui.home:id/all_apps_arrow']")).click();
			driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"BanjaraRide\"])[2]")).click();
		}
		@Test(priority=3)
		public void aboutUs() throws InterruptedException {
			
			AndroidElement about=driver.findElement(MobileBy.AndroidUIAutomator("text(\"About Us\")"));
			TouchAction tact=new TouchAction(driver);
			tact.tap(TapOptions.tapOptions().withElement(element(about))).perform();
			
			AndroidElement abo_us=driver.findElement(MobileBy.AndroidUIAutomator("text(\"About Company!\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(abo_us))).perform();
			
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			AndroidElement Address=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Address And Contact Number.\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(Address))).perform();
			Thread.sleep(3000);
		    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
		}
		@Test(priority=4)
		public void info_center() throws IOException, InterruptedException{
			AndroidElement menu=driver.findElementByAccessibilityId("Open");
			TouchAction tact=new TouchAction(driver);
			tact.tap(TapOptions.tapOptions().withElement(element(menu))).perform();
			
			AndroidElement bookings=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Information Center\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(bookings))).perform();
			
			AndroidElement term=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Terms & Conditions\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(term))).perform();
			
			AndroidElement term1=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Terms & Condition\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(term1))).perform();
			
			AndroidElement pdf=driver.findElement(By.id("com.forbinary.banjararide:id/llFileLinearLayout"));
			tact.tap(TapOptions.tapOptions().withElement(element(pdf))).perform();
			
			driver.findElement(By.xpath("//*[@text='OK']")).click();
			
			driver.findElement(By.xpath("//*[@text='Word']")).click();
			Thread.sleep(5000);
			driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			driver.findElement(By.xpath("//*[@text='BanjaraRide']")).click();
			Thread.sleep(2000);
		    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    Thread.sleep(2000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		
		@Test(priority=5)
		public void profile() throws IOException, InterruptedException{
			AndroidElement menu=driver.findElementByAccessibilityId("Open");
			TouchAction tact=new TouchAction(driver);
			tact.tap(TapOptions.tapOptions().withElement(element(menu))).perform();
			
			AndroidElement prof=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Profile\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(prof))).perform();
			
			AndroidElement edit=driver.findElement(By.id("com.forbinary.banjararide:id/action_edit"));
			tact.tap(TapOptions.tapOptions().withElement(element(edit))).perform();
			
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[1]")).clear();
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[1]")).sendKeys("Kaushik Biswas");
			
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[3]")).clear();
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[3]")).sendKeys("kaushikpop592@gmail.com");
			
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[4]")).clear();
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[4]")).sendKeys("Delhi");
			
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[6]")).clear();
			driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/edtInputProfile'])[6]")).sendKeys("1234567890");
			
			driver.findElement(By.xpath("//*[@text='Cancel']")).click();
			Thread.sleep(2000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		@Test(priority=6)
		public void languageChange() throws IOException, InterruptedException{
			AndroidElement menu=driver.findElementByAccessibilityId("Open");
			TouchAction tact=new TouchAction(driver);
			tact.tap(TapOptions.tapOptions().withElement(element(menu))).perform();
			
			AndroidElement prof=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Change Language\")"));
			tact.tap(TapOptions.tapOptions().withElement(element(prof))).perform();
			
			AndroidElement hin=driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/home_language_button'])[2]"));
			tact.tap(TapOptions.tapOptions().withElement(element(hin))).perform();
			
			AndroidElement menu1=driver.findElementByAccessibilityId("Open");
			tact.tap(TapOptions.tapOptions().withElement(element(menu1))).perform();
			AndroidElement prof1=driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/material_drawer_name'])[1]"));
			tact.tap(TapOptions.tapOptions().withElement(element(prof1))).perform();
			
			AndroidElement eng=driver.findElement(By.xpath("(//*[@resource-id='com.forbinary.banjararide:id/home_language_button'])[1]"));
			tact.tap(TapOptions.tapOptions().withElement(element(eng))).perform();
			Thread.sleep(2000);
//			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
	}