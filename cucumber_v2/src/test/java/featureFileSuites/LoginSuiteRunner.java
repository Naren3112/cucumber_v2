package featureFileSuites;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(   
features="src//test//resources//features//login.feature",
glue="stepdefinitions",
format={"pretty", "html:target/cucumber"}
)

public class LoginSuiteRunner 
{
	TestNGCucumberRunner tcr;
	
		@BeforeClass(alwaysRun=true)
	    public void beforeClass() throws Exception
		{
	        tcr = new TestNGCucumberRunner(this.getClass());
	    }
		
		@DataProvider
		public Object[][] features()
		{
	        return tcr.provideFeatures();
		}

	    @AfterClass (alwaysRun=true)
	    public void afterClass()
	    {
	        tcr.finish();
	    }
	    
	    @Test(dataProvider="features")
	    public void feature(CucumberFeatureWrapper cucumberFeature){
	        tcr.runCucumber(cucumberFeature.getCucumberFeature());
	    }

}
