package testcases.mealplannerTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP008 extends BaseClass{
	
	@Test
	public void VerifyUserCanMarkMealAsDoNotWantToSee(){
		
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

        testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");

		testStepsLog("Click on Generate Meal button");
		clickOn(mealplannerpage.generateMealButton);

		testStepsLog("Verify the setting your meal planner message shows");
		String setMealMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("We are setting your meal planner. Please be patient.", setMealMessage);
		testVerifyLog("setting your meal planner message shows : "+ setMealMessage);
		
		testStepsLog("Get the first meal name of the snack section");
		String firstMealNameOfSnack = mealplannerpage.getMealTitle("Snack", 1);

		testStepsLog("Click on the 3 dot icon of a meal from the snack section and click on regenerate this item");
		mealplannerpage.clickOnMealOption("Snack",1,"Don");
		
		testStepsLog("Verify the success message");
		String notificationMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("Preferences saved successfully", notificationMessage);
		testVerifyLog("Success message Showing : "+notificationMessage );
		driver.navigate().refresh();
		waitForPageLoaded();
		
		testStepsLog(" Verify the meal is removed from the snack section ");
		try {
			visibilityOfElement(driver.findElement(By.xpath(
					"(//div[contains(@class,'vx-row w')]//h6[text()='Snack']/../../../..//div[@class='con-tab-ejemplo']//div)[1]//h5[text()='"
							+ firstMealNameOfSnack + "']")));
			Assert.fail();
		}

		catch (Exception e) {
			testVerifyLog("The meal is removed from the snack section ");
		}

		testStepsLog("Click on the dashboard");
		commonpage.ClickOnLeftMenu("Dashboard");
		
		testStepsLog("Verify the removed meal is showing in the dashboard Disliked Foods section");
	    scrollToElement(dashboardpage.dislikedFoodSection);
	    try {
		visibilityOfElement(driver.findElement(By.xpath("//h4[text()='Disliked Foods']/../../..//h5[text()='"+firstMealNameOfSnack+"']")));
		testVerifyLog("The removed meal is showing in the dashboard Disliked Foods section");
	    }
	    
	    catch(Exception e1) {
	    	Assert.fail();
	    }
		
		testStepsLog("Click on the 3 dot icon of the meal and click on remove from list ");
		dashboardpage.removeDislikefoods(firstMealNameOfSnack);
		
		testStepsLog("Verify success message is showing");
		String dislikedFoodRemoveMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("Food item has been successfully removed from the list .",dislikedFoodRemoveMessage);
		testVerifyLog("Success message is showing : "+ dislikedFoodRemoveMessage);
		
		testVerifyLog("Verify the meal is no longer in the disliked fodds section");
		try {
			visibilityOfElement(driver.findElement(By.xpath("//h4[text()='Disliked Foods']/../../..//h5[text()='"+firstMealNameOfSnack+"']")));
		    Assert.fail();
		}
		catch(Exception e2)
		{
			testVerifyLog("The meal is no longer in the disliked foods section");
		}
		
		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

		
		
		
		
		
	}

}
