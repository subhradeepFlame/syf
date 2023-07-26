package testcases.loginTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCLI002 extends BaseClass{

	
	@Test
	public void loginWithIncorrectEmail() {
		
		testInfoLog("Login with incorrect email id");
		loginpage.Login("s89sdsdsiyxizci9@gmail.com", con.getLoginPassword());
		
	}
}
