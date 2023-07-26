package testcases.dashboardTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCDB001 extends BaseClass{

	@Test
	public void CheckUserInputWeightNegetive() {
		
		testInfoLog("Login user");
		loginpage.Login("User 1");
		
		testStepsLog("Verify input weight button is not showing");
		try {
			visibilityOfElement(dashboardpage.inputWeightButton);
			Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("input weight button is not showing");
		}
		
	}

}