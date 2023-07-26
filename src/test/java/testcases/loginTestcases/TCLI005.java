package testcases.loginTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCLI005 extends BaseClass{

	
	@Test
	public void validLogin() {
		
		testInfoLog("Login with correct credentials");
		loginpage.Login("autouserqa1@mailinator.com", con.getLoginPassword());
	}
}
