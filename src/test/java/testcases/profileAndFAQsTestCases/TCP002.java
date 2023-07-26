package testcases.profileAndFAQsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP002 extends BaseClass {
	
	@Test
	public void VerifyUserCanCheckProfileDetails()
	{
		
		testStepsLog("Login user");
		loginpage.Login("User 1");
		
		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");
		
	    testStepsLog("Verify profile page opened");
	    String currentLink = driver.getCurrentUrl();
		Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/account/profile", currentLink);
		testVerifyLog("Profile page opened");
		
		testStepsLog("Verify general profile details are showing");
		visibilityOfElement(profilepage.firstNameText);
		testVerifyLog("General profile details are showing");
		
				
		
		
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
}
