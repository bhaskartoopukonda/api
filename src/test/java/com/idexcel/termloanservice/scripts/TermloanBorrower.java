package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.TestNGDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class TermloanBorrower extends AbstractRestAssuredResponse{



	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;


	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 

    @Feature("Termloan Boerrower")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(groups="Regression")
	public void termloanBorrower() throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{
Response getBAseratecode=callGETMethod(token, url3+"/api/v1/term-loan/borrower/canClientBePurged/11335");
softassert.assertEquals(getBAseratecode.statusCode(), STATUS_CODE_200,"this is to verfiy status code of base Interest rate API");
		System.out.println("getBAseratecode"+getBAseratecode.asString());
		
}

}
		
		
	//TERMLN_469(Floating interest rate delete)	
		
		
		@Feature("Termloan Boerrower")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		//@Test(groups="Regression")
		public void floatinngInterestratedelete() throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			{
	Response getBAseratecode=callGETMethod(token, url3+"/api/v1/term-loans/interest-rate-code?ids=294");
	softassert.assertEquals(getBAseratecode.statusCode(), STATUS_CODE_200,"this is to verfiy status code of floating Interest rate API");
			System.out.println("getBAseratecode"+getBAseratecode.asString());
			
	}
		}
		
		
		
		
		@Feature("Termloan Boerrower")
		@Stories(value = { @Story(value = "termaloan status code validation")})
		@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
		@Step("verifies chargecode module")
		@Severity(SeverityLevel.BLOCKER)
		//@Test(groups="Regression")
		public void floatingInterestratedelete() throws FileNotFoundException, IOException, ParseException {
			
			SoftAssert softassert = new SoftAssert();
			{
	Response getBAseratecode=callGETMethod(token, url3+"/api/v1/term-loans/interest-rate-code?ids=400");
	softassert.assertEquals(getBAseratecode.statusCode(), STATUS_CODE_200,"this is to verfiy status code of Floating Interest rate API");
			System.out.println("getBAseratecode"+getBAseratecode.asString());
			
	}
		}
		
		
		
		
		
		
		
		
		
		
		
	



    @Feature("GracePeriosd")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(groups="Regression")
	public void termloanBorrowerDelete() throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{
Response getBAseratecode=callDELETEMethod(token, url3+"/api/v1/term-loan/borrower/11335");
softassert.assertEquals(getBAseratecode.statusCode(), STATUS_CODE_204,"this is to verfiy status code of base Interest rate API");
		System.out.println("getBAseratecode"+getBAseratecode.asString());
		
}}
    @Feature("GracePeriosd")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
    public void createBorrowerandLoan(String client_name,String short_name,String client_number,String bbc_frequency_date,String manager_ids,String sales_region_id,String client_template_id) {
    	
    	try {
			
    		Response rspn = callPOSTMethod(token,payloads.createBorrower(client_name, short_name, client_number, bbc_frequency_date, manager_ids, sales_region_id, client_template_id),url+"/api/v1/borrowers");
    	    System.out.println(rspn.getBody().asString());
    	    
    	    Response rspn1 = callGETMethod(token,"manager_id","","borrower_status","1",url+"/auth/get_borrowers_on_client_status");
    	    int length=rspn1.body().path("list.size()");
    	    System.out.println("length is "+length);
    	    
    	    System.out.println(rspn1.getBody().asString());
    	   // if(client_name.equalsIgnoreCase(rspn1.jsonPath().getList("")));
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    @Feature("GracePeriosd")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: creation of charge code with positive and negative scenarios")
	@Step("verifies chargecode module")
	@Severity(SeverityLevel.BLOCKER)
    //@Test(groups= {"sanity","smoke","Regression"})
    public void updateAddress() {
    	Response rspn = callPOSTMethodforBrowwer(token,url+"/borrowers/11622/mail_addresses/391");
    	System.out.println(rspn.getStatusCode());
    	//http://internal-Staging-Microservices-ALB-2067542200.us-east-1.elb.amazonaws.com:8085/term-loan-job/floating-interest?lenderName={staging}&userName=Mahesh%20Bharti
    }
 
}
