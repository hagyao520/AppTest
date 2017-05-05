package yy;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClickTest {
	private AndroidDriver<WebElement> driver;

	@BeforeClass(alwaysRun = true,description="初始化AndroidDriver")
	public void setUp() throws Exception{
		//初始化capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();


		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot,"apps");
		File app = new File(appDir,"yymobile_client-5.4.2-881.apk");
		capabilities.setCapability("app", app.getAbsolutePath());
		
		//初始化deviceName
        capabilities.setCapability("deviceName","Android Emulator");
        
        //设置app的主包名和主类名，如果使用已安装好的app，则打开
//        capabilities.setCapability("appPackage", "com.duowan.mobile");
//        capabilities.setCapability("appActivity", "com.yy.mobile.ui.ylink.LinkMobileLiveActivity");
        
  
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	@Test
	 public void clickTest() throws InterruptedException{
	
//		boolean finish = false;
//		
//		while(!finish){
//			finish = isElementVisible(By.id("com.duowan.mobile:id/rb_main"));
//			swipeRightToLeft();
//			if(isElementVisible(By.id("com.duowan.mobile:id/splash_begin"))){
//				driver.findElement(By.id("com.duowan.mobile:id/splash_begin")).click();
//				finish = true;
//			}
//		}
//		//找到直播按钮
//		WebElement zhiboBtn = driver.findElement(By.id("com.duowan.mobile:id/rb_main"));
//		//点击直播按钮
//		zhiboBtn.click();
	}

	public boolean isElementVisible(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			System.out.println("Element [" + by.toString() + "] is visible in current context.");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element [" + by.toString() + "] is not visible in current context.");
		} catch (TimeoutException e){
			System.out.println("Element [" + by.toString() + "] is not visible in current context.");
		}
		return false;
	}
	
	public void swipeRightToLeft() {
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		final TouchAction gesture = new TouchAction(driver)
				.press(width/2,height/2).waitAction(100)
				.moveTo(-width/4, 0).waitAction(100).release();
				gesture.perform();
	}
	
	@AfterTest
	  public void teardown() throws Exception {
		  
		driver.quit();
	  }
}
