package tests.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import agent.IAgent;
import central.Configuration;

public class Login extends FullPage {

	public Login(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		
	}
	/** 
	 * This script id for login Instamojo website
	 * 
	 */
    public HomePage login() throws Exception{
    	

		getControl("loginTab").click();
		getControl("uName").enterText(getTestData().get("UserName"));
		getControl("pswrd").enterText(getTestData().get("Password"));
		takeSnapShot();
		getControl("loginBtn").click();
		takeSnapShot();
		//getControl("waitForText").waitUntilVisible();
		return new HomePage(this.getConfig(),this.getAgent(),this.getTestData());

	

    }
}


