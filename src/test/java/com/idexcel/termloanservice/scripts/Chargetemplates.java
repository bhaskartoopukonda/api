package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.Payloads;
import com.idexcel.utilities.TestNGDataProvider;
import com.idexcel.utilities.Utils;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class Chargetemplates   extends AbstractRestAssuredResponse{


	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	
	//private static final String  termloanIDforPUT ="3aa71b43-12ce-475c-9300-390f791a3f30";

	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader();





	//Charge Template CRUD Operation-Post

	@Feature("TERM LOAN CHARGE TEMPLATE")
	@Stories(value = { @Story(value = "Term laon Charge template CRUD Operation") })
	@Description("This is a test case Term loan Charge template CRUD Operation")
	@Step("verifies chaarge template CRUD operation")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void chargeTemplateCRUD(String termLoan,String chargecodeId)throws FileNotFoundException, IOException, ParseException, ProcessingException, InterruptedException {
		
		SoftAssert softassert = new SoftAssert();

			
			
			//Charge template-Post
			Response chargetemplateBody	=callPOSTMethod(token, payloads.getPayloadforChargeTemplatePost(termLoan), url3+"/api/v1/charges-template/"+termLoan+"");
			System.out.println("chargetemplateBody"+chargetemplateBody.asString());
			
			softassert.assertEquals(chargetemplateBody.statusCode(), STATUS_CODE_201, "this is the status code for chargetemplateBody");
			//charge template -Put
			Response ChargeTemplateUpdate=callPUTMethod(token, payloads.getPayloadforChargeTemplatePut(termLoan),url3+"/api/v1/charges-template/"+termLoan);
			System.out.println("ChargeTemplateUpdate"+ChargeTemplateUpdate.asString());		
			softassert.assertEquals(ChargeTemplateUpdate.statusCode(), STATUS_CODE_400, "this is the status code for ChargeTemplateUpdate");
          //Charge template Delete
			
			Response responseOfChargcode=callDELETEMethod(token, url3+"/api/v1/charges-template/"+termLoan+"/"+chargecodeId);

			softassert.assertEquals(responseOfChargcode.statusCode(), STATUS_CODE_204, "this is the status code for responseOfChargcode");
			softassert.assertAll();	
			
		
	
			}

	//Charge template -Negative scenario
	
	@Feature("TERM LOAN CHARGE TEMPLATE")
	@Stories(value = { @Story(value = "Term Laon charge template CRUD for Negative operation") })
	@Description("This is a test case is to verfiy Charge template CRUD for negative data")
	@Step("verifies charge template")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"Regression"})
	public void chargeTemplateDecimal(String termLoan)throws FileNotFoundException, IOException, ParseException, ProcessingException, InterruptedException {
		//Get  TERM Loan -ID
		SoftAssert softassert = new SoftAssert();
		Response termloanResponse=callGETMethod(token, data.getTermloanID());
		System.out.println("Response :"+termloanResponse.asString());
		String termloanId = termloanResponse.jsonPath().getList("id").get(0).toString();
		System.out.println("loanID :"+termloanId);
		softassert.assertEquals(termloanResponse.statusCode(), STATUS_CODE_200, "this is the status code for termloanResponse");
		
		
		//charge template -Put
		Response ChargeTemplateUpdate=callPUTMethod(token,payloads.getPayloadforChargeTemplatePUTFloat(termLoan),url3+"/api/v1/charges-template/"+termLoan);
		System.out.println("ChargeTemplateUpdate"+ChargeTemplateUpdate.asString());
//		softassert.assertEquals(ChargeTemplateUpdate.statusCode(), STATUS_CODE_204);
		softassert.assertEquals(ChargeTemplateUpdate.statusCode(), STATUS_CODE_400, "this is the status code for ChargeTemplateUpdate");
		softassert.assertAll();	
		
}
	
//Late fee CURD

	@Feature("TERM LOAN CHARGE TEMPLATE")
	@Stories(value = { @Story(value = "termaloan status code validation")})
	@Description("This is a test case which verifies the status code: floating interest")
	@Step("verifies floatinginterest module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups="Regression")
	public void latefee() throws FileNotFoundException, IOException, ParseException {
		
		SoftAssert softassert = new SoftAssert();
		{
			

Response latefeePost=callPOSTMethod(token, payloads.latefee(), data.LatefeeURI());
System.out.println("latefeePost"+latefeePost.asString());
softassert.assertEquals(latefeePost.statusCode(), STATUS_CODE_201,"Verfiy status code of late fee");


Response LatefeePut=callPUTMethod(token, payloads.latefeePUt(), data.LatefeePut());
softassert.assertEquals(latefeePost.statusCode(), STATUS_CODE_204,"Verfiy status code of late fee");

Response latefeedelete=callDELETEMethod(token, data.latefeedelete());
softassert.assertEquals(latefeePost.statusCode(), STATUS_CODE_204,"Verfiy status code of late fee");

		}




}
}
