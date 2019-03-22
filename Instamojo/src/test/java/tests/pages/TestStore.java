package tests.pages;

import java.util.Map;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;

public class TestStore extends FullPage {
	
		public TestStore(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
			super(conf, agent, testData);
			assertPageLoad();
		}
		public HomePage TestStorePage() throws Exception{
			
			//Assert.assertTrue(getControl("VerifyBuyNowBtn").isVisible(),"Product is Added");
		//("NavigateToDashboardPage").click();
			 return new HomePage(this.getConfig(), this.getAgent(), this.getTestData());

		}
		
		
}

