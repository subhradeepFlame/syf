package testcases.mealplannerTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP001 extends BaseClass{
	
	@Test
	public void VerifyUserCanotAccessMeaPlanner(){
		
		testStepsLog("Login user");
		loginpage.Login("User 1");
		
		testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");
		
		testStepsLog("Verify You don't have any active or upcoming challenge text is showing");
		visibilityOfElement(mealplannerpage.noSubscriptionText);
		testVerifyLog(" You don't have any active or upcoming challenge text is showing");
		
		
		testStepsLog("Verify Buy Now button is available");
		visibilityOfElement(challengevideospage.buyNowButton);
		
		testStepsLog("Click on the Buy Now button");
		clickOn(challengevideospage.buyNowButton);
		switchTab(1);
		
		testStepsLog("Verify user redirected to the purchase challenge page");
		visibilityOfElement(mealplannerpage.challengePurchaseCartIcon);
		testVerifyLog("User redirected to the purchase challenge page");
		
		
		
		
		
		
	}

}
