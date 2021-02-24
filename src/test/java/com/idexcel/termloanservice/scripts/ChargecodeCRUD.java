package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.token.Token;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.Payloads;
import com.idexcel.utilities.TestNGDataProvider;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;

import io.restassured.response.Response;

public class ChargecodeCRUD extends AbstractRestAssuredResponse{
	
	
		private static final int STATUS_CODE_200 =200;
		private static final int STATUS_CODE_400 =400;
		private static final int STATUS_CODE_201 =201;
		private static final int STATUS_CODE_204 =204;
		private static final int STATUS_CODE_404 =404;
		private static final int STATUS_CODE_403 =403;
		static String chargeTypeid =null;
		static String chargeType_value=null;
		static String chargeType_displayName=null;
		static String chargeType_calculationType=null;
		
		DataFromPropertyFile data = new DataFromPropertyFile();
		JSONFileReader json = new JSONFileReader();
	
		
		@Feature("Charge Code")
		@Stories(value = { @Story(value = "Verify the List of all the charge codes") })
		@Description("This is a test case is to verfiy List of all the charge codes")
		@Step("Verify the List of all the charge codes")
		@Severity(SeverityLevel.MINOR)
		@Test(groups="smoke")
        public void listAllTheChargeCodes() {
			SoftAssert softassert = new SoftAssert();
			try {
				Response response = callGETMethod(token,data.getChargetypesAPI());
				System.out.println("Response body "  +response.getBody().asString());
				int code = response.getStatusCode();
				System.out.println("My status code is  "    +code);
				softassert.assertEquals(STATUS_CODE_200, code);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			softassert.assertAll();
		}
	
//CHARGE CODE POSITIVE SCENARIO
		
		@Feature("Charge Code")
	    @Stories(value = { @Story(value = "CHARGE CODE WITH POSITIVE DETAILS") })
	    @Description("This is a test case is to Verify the creation of Chargecode with Nat sign positive")
	    @Step("verifies Charge code With Positive details")
	    @Severity(SeverityLevel.BLOCKER)
	    @Test (groups= {"sanity", "smoke","regression" })
	    public void creationOfChargeCodeWithPositiveDetails()throws FileNotFoundException, IOException, ParseException, ProcessingException {
         {
	     
        	 String chargeTypeid =null;
			SoftAssert softassert = new SoftAssert();
            try {
            	
            	Response listChargeTypes=callGETMethod(token,url3+"/api/v1/charge-codes/charge-types");	
            	int length=listChargeTypes.body().path("list.size()");
            	for(int i=0;i<length;i++) {
            		chargeTypeid = listChargeTypes.jsonPath().getList("id").get(i).toString();
                	chargeType_value=listChargeTypes.jsonPath().getList("value").get(i).toString();
                	chargeType_displayName=listChargeTypes.jsonPath().getList("displayName").get(i).toString();
                	chargeType_calculationType=listChargeTypes.jsonPath().getList("calculationType").get(i).toString();
                	System.out.println(chargeTypeid);
                	System.out.println(chargeType_value);
                	System.out.println(chargeType_displayName);
                	System.out.println(chargeType_calculationType);
            	}
            	
                
            	
    	     
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	    
		
		
		softassert.assertAll();
		
		
	}
 }
		
	
//CHARGE CODE CREATIONS WITH NEGATIVE SCENARIO
	
		@Feature("Charge code")
		@Stories(value = { @Story(value = "Charge Code Creating By Verifying Charge Code Field With Negative Data") })
		@Description("This is a test case which verifies the status code: Creation Of Charge Code Field With Negative Scenarios")
		@Step("Verifying Charge Code By Verifying Charge Code Field With Negative Details ")
		@Severity(SeverityLevel.BLOCKER)
		@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
		public void chargeCodeWithNegativeDetails(String chargeCode,String Statuscode) throws FileNotFoundException, IOException, ParseException {
			SoftAssert softassert = new SoftAssert();
			Response chargecodes=callPOSTMethod(token, payloads.getChargecodeRequestBodyForNEgativeScenario(chargeCode), data.getchargecodeURI());
			System.out.println("chargecodes"+chargecodes.asString());
		
//			verifyingStatuscodes(chargecodes.statusCode(), Integer.valueOf(Status).intValue(),"This is to verfiy the stastus code of charge code Nergative scenario");
			softassert.assertEquals(chargecodes.statusCode(), Integer.valueOf(Statuscode).intValue(),"This is to verfiy the status code of charge code Negative scenario");
			softassert.assertAll();
		
		}	
		
		
	
	

@Feature("Charge code")
@Stories(value = { @Story(value = "Charge Code Creating By Verifying charge type Field With  Positive and Negative Data") })
@Description("Verify the creation of charge code with Nat sign negative and autonewclient(true/false) as well as invalid transaction code and inalid percentage")
@Step("verifies Charge code By Verifying Charge type field with Positive and  Negative data")
@Severity(SeverityLevel.NORMAL)
@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
public void transactionFieldNegative(String chargeType,String Status,String percentage,String Autonewclient) throws FileNotFoundException, IOException, ParseException {
	SoftAssert softassert = new SoftAssert();
	Response chargecodes=callPOSTMethod(token, payloads.getChargeType(chargeType,percentage ,Autonewclient), data.getchargecodeURI());
	System.out.println("chargecodes"+chargecodes.asString());
	
//	verifyingStatuscodes(chargecodes.statusCode(), Integer.valueOf(Status).intValue(),"This is to verfiy the stastus code of charge code Nergative scenario");
	softassert.assertEquals(chargecodes.statusCode(), Integer.valueOf(Status).intValue(),"This is to verfiy the stastus code of Transaction field with negative details");
	softassert.assertAll();


}

//


@Feature("Charge Code")
@Stories(value = { @Story(value = "termaloan status code validation") })
@Description("Verify the charge code creation by verifying  charge type field with positive and negative data On Original Loan Amount/On Outstanding Principal/On Total Payment Due/On Balance Due/Value")
@Step("verifies Charge code By Verifying Transaction field with Negative data")
@Severity(SeverityLevel.BLOCKER)
@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
public void chargeTypeValidation(String chargeType,String percentage,String Status,String Autonewclient) throws FileNotFoundException, IOException, ParseException {
	SoftAssert softassert = new SoftAssert();
	try {
	Response chargecodes=callPOSTMethod(token, payloads.getChargeType(chargeType,percentage,Autonewclient), data.getchargecodeURI());
	System.out.println("chargecodes"+chargecodes.asString());
	

	softassert.assertEquals(chargecodes.statusCode(), Integer.valueOf(Status).intValue(),"This is to verfiy the stastus code of Transaction field with negative details");
	}

catch(NullPointerException e) 
{ 
}
	softassert.assertAll();


}


@Feature("Charge Code")
@Stories(value = { @Story(value = "termaloan status code validation") })
@Description("This is a Test Case Which Verifies The Status Code: Creation of of Transaction Field with Negative data")
@Step("verifies Charge code By Verifying Transaction field with Negative data")
@Severity(SeverityLevel.BLOCKER)
@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups="Regression")
public void chargeTypeValidationForNegative(String chargeType,String percentage,String Status,String Autonewclient) throws FileNotFoundException, IOException, ParseException {
	SoftAssert softassert = new SoftAssert();
	try {
	Response chargecodes=callPOSTMethod(token, payloads.getChargeType(chargeType,percentage,Autonewclient), data.getchargecodeURI());
	System.out.println("chargecodes"+chargecodes.asString());
	

	softassert.assertEquals(chargecodes.statusCode(), Integer.valueOf(Status).intValue(),"This is to verfiy the stastus code of Transaction field with negative details");
	}

catch(NullPointerException e) 
{ 
}
	softassert.assertAll();


}


	
	
}