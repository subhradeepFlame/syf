package testcases.loginTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCLI003 extends BaseClass{

	
	@Test
	public void loginWithIncorrectPassword() {
		
		testInfoLog("Login with incorrect password");
		loginpage.Login("autouserqa1@mailinator.com", "12345sdsdsd6");
		
	}
}
