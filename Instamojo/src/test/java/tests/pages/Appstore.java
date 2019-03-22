package tests.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import agent.IAgent;
import central.Configuration;

public class Appstore extends FullPage {

	public Appstore(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
		// TODO Auto-generated constructor stub
	}
	/**
	 * This script is for request payment in instamojo
	 * 
	 */

	public void requestPayment() throws Exception {
		
		getControl("appStore").waitUntilClickable();
		getControl("appStore").click();
		getControl("requestPayment").click();

		if (getControls("sendRequest").size() == 0) {

			getControl("email").enterText(getTestData().get("email"));
			getControl("ammount").enterText(getTestData().get("ammount"));
			getControl("paymentPurpose").enterText(getTestData().get("paymentPurpose"));
			getControl("sendnow").click();
		} 
		else {
			getControl("sendRequest").click();
			getControl("email").enterText(getTestData().get("email"));
			getControl("ammount").enterText(getTestData().get("ammount"));
			getControl("paymentPurpose").enterText(getTestData().get("paymentPurpose"));
			getControl("sendnow").click();
			Thread.sleep(1000);
			takeSnapShot();
		}
		
	}

}
