package tests.pages;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import agent.IAgent;
import agent.internal.WebAgent;
import central.Configuration;

public class HomePage extends FullPage {
	public HomePage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		assertPageLoad();
	}

	public CreatePayment clickOnpaymentLink() throws Exception {

		getControl("clickOnPaymentLink").click();

		return new CreatePayment(this.getConfig(), this.getAgent(), this.getTestData());
	}
	public CreatePayment clickOnProductButton() throws Exception {

		getControl("clickOnAddProductBtn").click();

		return new CreatePayment(this.getConfig(), this.getAgent(), this.getTestData());
	}
	public HomePage Logout() throws Exception {
		takeSnapShot();
	    getControl("clickLogOutDropDown").click();
	    getControl("logout").waitUntilVisible();
	    takeSnapShot();
		getControl("logout").click();
		takeSnapShot();
		getControl("WaitForLogInText").waitUntilVisible();
	    return new HomePage(this.getConfig(), this.getAgent(), this.getTestData());
		
		
	}
	public void helpAndSupport() throws Exception
	{	getControl("helpSuportLink").waitUntilClickable();
		getControl("helpSuportLink").click();
		getControl("submitRequest").click();
		Thread.sleep(2000);
		//String winHandleBefore = driver.getWindowHandle();
		switchToNewWindow();
		getControl("emailAddress").enterText(getTestData().get("emailAddress"));
		getControl("subject").enterText(getTestData().get("subject"));
		getControl("description").enterText(getTestData().get("description"));
		getControl("ticketTypeDropDown").click();
		getControl("ticketTypeDropDown").enterText(Keys.DOWN);
		getControl("ticketTypeDropDown").enterText(Keys.ENTER);
		getControl("submitButton").click();
		
		
	}
	public void findResources() throws Exception
	{
		getControl("helpSuportLink").waitUntilClickable();
		getControl("helpSuportLink").click();
		getControl("findresources").click();
		switchToNewWindow();
		getControl("pricing").click();
		getControl("Rate/FeeCalculator").click();
		getControl("InstamojoFeeCalculator").click();
		getControl("paymentAmmountTextBox").enterText(getTestData().get("paymentAmmountTextBox"));
		getControl("CalculateFees").click();
	}
	
}
