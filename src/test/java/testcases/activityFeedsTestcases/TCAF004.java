package testcases.activityFeedsTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCAF004 extends BaseClass{

	@Test
	public void VerifyUserCanPinPosts() {
		
		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Click on Activity Feeds");
		dashboardpage.ClickOnLeftMenu("Activity Feeds");

		testStepsLog("Verify pinned by admin posts are showing top");
		Assert.assertEquals(activityfeedspage.checkFirstPostIsPinned(), true);
		testVerifyLog("Pinned by admin posts are showing top");
		
		
		
	}
}
