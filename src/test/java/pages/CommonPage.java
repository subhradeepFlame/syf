package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import initiate.BaseClass;

public class CommonPage extends BaseClass {

	public CommonPage(WebDriver dr) {
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}

	String incrementorExcelPath = System.getProperty("user.dir") + "/src/test/resources/incrementorValue.xls";

	@FindBy(xpath = "//div[@class='con-text-noti']//p")
	public WebElement notification;
	@FindBy(xpath = "//button//div[@class='con-img']//img[contains(@class,'rounded-full')]/../..")
	public WebElement profileIcon;
	@FindBy(xpath = "//img[contains(@class,'rounded-full')]/../../..//p[@class='font-semibold']")
	public WebElement loggedinUserName;
	@FindBy(xpath = "//button[@class='plyr__control plyr__control--overlaid']")
	public WebElement videoPlayButton;
	@FindBy(xpath = "//span[text()='Dashboard']")
	public WebElement dashboardMenuText;
	@FindBy(xpath = "//button//span[text()='Accept']/..")
	public WebElement confirmAcceptButton;

	public void goToUrl(String url) {
		/* open a url */

		driver.get(url);
		waitForPageLoaded();
	}

	/*
	 * opens mailiantor.com and verify the mail is received
	 */
	public void VerifyMailinatorMail(String userName, String mailSubject) {
		/* helps to verify that mail is present in the mailinator inbox */
		testStepsLog("Open malinator");
		goToUrl("https://www.mailinator.com/v4/public/inboxes.jsp?to=" + userName + "");
		waitForPageLoaded();
		PresenceOfElement(
				By.xpath("//td[contains(text(),'Heatxtreme')]/..//td[contains(text(),'" + mailSubject + "')]"));
		testVerifyLog("Mailinator mail received");
	}

	/*
	 * opens received mail in mailinator
	 */
	public void openMailinatorMail(String mailSubject) {
		/* helps to click on a mail present in the mailinator */
		PresenceOfElement(
				By.xpath("//td[contains(text(),'Heatxtreme')]/..//td[contains(text(),'" + mailSubject + "')]"));
		clickOn(driver.findElement(
				By.xpath("//td[contains(text(),'Heatxtreme')]/..//td[contains(text(),'" + mailSubject + "')]")));
	}

	public String getNotificationMessage() {
		/* helps to get the notification messages */
		return visibilityOfElement(notification).getText();
	}

	public void ClickOnProfileMenu(String ProfileMenuOption) {
		/* helps to click on the profile menu of user and admin panel */
		testStepsLog("Click on profile icon");
		clickOn(profileIcon);
		testStepsLog("Click on : " + ProfileMenuOption);
		clickOn(driver.findElement(By
				.xpath("//div[contains(@class,'vs-dropdown--custom')]//span[text()='" + ProfileMenuOption + "']/..")));
	}

	public void ClickOnLeftMenu(String leftMenuOption) {
		/* helps to click on the left menu of user and admin panel */
		clickableElement(driver
				.findElement(By.xpath("//div[@class='vs-sidebar--items']//span[text()='" + leftMenuOption + "']")));
		clickOn(driver
				.findElement(By.xpath("//div[@class='vs-sidebar--items']//span[text()='" + leftMenuOption + "']")));
		waitForPageLoaded();
	}

	public boolean VerifyVideoIsPlaying() {
		/* returns true if the video is plaing */
		pause(5);                                   // pause used cause video needs some time to play
		float value = Float.parseFloat(
				driver.findElement(By.xpath("//div[@class='plyr__progress']//input")).getAttribute("aria-valuenow"));
		if (value > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String getloggedinUserName() {
		/* helps to get the logged in user name */
		return loggedinUserName.getText();

	}

	public String getIncrementedValue()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		/* get the excel incrementor value */

		String incrementorValue = excelhelper.getIntegerCellvalue(incrementorExcelPath, "AuthenticationSheet", 1, 0);
		excelhelper.setCellValue(incrementorExcelPath, "AuthenticationSheet", 1, 0, Integer.parseInt(incrementorValue) + 1);
		String upgradedincrementorValue = excelhelper.getIntegerCellvalue(incrementorExcelPath, "AuthenticationSheet", 1, 0);
		return upgradedincrementorValue;
	}
	
	public String getCurrentMonth() {
		/* helps t get the current month name */
		 SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
	      simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
	      simpleformat = new SimpleDateFormat("MMMM");
	      String strMonth= simpleformat.format(new Date());
	      return strMonth;
	}
	
	public String getCurrentYear() { 
		/* helps t get the current year */
	      SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
	      simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
	      String str[] = simpleformat.format(new Date()).split("/");
	      return str[2];
	      
	}
	
	public String getCurrentDate() { 
		/* helps to get the current date */
		  SimpleDateFormat formatter = new SimpleDateFormat("dd");  
		    Date date = new Date();    
	      return formatter.format(date);
	}
	
	public String getNextDate() { 
		/* helps to get the current date */
		  SimpleDateFormat formatter = new SimpleDateFormat("dd");  
		    Date date = new Date();    
		    final Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.add(Calendar.DAY_OF_YEAR, 1);
	      return formatter.format(calendar.getTime());
	}
	
	public String getCurrentDateMonthYear() {
		/* helps to get current date in dd mmm, yyyy format */
		 SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
	      simpleformat = new SimpleDateFormat("MMM");
	      String strMonth= simpleformat.format(new Date());
	     return getCurrentDate()+" "+ strMonth+", "+getCurrentYear();
	}
	
	public String getNextDateMonthYear() {
		/* helps to get tommorow date in dd mmm, yyyy format */
		 SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
	      simpleformat = new SimpleDateFormat("MMM");
	      String strMonth= simpleformat.format(new Date());
	     return getNextDate()+" "+ strMonth+", "+getCurrentYear();
	}
	
	public void SelectUsingVisibleValue(WebElement element,String visibleValue) {
		/* helps to select dropdownvalues with select and option tagnames */
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
	}
	
	public String getRandomString(int length) {
		/* returns a random string with given length value */
		String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
		String s = RandomStringUtils.random(length, alphabet);
		return s;
	}
	
	

}
