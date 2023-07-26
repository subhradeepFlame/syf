package testcases.profileAndFAQsTestCases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCP001 extends BaseClass {
	
	@Test
	public void VerifUserCanCheckFAQs()
	{
		
		testStepsLog("Login user");
		loginpage.Login("User 1");
		
		testStepsLog("Click on FAQs icon");
		clickOn(profilepage.FAQs);
		
		testStepsLog("Verify FAQs modal opened");
		visibilityOfElement(profilepage.FAQtext);
		testVerifyLog("FAQs modal opened");
		
		testStepsLog("Verify questions are showing");
		visibilityOfElement(profilepage.FaqQuestion);
		testVerifyLog("Questions are showing");
		pause(3);
		
		testStepsLog("Click on a question");
		clickOn(profilepage.questionDropdown);
		
	    testStepsLog(" Verify answer is showing");
		visibilityOfElement(profilepage.FaqAnswer);
		testVerifyLog("Answer is showing");
		
		testStepsLog("Click on the hide dropdown ");
		clickOn(profilepage.FAQansIconHide);
		
	    testStepsLog(" Click on the Cross icon");
	    clickOn(profilepage.FAQcloseIcon);
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
				
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
