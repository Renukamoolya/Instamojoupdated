package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Scenarios extends SupportTest {

	/**
	 * Test scenario to create payment link
	 **/

	@Test(enabled = true, priority = 1)
	public void createPayment() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Scenarios:login -> Start"));
		lp.login().clickOnpaymentLink().createPaymentLink().Logout();
		logger.debug(this.getTestEndInfoMessage("Scenarios:login -> End "));

	}

	/**
	 * Test scenario to add product
	 **/
	@Test(enabled = true, priority = 2)
	public void addProduct() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Scenarios:addProduct -> Start"));
		lp.login().clickOnProductButton().createAddtoProduct().TestStorePage();
		logger.debug(this.getTestEndInfoMessage("Scenarios:addProduct ->End"));

	}

	/**
	 * Test scenario Create a payment link by using smart link
	 **/
	@Test(enabled = true, priority = 3)
	public void smartLink() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Scenarios:smartLink -> Start"));
		lp.login().clickOnpaymentLink().createSmartLink().Logout();
		logger.debug(this.getTestEndInfoMessage("Scenarios:smartLink ->End"));

	}

	/**
	 * Test scenario to submit request
	 **/
	@Test(enabled = true, priority = 4)
	public void submitRequest() throws Exception {

		logger.debug(this.getTestStartInfoMessage("Scenarios :submitRequest -> Start"));
		lp.login().helpAndSupport();
		logger.debug(this.getTestEndInfoMessage("Scenarios:submitRequest -> End"));

	}

	/**
	 * Test scenario is for api and plugins
	 **/
	@Test(enabled = true, priority = 5)
	public void apiPlugins() throws Exception {

		logger.debug(this.getTestStartInfoMessage("Scenarios:apiPlugins -> start"));
		//
		lp.login();
		ap.getResponse();
		hp.Logout();
		logger.debug(this.getTestEndInfoMessage("Scenarios:apiPlugins -> End"));

	}

	/**
	 * Test scenario to edit payment
	 **/

	@Test(enabled = true, priority = 6)
	public void editPaymentLink() throws Exception {

		logger.debug(this.getTestStartInfoMessage("Scenarios:editPaymentLink -> Start"));
		lp.login();
		cp.editPayement();
		hp.Logout();
		logger.debug(this.getTestEndInfoMessage("Scenarios:editPaymentLink-> End"));

	}

	/**
	 * Test scenario to calculate shipping cost
	 **/

	@Test(enabled = true, priority = 7)
	public void appStore() throws Exception {

		logger.debug(this.getTestStartInfoMessage("Scenarios: appStore -> Start"));
		lp.login();
		aps.requestPayment();
		logger.debug(this.getTestEndInfoMessage("Scenarios: appStore-> End"));

	}

	/**
	 * Test scenario to find resources
	 **/

	@Test(enabled = true, priority = 8)
	public void findResources() throws Exception {

		logger.debug(this.getTestStartInfoMessage("Scenarios:findResources->start"));
		lp.login().findResources();
		logger.debug(this.getTestEndInfoMessage("Scenarios:findResources -> End"));

	}

}
