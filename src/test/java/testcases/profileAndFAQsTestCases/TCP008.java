package testcases.profileAndFAQsTestCases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP008 extends BaseClass {

	

	@Test
	public void VerifyUserWhoHasMealPlannerAccessCanSeeQuestionnaireButton()
	{
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");
		
		testStepsLog("Verify Answer Questionnaire button is showing");
		visibilityOfElement(profilepage.answerQuestionnaireButton);
		testVerifyLog("Answer Questionnaire button is showing");
		
		testStepsLog("Click on Answer Questionnaire button");
		clickOn(profilepage.answerQuestionnaireButton);
		
		testStepsLog("Verify user redirected to the questionnaire page");
		visibilityOfElement(questionnairepage.tellUsAboutYourselfText);
		testVerifyLog("User redirected to the questionnaire page");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
