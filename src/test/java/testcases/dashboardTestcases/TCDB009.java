package testcases.dashboardTestcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCDB009 extends BaseClass{
	
	@Test
	public void checkRedirectionOfMealPlannerPage() {
		
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("Click on View Details");
		clickOn(dashboardpage.todaysMealViewDetails);
		
		testStepsLog("Verify user is getting redirected to meal planner page");
		String currentLink = driver.getCurrentUrl();
		Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/account/mealplanner", currentLink);
		testVerifyLog("User redirects to meal planner page");
	}
	

}
