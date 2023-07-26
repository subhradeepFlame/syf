package testcases.loginTestcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCLI001 extends BaseClass {

//	@Test
//	public void VerifyBlankRequiredFields1() {
//
//		testInfoLog("Login with blank email & password");
//		loginpage.Login("", "");
//
//	}
//	
//	@Test
//	public void test() {
//
//		System.out.println("sdsdsdsds 2");
//
//	}

//	@Test
//	public void test() throws InterruptedException {
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.get(
//				"https://survivalconstg.wpengine.com/offer/dev-test-01/?AFID=Codeclouds+Test+Page&utm_source=CCTestSource&utm_medium=CCTestMedium&utm_campaign=CCTestCampaign");
//		driver.findElement(By.linkText("BUY NOW")).click();
//		driver.findElement(By.id("mm_field_shipping_first_name")).click();
//		driver.findElement(By.id("mm_field_shipping_first_name")).sendKeys("test");
//		driver.findElement(By.id("mm_field_shipping_last_name")).sendKeys("codeclouds");
//		driver.findElement(By.id("mm_field_shipping_email")).sendKeys("test1@codeclouds.com");
//		driver.findElement(By.id("mm_field_shipping_phone")).sendKeys("1234556");
//		driver.findElement(By.id("mm_field_shipping_city")).sendKeys("ddggg");
//		{
//			WebElement dropdown = driver.findElement(By.id("mm_field_shipping_state_dd"));
//			dropdown.findElement(By.xpath("//option[. = 'Alabama']")).click();
//		}
//		driver.findElement(By.id("mm_field_shipping_zip")).sendKeys("12333");
//		driver.findElement(By.id("mm_field_shipping_address")).sendKeys("ddfgdfg");
//		driver.findElement(By.id("mm_field_cc_number")).click();
//		driver.findElement(By.id("mm_field_cc_number")).sendKeys("1444444444444440");
//		driver.findElement(By.id("mm_field_cc_cvv")).click();
//		driver.findElement(By.id("mm_field_cc_cvv")).sendKeys("1223");
//		driver.findElement(By.id("mm_field_cc_exp_year")).click();
//		{
//			WebElement dropdown = driver.findElement(By.id("mm_field_cc_exp_year"));
//			dropdown.findElement(By.xpath("//option[. = '2029']")).click();
//		}
//		driver.findElement(By.cssSelector(".col-md-12:nth-child(1) .sml_font_s")).click();
//		driver.findElement(By.cssSelector(".col-md-12:nth-child(2) .sml_font_s")).click();
//		driver.findElement(By.cssSelector(".col-md-12:nth-child(3) > .bump-box .sml_font_s")).click();
//		driver.findElement(By.id("Place_Order")).click();
//
//		Thread.sleep(10000);
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(
//				By.xpath("//label//strong[contains(text(),'ONE Additional Midnight Stealth')]/..//input")));
//		driver.findElement(By.xpath("//label//strong[contains(text(),'ONE Additional Midnight Stealth')]/..//input"))
//				.click();
//		Thread.sleep(5000);
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[text()='Buy Now!']")));
//		driver.findElement(By.xpath("//span[text()='Buy Now!']/../..")).click();
//		Thread.sleep(10000);
//
//		System.out.println("done");
//	}
	
	@Test
	public void test() {
//		String videoPath = System.getProperty("user.dir") + "/src/test/resources/incrementorValue";
		
		driver.get("https://www.digikey.com/ordering/shoppingcart");
		System.out.println(System.getProperty("user.dir"));
		waitForPageLoaded();
		pause(10);
		System.out.println("sdsdsd");
//		driver.findElement(By.xpath("//input[@id='UploadPartialPage']")).sendKeys(videoPath);
		pause(10);
		driver.findElement(By.xpath("(//u)[1]")).click();
		pause(10);
		uploadFile("E:\\Projects\\ShedYourFat\\src\\test\\resources\\incrementorValue");
		pause(10);

	}
	
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
	

}
