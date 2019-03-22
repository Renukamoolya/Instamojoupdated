package tests.pages;

import java.util.Map;

import org.openqa.selenium.Keys;

import agent.IAgent;
import central.Configuration;

public class ApiandPlugins extends FullPage {
	public ApiandPlugins(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Test scripts for api and plugins
	 * 
	 */

	public void getResponse() throws Exception {
		

		getControl("Apiandplugin").waitUntilVisible();
		getControl("Apiandplugin").click();
		getControl("newcredentials").waitUntilClickable();
		getControl("newcredentials").click();

		getControl("chooseFramework").waitUntilClickable();
		getControl("chooseFramework").click();
		getControl("chooseFramework").enterText(Keys.DOWN);
		getControl("chooseFramework").enterText(Keys.ENTER);
		getControl("generateCredentials").click();

		getControl("webhookTestingTool").click();
		Thread.sleep(1000);
		//getControl("chooseLink").waitUntilClickable();
		getControl("chooseLink").click();
		Thread.sleep(1000);
		getControl("chooseLink").enterText(Keys.DOWN);
		getControl("chooseLink").enterText(Keys.ENTER);

		getControl("serverUrl").enterText(getTestData().get("serverUrl"));
		getControl("sendwebhook").click();
		Thread.sleep(1000);
		takeSnapShot();
		
		

	}

}
