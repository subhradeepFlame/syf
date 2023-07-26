package testcases.heatOnDemandTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCHOD002 extends BaseClass {

	@Test
	public void VerifySubscribedUsersCanAccessHODvideos() {

		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Click on the Heat On Demand");
		commonpage.ClickOnLeftMenu("Heat On Demand");

		testStepsLog(" Verify there are no locked videos");
		try {
			visibilityOfElement(heatondemandpage.Videoslockicon);
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verify there are no locked videos");

		}

		testStepsLog(" Click on a video subcategory");
		heatondemandpage.clickOnHODvideoSubCategory(heatondemandpage.getFirstHODvideoSubCategoryName());
		
		testStepsLog("Click on videos tab");
		clickOn(heatondemandpage.videosTab);
		
		testStepsLog("Click on a video");
		heatondemandpage.clickOnHODvideo(heatondemandpage.getFirstHODVideoName());

		testStepsLog("Verify page redirects to the video play page");
		visibilityOfElement(heatondemandpage.programDetailsText);
		testVerifyLog("Page redirects to the video play page");

		testStepsLog("Click on the play button");
		clickOn(heatondemandpage.videoPlayButton);

		testStepsLog("Verify video is playing");
		Assert.assertEquals(heatondemandpage.VerifyVideoIsPlaying(), true);
		testVerifyLog("Video is playing");

	}

}
