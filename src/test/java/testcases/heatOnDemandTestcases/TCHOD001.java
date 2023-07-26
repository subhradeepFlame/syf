package testcases.heatOnDemandTestcases;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCHOD001 extends BaseClass{
	
	@Test
	public void verifyUserCanSubscribeHODvideos() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		
		testStepsLog("Verify user is in the sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in the registration page");
		
		testStepsLog("Register a new user");
		registrationpage.SignupWithExcel();
		
		testStepsLog("Click on the Heat On Demand");
		commonpage.ClickOnLeftMenu("Heat On Demand");
		
		testStepsLog("Click on warning check box");
		heatondemandpage.HODwarningCheckBox.click();
		
		testStepsLog("Click on the Accept button");
		clickOn(heatondemandpage.warningModalAcceptButton);
		
		testStepsLog("Verify there are some locked videos");
		visibilityOfElement(heatondemandpage.Videoslockicon);
		testVerifyLog("There are some locked videos");
		
		testStepsLog(" Click on a locked video");
		heatondemandpage.clickOnHODvideoSubCategory(heatondemandpage.getFirstHODvideoSubCategoryName());
		
		testStepsLog("Click on videos tab");
		clickOn(heatondemandpage.videosTab);
		
		testStepsLog("Click on a video");
		heatondemandpage.clickOnHODvideo(heatondemandpage.getFirstHODVideoName());
		
		testStepsLog("Verify user don't have subscription text showing");
		visibilityOfElement(heatondemandpage.noSubscriptionText);
		testVerifyLog("user don't have subscription text showing");
		
		testStepsLog("Click on the Subscribe Now button");
		clickOn(heatondemandpage.SubscribeNowButton);
		
		testStepsLog("Verify it redirects to the plans page");
		visibilityOfElement(heatondemandpage.selectYourPlanText);
		testVerifyLog("It redirects to the plans page");
		
		testStepsLog(" Verify Subscriptions plans are showing");
		visibilityOfElement(heatondemandpage.SubscriptionPlansDiv);
		testVerifyLog("Subscriptions plans are showing");
		
		testStepsLog(" Click on Subscribe Now button of a plan");
		clickOn(heatondemandpage.plansSubscribeNowButton);
		
		testStepsLog(" Verify page redirects to the checkout page");
		Assert.assertEquals("https://dev.heatxtreme.com/checkout", driver.getCurrentUrl());
		testVerifyLog("Page redirects to the checkout page");
		driver.switchTo().frame(heatondemandpage.creditCardIframe);
		
		testStepsLog("Enter credit card number");
		enterValue(heatondemandpage.checkout_CardNumberField,"4242424242424242");
		
		testStepsLog("Enter credit card Exp date");
		enterValue(heatondemandpage.checkout_ExpDateField,"0930");
		
		testStepsLog("Enter credit card cvc number");
		enterValue(heatondemandpage.checkout_cvcfieldField,"123");
		
		testStepsLog("Enter credit card zip number");
		enterValue(heatondemandpage.checkout_zipField,"45656");
		
		testStepsLog("Click on Pay button");
		driver.switchTo().defaultContent();
		scrollToElement(heatondemandpage.checkout_payButton);
		clickOn(heatondemandpage.checkout_payButton);
		
		testStepsLog("Verify subscription successfull");
		String notificationMessage = commonpage.getNotificationMessage();
		
		driver.navigate().refresh();
		waitForPageLoaded();
		
		testStepsLog("validate the notification message");
		Assert.assertEquals("Subscription successful",notificationMessage );
		
		testStepsLog("Click on Heat On Demand");
		heatondemandpage.ClickOnLeftMenu("Heat On Demand");
		
		testStepsLog("Verify there are no locked videos");
		try {
		visibilityOfElement(heatondemandpage.Videoslockicon);
		Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("Verify there are no locked videos");
					
		}
		
		
				
		
		
		
		
		
	
	
	
	
}
	}
