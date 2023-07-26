package testcases.mealplannerTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP002 extends BaseClass{
	
	@Test
	public void VerifyUserCanAccessMealPlanner(){
		
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");
		
		testStepsLog("Verify meal not generated text showing");
		visibilityOfElement(mealplannerpage.mealNotGeneratedText);
		testVerifyLog("Meal not generated text showing");
		
		testStepsLog("Verify Generate Meal button showing");
		visibilityOfElement(mealplannerpage.generateMealButton);
		testVerifyLog("Generate Meal button showing");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
