package testcases.livestreamTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCLS002 extends BaseClass{

	@Test
	public void verifyLivestreamVideoIsPlayingAutomatically() {
		
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("Click on the Livestream");
		dashboardpage.ClickOnLeftMenu("Livestream");
		
		testStepsLog("Verify the livestream video is playing automatically");
		Assert.assertEquals(livestreampage.VerifyVideoIsPlaying(), true);
		testVerifyLog("livestream video is playing automatically");
		
	}
}
