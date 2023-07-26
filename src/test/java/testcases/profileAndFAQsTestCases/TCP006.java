package testcases.profileAndFAQsTestCases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP006 extends BaseClass {
	
	@Test
	public void VerifyForHodSubscribedUserInvoiceIsShowing() {
	
	
	testStepsLog("Login user");
	loginpage.Login("User 5");
	
	testStepsLog("Open profile");
	dashboardpage.ClickOnProfileMenu("Profile");
	
	testStepsLog("Verify Invoice details are showing");
	visibilityOfElement(profilepage.invoiceDetails);
	testVerifyLog("Invoice details are showing");
	
	testStepsLog("Verify subscription details are showing");
	visibilityOfElement(profilepage.subscriptionDetails);
	testVerifyLog("Subscription details are showing");
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
