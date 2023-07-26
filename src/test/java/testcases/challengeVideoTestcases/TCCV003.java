package testcases.challengeVideoTestcases;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCCV003 extends BaseClass {

	@Test
	public void verifyUserCanAccessChallengeVideoBefore7Days()
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		testStepsLog("Login as Super Admin");
		adminpage.superAdminLogin();

		testStepsLog("Click on challenges");
		adminpage.ClickOnLeftMenu("Challenges");
		
		testStepsLog("Change start date of challenge to next date");
		adminpage.updateChallengeStartDateToNextDate("Automation challenge 3");

		testStepsLog("Logout user");
		dashboardpage.ClickOnProfileMenu("Logout");

		testStepsLog("Login user");
		loginpage.Login("User 6");

		testStepsLog("Click on the challenge videos");
		commonpage.ClickOnLeftMenu("Challenge Videos");

		testStepsLog("Verify challenge videos are showing");
		visibilityOfElement(challengevideospage.challengeVideosDiv);
		testVerifyLog("challenge videos are showing");

	}

}
