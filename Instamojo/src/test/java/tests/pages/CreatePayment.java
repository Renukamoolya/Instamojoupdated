package tests.pages;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import agent.IAgent;
import central.Configuration;

public class CreatePayment extends FullPage {
	public CreatePayment(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		// assertPageLoad();
	}

	/**
	 * This script is for create payment
	 * 
	 */
	public HomePage createPaymentLink() throws Exception {
		

		getControl("purposeOfPayment").enterText(getTestData().get("EnterPayment"));
		getControl("enterAmount").enterText(getTestData().get("Amount"));
		getControl("clickOnCreateBtn").click();
		getControl("textLinkReady").waitUntilVisible();
		getControl("goBackToDashboardpage").click();
		getControl("clickOnPaymentlinkTab").waitUntilVisible();
		getControl("clickOnPaymentlinkTab").click();
		scrollDown(3);
		getControl("liveLinkbtn").waitUntilVisible();
		Assert.assertTrue(getControl("verifyListBox").isVisible(), "PaymentLink is created");
		
		return new HomePage(this.getConfig(), this.getAgent(), this.getTestData());
	}
	
	/**
	 * This script is for add product
	 * 
	 */
	public TestStore createAddtoProduct() throws Exception {
		getControl("waitAddproductText").waitUntilVisible();
		Thread.sleep(2000);
		getControl("addProductTitle").enterText(getTestData().get("AddProductTitle"));
		getControl("addProductDescription").enterText(getTestData().get("ProductDescription"));
		scrollDown(3);
		getControl("waitForTextPrice").waitUntilVisible();
		getControl("addPrice").enterText(getTestData().get("Price"));
		getControl("addShipWithin").enterText(getTestData().get("ShipWithin"));
		getControl("clickOnAddProductBtn").click();
		Thread.sleep(1000);
		takeSnapShot();
		return new TestStore(this.getConfig(), this.getAgent(), this.getTestData());

	}

	/**
	 * 
	 * this script is for create payment using smart link
	 */
	public HomePage createSmartLink() throws Exception {
		getControl("SmartLink").click();
		getControl("enterAmount").waitUntilClickable();
		getControl("enterAmount").enterText(getTestData().get("Amount"));
		getControl("PaymentInvoice").enterText(getTestData().get("PaymentInvoice"));

		getControl("submit").click();
		getControl("done").click();
		Thread.sleep(1000);
		takeSnapShot();
		return new HomePage(this.getConfig(), this.getAgent(), this.getTestData());

	}

	/**
	 * 
	 * this script is for editing payment by using exsiting one
	 * 
	 */
	public HomePage editPayement() throws Exception {
		getControl("paymentLink").waitUntilClickable();
		getControl("paymentLink").click();
		getControl("pymentList").click();

		getControl("dropDownButton").click();
		getControl("edit").click();
		getControl("SmartLink").click();
		Thread.sleep(1500);
		getControl("enterAmount").enterText(Keys.CONTROL + "a");
		getControl("enterAmount").enterText(Keys.DELETE);
		
		getControl("enterAmount").enterText(getTestData().get("Amount"));
		Thread.sleep(1500);
		getControl("PaymentInvoice").enterText(getTestData().get("PaymentInvoice"));
		getControl("Setlink").click();
		getControl("Setlink").click();
		getControl("Setlink").click();
		Thread.sleep(3000);
		getControl("limitPayment").waitUntilClickable();
		getControl("limitPayment").click();
		getControl("Setlink").click();
		getControl("next").click();
		getControl("done").click();
		Thread.sleep(1000);
		takeSnapShot();

		return new HomePage(this.getConfig(), this.getAgent(), this.getTestData());

	}

}
