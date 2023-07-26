package testcases.dashboardTestcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCDB002 extends BaseClass{

	
	@Test
	public void inputWeight() {
		
		int value= randomValue(100, 150);
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Verify input weight button is showing");
		visibilityOfElement(dashboardpage.inputWeightButton);
		testVerifyLog("input weight button is showing");
		
		testStepsLog("Input weight");
		dashboardpage.inputWeight(Integer.toString(value), "lbs");
		String notificationText = visibilityOfElement(commonpage.notification).getText();
		
		testStepsLog("Verify success messsage");
		Assert.assertEquals(notificationText, "Weight check-in successfully");
		testVerifyLog("Success message showing : "+notificationText);
		
		testStepsLog("Verify Weight inputed successfully");
		Assert.assertEquals(dashboardpage.currentWeight(1), value+" lbs");
		testVerifyLog("Weight inputed successfully");
	}
}
