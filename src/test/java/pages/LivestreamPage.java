package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LivestreamPage extends CommonPage{

	public LivestreamPage(WebDriver dr) {
		super(dr);
	}
	
	@FindBy(xpath = "//h6[text()='Program Details']")
	public WebElement programDetailsText;

	
	
}
