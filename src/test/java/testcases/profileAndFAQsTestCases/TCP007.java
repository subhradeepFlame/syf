package testcases.profileAndFAQsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP007 extends BaseClass {

	@Test
	public void VerifyForNonSubscribedUserInvoiceNotShowing() {

		testStepsLog("Login user");
		loginpage.Login("User 1");

		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");

		testStepsLog("Verify Invoice details are not showing");
		try {
			visibilityOfElement(profilepage.invoiceDetails);
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Invoice details are not showing");
		}

		testStepsLog("Verify subscription details are not showing");
		try {
			visibilityOfElement(profilepage.subscriptionDetails);
			Assert.fail();
		} catch (Exception e1) {
			testVerifyLog("Subscription details are not showing");
		}

	}

}
