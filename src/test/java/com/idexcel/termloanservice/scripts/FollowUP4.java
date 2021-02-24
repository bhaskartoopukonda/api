package com.idexcel.termloanservice.scripts;

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

public class FollowUP4 extends AbstractRestAssuredResponse{
	
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;
	private static final int STATUS_CODE_500 =500;
	static double dfee=0.0;

	
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
	
	@Feature("Follow up4")
	@Stories(value = { @Story(value = "Follow up status code validation")})
	@Description("This is a test case which verifies the status code: Get Attention Required Count API ")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void remainderBefofePaymentdue() {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response respn = callGETMethod(token,"eventName","payment-due",url3+"/api/v1/term-loan/event");
			
			softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
	}
	@Feature("Follow up4")
	@Stories(value = { @Story(value = "Follow up status code validation")})
	@Description("This is a test case which verifies the status code: Get Attention Required Count API ")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"smoke"})
	public void remainderAfterPaymentdue() {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response respn = callGETMethod(token,"eventName","payment-due",url3+"/api/v1/term-loan/event/info");
			softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
	}
	@Feature("Follow up4")
	@Stories(value = { @Story(value = "Follow up status code validation")})
	@Description("This is a test case which verifies the status code: Get Attention Required Count API ")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"smoke"})
	public void remainderpostCall(String termLoanEventid,String eventName,String displayName,String notifyType,String eventAction,String eventDays,String emailTemplateid) {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response respn = callPOSTMethod(token,payloads.autoNotification(termLoanEventid, eventName, displayName, notifyType, eventAction, eventDays, emailTemplateid),url3+"/api/v1/term-loan/event/setup");
			softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
	}
	@Feature("Follow up4")
	@Stories(value = { @Story(value = "Follow up status code validation")})
	@Description("This is a test case which verifies the status code: Get Attention Required Count API ")
	@Step("Get Attention Required Count")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke"})
	public void remainderpostAfterDue(String id,String termLoanEventid,String eventName,String displayName,String notifyType,String eventAction,String eventDays,String emailTemplateid,String emailTemplatename) {
		
		SoftAssert softassert = new SoftAssert();
		
		try {
			Response respn = callPOSTMethod(token,payloads.autoNotificationafterDue(id, termLoanEventid, notifyType, eventAction, eventDays, emailTemplateid, emailTemplatename),url3+"/api/v1/term-loan/event/setup");
			softassert.assertEquals(STATUS_CODE_200, respn.getStatusCode());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		softassert.assertAll();
	}


}
