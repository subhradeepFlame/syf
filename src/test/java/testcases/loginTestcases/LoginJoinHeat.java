package testcases.loginTestcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class LoginJoinHeat extends BaseClass {

	@Test
	public void VerifyBlankRequiredFields1() {

		driver.get("https://app.joinheatchallenge.com/login");
		waitForPageLoaded();
		System.out.println("sdasdasd: "+loginpage.getjoinheatuserdomain());
		enterValue(driver.findElement(By.xpath("//input[@name='email']")), loginpage.getjoinheatuserdomain());
		enterValue(driver.findElement(By.xpath("//input[@name='password']")), "123456");
		
		if(driver.findElement(By.xpath("")).isEnabled()) {
			
		}
		else {
			System.out.println("email: "+loginpage.getjoinheatuserdomain());
		}
	}

}
