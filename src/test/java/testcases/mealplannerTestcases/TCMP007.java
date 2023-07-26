package testcases.mealplannerTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP007 extends BaseClass {

	@Test
	public void VerifyUserCanRemoveMealFromMealSections() {

		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

		testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");

		testStepsLog("Click on Generate Meal button");
		clickOn(mealplannerpage.generateMealButton);

		testStepsLog("Verify setting your meal planner message shows");
		String setMealMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("We are setting your meal planner. Please be patient.", setMealMessage);
		testVerifyLog("setting your meal planner message shows : "+ setMealMessage);

		testStepsLog("Get the first meal name of the snack section");
		String firstMealNameOfSnack = mealplannerpage.getMealTitle("Snack", 1);

		testStepsLog("Click on the 3 dot icon of a meal from the snack section and click on regenerate this item");
		mealplannerpage.clickOnMealOption("Snack", 1, "Remove");
		clickOn(mealplannerpage.removeMealClearButton);

		testStepsLog("Verify success message");
		String notificationMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("Meal item successfully cleared", notificationMessage);
		testVerifyLog("success message showing : "+ notificationMessage);

		testStepsLog(" Verify the meal is not present in the snack section");
		try {
			visibilityOfElement(driver.findElement(By.xpath(
					"(//div[contains(@class,'vx-row w')]//h6[text()='Snack']/../../../..//div[@class='con-tab-ejemplo']//div)[1]//h5[text()='"
							+ firstMealNameOfSnack + "']")));
			Assert.fail();
		}

		catch (Exception e) {
			testVerifyLog("The meal is not present in the snack section");
		}

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

	    
	
	
	
	
	}
	
	
	
	
	

}
