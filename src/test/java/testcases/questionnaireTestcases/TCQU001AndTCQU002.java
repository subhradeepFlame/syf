package testcases.questionnaireTestcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCQU001AndTCQU002 extends BaseClass{

	@Test(priority = 1)
	public void verifyQuestionnaireOpensAutomatically() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		
		testStepsLog("Verify user is in sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in registration page");
		
		testStepsLog("Signup a new user");
		String userEmailId=registrationpage.SignupWithExcel();
		
		testStepsLog("Logout user");
		dashboardpage.ClickOnProfileMenu("Logout");
		
		testStepsLog("Login as Super Admin");
		adminpage.superAdminLogin();
		
		testStepsLog("Click on Administration");
		adminpage.ClickOnLeftMenu("Administration");

		testStepsLog("Click on Users");
		adminpage.ClickOnLeftMenu("Users");
		
		testStepsLog("Add active challenge product to the user");
		adminpage.addChallengeToUser(userEmailId, "Automation product 3");
		
		testStepsLog("Logout user");
		dashboardpage.ClickOnProfileMenu("Logout");
		
		testStepsLog("Login as the user");
		loginpage.Login(userEmailId, con.getLoginPassword());
		
		testStepsLog("Verify User redirects to the questionnaire page");
		visibilityOfElement(questionnairepage.PersonalDetailsText);
		testVerifyLog("User redirects to the questionnaire page");
		
	}
	
	@Test(priority = 2)
	public void checkQuestionnaireSubmitFlow() {
		
		testStepsLog("Click on the next button");
		clickOn(questionnairepage.nextButton);
		String questionnairePage1ErrorMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify error message");
		Assert.assertEquals(questionnairePage1ErrorMessage, "Please enter proper values to continue");
		testVerifyLog("Error message showing");
		
		testStepsLog("Select Gender as Male");
		questionnairepage.SelectGender("Male");
		
		testStepsLog("Select DOB");
		scrollToElement(questionnairepage.DOBField);
		questionnairepage.DOBField.click();
		questionnairepage.DobDate.click();
		
		testStepsLog("Select Where did you hear about us field");
		questionnairepage.WhereDidYouHearAboutUsField.click();
		questionnairepage.WhereDidYouHearAboutUsFieldAns.click();
		
		testStepsLog("Click on the next button");
		clickOn(questionnairepage.nextButton);
		String questionnairePage1SuccessMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify success message");
		Assert.assertEquals(questionnairePage1SuccessMessage, "Personal step completed successfully");
		testVerifyLog("Success message showing");
		
		testStepsLog("Verify User redirects to the questionnaire 2nd page");
		visibilityOfElement(questionnairepage.tellUsAboutYourselfText);
		testVerifyLog("User redirects to the questionnaire 2nd page");
		
		testStepsLog("Click on the next button");
		clickOn(questionnairepage.nextButton);
		String questionnairePgae2ErrorMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify error message");
		Assert.assertEquals(questionnairePgae2ErrorMessage, "Please enter proper values to continue");
		testVerifyLog("Error message showing");
		
		testStepsLog("Select primary goal field");
		questionnairepage.primaryGoalField.click();
		questionnairepage.primaryGoalFieldAns.click();
		
		testStepsLog("Enter Height");
		enterValue(questionnairepage.HeightFtField, "160");
		enterValue(questionnairepage.HeightInchField, "10");
		
		testStepsLog("Enter current Weight");
		enterValue(questionnairepage.currenrtWeightField, "160");
		
		testStepsLog("Enter target Weight");
		enterValue(questionnairepage.targetWeightField, "120");
		
		testStepsLog("Select activity level field");
		questionnairepage.activityLevelField.click();
		questionnairepage.activityLevelFieldAns.click();
		
		testStepsLog("Select currently motivated field");
		questionnairepage.currentlyHowMotivateField.click();
		questionnairepage.currentlyHowMotivateFieldAns.click();
		
		testStepsLog("Select WHAT IS YOUR LEVEL OF WEIGHT TRAINING EXPERIENCE field");
		questionnairepage.whatIsYourLevelField.click();
		questionnairepage.whatIsYourLevelFieldAns.click();
		
		testStepsLog("Select ON AVERAGE, HOW MANY HOURS OF SLEEP DO YOU GET PER NIGHT field");
		questionnairepage.howManyHoursOfSleepField.click();
		questionnairepage.howManyHoursOfSleepFieldAns.click();
		
		testStepsLog("Click on the next button");
		clickOn(questionnairepage.nextButton);
		String questionnairePgae2SuccessMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify success message");
		Assert.assertEquals(questionnairePgae2SuccessMessage, "Physical step completed successfully");
		testVerifyLog("Success message showing");
		
		testStepsLog("Verify User redirects to the questionnaire 3rd page");
		visibilityOfElement(questionnairepage.whatDoYouLikeToEatText);
		testVerifyLog("User redirects to the questionnaire 3rd page");
		
		testStepsLog("Click on the next button");
		clickOn(questionnairepage.nextButton);
		String questionnairePgae3ErrorMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify error message");
		Assert.assertEquals(questionnairePgae3ErrorMessage, "Please enter proper values to continue");
		testVerifyLog("Error message showing");
		
		testStepsLog("Select preferred diet");
		questionnairepage.selectPreferredDiet("All food");
		
		testStepsLog("Select Current nutrition habit");
		questionnairepage.currentNutritionHabitsField.click();
		questionnairepage.currentNutritionHabitsFieldAns.click();
		
		testStepsLog("Click on the next button");
		clickOn(questionnairepage.nextButton);
		String questionnairePgae3SuccessMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify success message");
		Assert.assertEquals(questionnairePgae3SuccessMessage, "Food choices step completed successfully");
		testVerifyLog("Success message showing");
		
		testStepsLog("Verify Page redirects to the nutrition targets page");
		visibilityOfElement(questionnairepage.NutritionTargetsText);
		testVerifyLog("Page redirected to the nutrition targets page");
		
		testStepsLog("Click on the submit button");
		clickOn(questionnairepage.submitButton);
		
		testStepsLog("Verify User redirects to the dashboard page");
		visibilityOfElement(dashboardpage.dashboardMenuText);
		String currentLink = driver.getCurrentUrl();
		Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/account/dashboard", currentLink);
		testVerifyLog("User redirects to the dashboard page");
		
		
		
		
		
		
		
	}
	
	
	
}
