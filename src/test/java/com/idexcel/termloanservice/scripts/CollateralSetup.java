package com.idexcel.termloanservice.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.idexcel.restassuredresponse.AbstractRestAssuredResponse;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;
import com.idexcel.utilities.Payloads;
import com.idexcel.utilities.TestNGDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class CollateralSetup extends AbstractRestAssuredResponse{


	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;

	/*Token token = new Token();*/
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 

	@Feature("Collateral setup")
	@Stories(value = { @Story(value = "collateralsetup status code validation")})
	@Description("This is a test case which verifies the status code: creation of collateral setup-CRUD with positive ")
	@Step("verifies Collateral setup module")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void collateralCRUD() throws FileNotFoundException, IOException, ParseException {
		SoftAssert softassert = new SoftAssert();


		for (int i = 0; i < 2; i++) {
			Response getFee = callGETMethod(token, data.getTermloanID());
			System.out.println("getFee" + getFee.asString());
			String LoanId = getFee.jsonPath().getList("id").get(0).toString();
			System.out.println("LoanId" + LoanId);
			softassert.assertEquals(getFee.statusCode(), STATUS_CODE_200, "this is the status code for Onetimemanualfee");
			Response collateralGet = callGETMethod(token, data.getCollateralget() + LoanId);
			System.out.println("collateralGet:" + collateralGet.asString());
			softassert.assertEquals(collateralGet.statusCode(), STATUS_CODE_200,
					"this is the status code for Onetimemanualfee");
			Response collateralPost = callPOSTMethod(token, payloads.getPayloadforCollateralSetup(LoanId),
					data.getCollateralget() + LoanId);
			System.out.println("collateralPost:" + collateralPost.asString());
			softassert.assertEquals(collateralPost.statusCode(), STATUS_CODE_201,
					"this is the status code for Onetimemanualfee");
			Response collateral = callGETMethod(token, data.getCollateralget() + LoanId);
			System.out.println("collateral:" + collateral.asString());
			String collateralLoanId = collateral.jsonPath().getList("id").get(0).toString();
			System.out.println("collateralLoanId" + collateralLoanId);
			Response collateralPUt = callPUTMethod(token,
					payloads.getPayloadforCollateralSetupPut(LoanId, collateralLoanId),
					data.getCollateralget() + collateralLoanId);
			System.out.println("collateralPUt:" + collateralPUt.asString());
			softassert.assertEquals(collateralPost.statusCode(), STATUS_CODE_201,
					"this is the status code for Onetimemanualfee");
			Response collateralDelete = callDELETEMethod(token, data.getCollateralget() + collateralLoanId);
			System.out.println("collateralDelete:" + collateralDelete.asString());
			softassert.assertEquals(collateralDelete.statusCode(), STATUS_CODE_204,
					"this is the status code for collateralDelete");
		}
		softassert.assertAll();

	}





@Feature("Collateral setup")
@Stories(value = { @Story(value = "collateralsetup status code validation")})
@Description("This is a test case which verifies the status code: creation of collateral setup-CRUD with positive ")
@Step("verifies Collateral setup module")
@Severity(SeverityLevel.BLOCKER)
@Test(groups= {"sanity", "smoke","regression" })
public void collateralCRUDDecimal() throws FileNotFoundException, IOException, ParseException {

	SoftAssert softassert = new SoftAssert();
	for (int i = 0; i < 2; i++) {
		Response getFee = callGETMethod(token, data.getTermloanID());
		System.out.println("getFee" + getFee.asString());
		String LoanId = getFee.jsonPath().getList("id").get(0).toString();
		System.out.println("LoanId" + LoanId);
		softassert.assertEquals(getFee.statusCode(), STATUS_CODE_200, "this is the status code for Onetimemanualfee");
		Response collateralGet = callGETMethod(token, data.getCollateralget() + LoanId);
		System.out.println("collateralGet:" + collateralGet.asString());
		softassert.assertEquals(collateralGet.statusCode(), STATUS_CODE_200,
				"this is the status code for Onetimemanualfee");
		Response collateralPost = callPOSTMethod(token, payloads.getPayloadforCollateralSetup(LoanId),
				data.getCollateralget() + LoanId);
		System.out.println("collateralPost:" + collateralPost.asString());
		softassert.assertEquals(collateralPost.statusCode(), STATUS_CODE_201,
				"this is the status code for Onetimemanualfee");
		Response collateral = callGETMethod(token, data.getCollateralget() + LoanId);
		System.out.println("collateral:" + collateral.asString());
		String collateralLoanId = collateral.jsonPath().getList("id").get(0).toString();
		System.out.println("collateralLoanId" + collateralLoanId);
		Response collateralPUt = callPUTMethod(token,
				payloads.getPayloadforCollateralSetupPut(LoanId, collateralLoanId),
				data.getCollateralget() + collateralLoanId);
		System.out.println("collateralPUt:" + collateralPUt.asString());
		softassert.assertEquals(collateralPost.statusCode(), STATUS_CODE_201,
				"this is the status code for Onetimemanualfee");
		Response collateralDelete = callDELETEMethod(token, data.getCollateralget() + collateralLoanId);
		System.out.println("collateralDelete:" + collateralDelete.asString());
		softassert.assertEquals(collateralDelete.statusCode(), STATUS_CODE_204,
				"this is the status code for collateralDelete");
		
	}
	softassert.assertAll();

}

}


