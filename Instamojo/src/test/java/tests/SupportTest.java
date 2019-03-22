package tests;

import java.lang.reflect.Method;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.appachhi.Logger.*;
import agent.AgentFactory;
import agent.IAgent;
import central.Configuration;
import central.AppachhiCentral;
import tests.pages.ApiandPlugins;
import tests.pages.Appstore;
import tests.pages.CreatePayment;
import tests.pages.HomePage;
import tests.pages.Login;

public class SupportTest {
	protected static Logger logger = AppachhiCentral.getLogger();
	private Configuration conf = null;
	//protected LoginPage login;
	
	protected Login lp;
	protected HomePage hp;
	protected ApiandPlugins ap;
	protected CreatePayment cp;
	private IAgent agent;
	protected Appstore aps;
	private ITestContext context = null;
	private String testName = null;
    
	@BeforeSuite(alwaysRun = true)
	public void runOncePerSuite() throws Exception {
		AppachhiCentral.INSTANCE.init();
		logger = AppachhiCentral.getLogger();
		logger.info("Central setup completed.");
	}

	@BeforeTest(alwaysRun = true)
	public void runOncePerContext(ITestContext context) throws Exception {
		logger.info(String.format("Test context setup started for %s test.", context.getName()));
		AppachhiCentral.INSTANCE.registerContext(context);
		logger.info(String.format("Test context setup completed for %s test.", context.getName()));
	}

	@BeforeClass(alwaysRun = true)
	public void runOncePerClass(ITestContext context) throws Exception {
		this.context = context;
		this.conf = AppachhiCentral.INSTANCE.getContextConfig(context);
	}

	@BeforeMethod(alwaysRun = true)
	public void runOncePerMethod(ITestContext context, Method method) throws Exception {
		testName = method.getName();
		logger.info(String.format("Set up for test method [%s] started.", testName));
		logger.debug(String.format("Creating agent for %s", this.conf.getPlatform()));
		agent = AgentFactory.createAgent(this.conf);
		logger.debug(String.format("Test Method Name Started :: %s", testName));
		Map<String, String> testData = AppachhiCentral.INSTANCE.getTestData(context, testName);
       
	    lp= new Login(this.conf, agent, testData);
		logger.info(String.format("Set up for test method [%s] ended.", testName));
		ap=new ApiandPlugins(this.conf, agent, testData);
		cp=new CreatePayment(this.conf, agent, testData);
		aps=new Appstore(this.conf, agent, testData);
		hp=new HomePage(this.conf, agent, testData);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
		logger.info(String.format("Tear down for test method [%s] started.", testName));
		if (ITestResult.FAILURE == result.getStatus()) {
			agent.takeSnapShot();
		}
		try {
			com.appachhi.Logger.Logger.appachhiLogger(this.agent.getWebDriver());
		}catch(Exception e) {
			
		}
		agent.quit();
		logger.info(String.format("Tear down for test method [%s] ended.", testName));
	}

	protected String getTestInfoMessage(String stage, String method) {
		return String.format("Test method [%s] %sed.", method, stage);
	}

	protected String getTestStartInfoMessage(String method) {
		return getTestInfoMessage("start", method);
	}

	protected String getTestEndInfoMessage(String method) {
		return getTestInfoMessage("end", method);
	}
}
