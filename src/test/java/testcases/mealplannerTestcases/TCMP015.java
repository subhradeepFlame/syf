package testcases.mealplannerTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP015 extends BaseClass{
	
	@Test
	public void VerifyUserCanAddMealBySearch(){
		
		String searchedFood="Ban";
		
		testStepsLog("Login user");
		loginpage.Login("autouserqa4@mailinator.com", con.getLoginPassword());

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

		testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");

		testStepsLog("Click on Generate Meal button");
		clickOn(mealplannerpage.generateMealButton);

		testStepsLog("Verify the setting your meal planner message shows");
		String setMealMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("We are setting your meal planner. Please be patient.", setMealMessage);
		testVerifyLog("Success message: "+ setMealMessage);
		
		testStepsLog("Click on Search Food ");
		clickOn(mealplannerpage.searchField);
		
		testStepsLog("Write food name");
		enterValue(mealplannerpage.searchField,searchedFood);
		
		testStepsLog("Verify the search result is showing correctly");
		Assert.assertEquals(mealplannerpage.checkSearchedFoodShowingCorrectly(searchedFood), true);	
		
		testStepsLog("Click on the food");
		String addedSearchedFood=mealplannerpage.clickOnSearchedFood(1);
		
		testStepsLog("Click on add to meal button");
		clickOn(mealplannerpage.addToMealButton);
		
		testStepsLog("Select meal as breakfast");
		mealplannerpage.selectFoodSectionInsearchedFood("Breakfast");
		
		testStepsLog("Click on save button");
		clickOn(mealplannerpage.saveButton);
		
		testStepsLog("Verify success message");
		String addMealMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("The meal item successfully added to this meal", addMealMessage);
		testVerifyLog("Success message: "+ setMealMessage);
		
		testStepsLog("Click on meal planner from left menu");
		mealplannerpage.ClickOnLeftMenu("Meal Planner");
		
		testStepsLog("Verify searched food is added to the brakfast");
		visibilityOfElement(driver.findElement(By.xpath("//h6[text()='Breakfast']/../../../..//h5[contains(text(),'"+addedSearchedFood+"')]")));

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
