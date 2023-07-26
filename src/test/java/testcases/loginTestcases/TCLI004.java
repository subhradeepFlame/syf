package testcases.loginTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCLI004 extends BaseClass{

	
	@Test
	public void loginWithInvalidEmail() {
		
		testInfoLog("Login with invalid email format");
		loginpage.Login("automationcha", con.getLoginPassword());
		
	}
}
