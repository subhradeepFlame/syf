package testcases.dashboardTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCDB003 extends BaseClass{

	
	@Test
	public void checkInputedWeightViewFormat() {
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Change weight details format to kg");
		dashboardpage.changeWeightDetailsViewFormat("kg");
		
		testStepsLog("Verify weight details are showing in kg");
		Assert.assertEquals("Kg", dashboardpage.currentWeightFormat.getText());
		testVerifyLog("Weight details are showing in kg");
		
		testStepsLog("Change weight details format to lbs");
		dashboardpage.changeWeightDetailsViewFormat("lbs");
		
		testStepsLog("Verify weight details are showing in lbs");
		Assert.assertEquals("lbs", dashboardpage.currentWeightFormat.getText());
		testVerifyLog("Weight details are showing in lbs");
	}
}
