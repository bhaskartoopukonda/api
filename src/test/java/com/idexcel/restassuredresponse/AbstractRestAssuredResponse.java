package com.idexcel.restassuredresponse;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import com.idexcel.token.BaseTest;
import com.idexcel.token.Token;
import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author Shivaraj.Budeppa
 *
 */
public abstract class AbstractRestAssuredResponse extends BaseTest {
	 
	JSONFileReader json = new JSONFileReader();
	DataFromPropertyFile data = new DataFromPropertyFile();

	
	protected SoftAssert softassert = new SoftAssert();
	@Step("click on this to check actual&expected status code for above method:")	
	public <T> void verifyingStatuscodes(T actual, T expected, T message ){
			softassert.assertEquals(actual, expected);
		
	}
	
	
	
	 
//POST METHODS
	
	@Step("POST Operation:")
	public Response callPOSTMethodWithQuery(String token, String requestBody,String getApi,String parameterName, String parameterValues) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").
				             queryParam(parameterName, parameterValues)
							.when().log().all()
							.body(requestBody)
							.post(getApi);
		return rspns;

	}
	@Step("POST Operation:")
	public Response callPOSTMethodWithTwoQuery(String token, String requestBody,String getApi,String parameterName, String parameterValues,String parameterName1,String parameterValues1) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").
				             queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.body(requestBody)
							.post(getApi);
		return rspns;

	}
	
	@Step("POST Operation:")
	public Response callPOSTMethod(String token, String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.body(requestBody)
							.post(getApi);
		return rspns;

	}
	public Response callPOSTMethodWithMap(String token, Map requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.body(requestBody)
							.post(getApi);
		return rspns;

	}
	@Step("POST Operation:")
	public Response callPOSTMethodWithOnePathParameter(String token, String requestBody,String getApi,String parameterName, String parameterValues) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
				        .pathParam(parameterName,parameterValues)
							.when().log().all()
							.body(requestBody)
							.post(getApi);
		return rspns;

	}

 
	@Step("POST Operation to upload File:")
	public Response callPOSTMethod(String token, String keyname,String filepath, String fileType, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, new File(filepath), fileType)
							.post(getApi);
		return rspns;

	}
	
	
	@Step("POST Operation to call key pair value:")
	public Response callPOSTMethod(String token, String keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, value)
							.post(getApi);
		return rspns;

	}
	@Step("POST Operation to call key pair value:")
	public Response callPutMethod(String token, String keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, value)
							.post(getApi);
		return rspns;

	}

	
// GET METHODS:
	
	@Step("GET Operation:")
	public Response callGETMethod(String token,  String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation:")
	public Response callGETMethodWithPathParameter(String token,  String getApi,String parameterName,String parameterValue ) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").pathParam(parameterName, parameterValue)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation:")
	public Response callGETMethodWithOneQuery(String token,  String getApi,String days) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").queryParam("days",days)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation:")
	public Response callGETMethodWithQuery(String token,  String getApi ,String termLoanId) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").queryParam("termLoanId", termLoanId)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation:")
	public Response callGETMethodWithTwoQuery(String token,  String getApi ,String days,String sortingKey) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").queryParam("days", days).queryParam("sortingKey",sortingKey)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation:")
	public Response callGETMethods(String token,  String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation:")
	public Response callGETMethodsForCron(String getApi,String parameterName, String parameterValues,String parameterName1, String parameterValues1) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =    given().queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation:")
	public Response callGETMethodsForCron(String getApi,String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =    given().queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1).queryParam(parameterName2, parameterValues2)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 1 query Parameter:")
	public Response callGETMethod(String token,  String parameterName, String parameterValues,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	
	@Step("GET Operation With 2 query Parameter:")
	public Response callGETMethod(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 2 query Parameter:")
	public Response callGETMethodQueryTwo(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	
	@Step("GET Operation With 3 query Parameter:")
	public Response callGETMethod(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 3 query Parameter:")
	public Response callGETMethod(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2, String parameterName3,String parameterValues3,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.queryParam(parameterName3, parameterValues3)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 6 query Parameter:")
	public Response callGETMethodWithSixQuery(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2,
			String parameterName3, String parameterValues3,String parameterName4, String parameterValues4,
			String parameterName5, String parameterValues5,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.queryParam(parameterName3, parameterValues3)
							.queryParam(parameterName4, parameterValues4)
							.queryParam(parameterName5, parameterValues5)
							
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 6 query Parameter:")
	public Response callGETMethodWithSevenQuery(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2,
			String parameterName3, String parameterValues3,String parameterName4, String parameterValues4,
			String parameterName5, String parameterValues5,String parameterName6,String parameterValues6,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.queryParam(parameterName3, parameterValues3)
							.queryParam(parameterName4, parameterValues4)
							.queryParam(parameterName5, parameterValues5)
							.queryParam(parameterName6, parameterValues6)
							
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 6 query Parameter:")
	public Response callGETMethodWithFiveQuery(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2,
			String parameterName3, String parameterValues3,String parameterName4, String parameterValues4,
			String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.queryParam(parameterName3, parameterValues3)
							.queryParam(parameterName4, parameterValues4)
							
							
							.when().log().all()
							.get(getApi);

		return rspns;
	}

//PUT METHODS:
 
	@Step("PUT Operation:")
	public Response callPUTMethod(String token, String  requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	@Step("PUT Operation:")
	public Response callPUTMethodWithOnePathParameter(String token, String  requestBody, String getApi,String parameterName, String parameterValues) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").pathParam(parameterName, parameterValues)
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	
	@Step("PUT Operation:")
	public Response callPUTMethodWithQuaryParameter(String token, String parameterName, String parameterValues, String  requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	@Step("PUT Operation:")
	public Response callPUTMethod(String token, String parameterName, String parameterValues, String parameterName1,String parameterValues1,String  requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	@Step("PUT Operation:")
	public Response callPUTMethodWithTwoQuaryParameter(String token, String parameterName, String parameterValues,String parameterName1, String parameterValues1, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.put(getApi);
		return rspns;
	}
	@Step("PUT Operation:")
	public Response callPUTMethodWithFiveQuaryParameter(String token, String parameterName, String parameterValues,String parameterName1, String parameterValues1, 
			String parameterName2 ,String parameterValues2,String parameterName3,String parameterValue3,String parameterName4,String parameterValue4, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.queryParam(parameterName3, parameterValue3)
							.queryParam(parameterName4, parameterValue4)
							.when().log().all()
							.put(getApi);
		return rspns;
	}
	
	
	@Step("PUT Operation to KeyValuePai:")
	
	public Response callPUTMethod(String token, String keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, value)
							.put(getApi);
		return rspns;

	}
	@Step("PUT Operation:")
	public Response callPUTMethod1(String token, String keyname,String value, String  requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all().multiPart(keyname, value)
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
@Step("PUT Operation to KeyValuePai:")
	
	public Response callPUTMethods(String token, String keyname,String value,String keyname1, String value1,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, value)
							.multiPart(keyname1, value1)
							.put(getApi);
		return rspns;

	}

	@Step("PUT Operation to KeyValuePai:")
	
	public Response callPUTMethods(String token,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.put(getApi);
		return rspns;

	}
	
	@Step("PUT Operation to upload File:")
	public Response callPUTMethod(String token, String keyname,String filepath, String fileType, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, new File(filepath), fileType)
							.put(getApi);
		return rspns;

	}
//DELETE METHODS:
	
	@Step("DELETE Operation:")
	public Response callDELETEMethod(String token,  String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.delete(getApi);
		return rspns;
		
	}
	@Step("DELETE Operation:")
	public Response callDELETEMethodWithTwoPathParam(String token,  String getApi,String parameterName1, String parameterValues1,
			String parameterName2, String parameterValues2) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").
				           pathParam(parameterName1, parameterValues1).pathParam(parameterName2, parameterValues2)
							.when().log().all()
							.delete(getApi);
		return rspns;
		
	}
	@Step("DELETE Operation:")
	public Response callDELETEMethodWithQuery(String token,  String getApi,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2,String parameterName3, String parameterValues3,String parameterName4, String parameterValues4) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").
				queryParam(parameterName1, parameterValues1).queryParam(parameterName2, parameterValues2).queryParam(parameterName3, parameterValues3)
				.queryParam(parameterName4, parameterValues4)
							.when().log().all()
							.delete(getApi);
		return rspns;
		
	}
	@Step("DELETE Operation:")
	public Response callDELETEMethodWithQuery(String token,  String getApi,String parameterName1, String parameterValues1,String parameterName2, List<String> parameterValues2) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json").
				queryParam(parameterName1, parameterValues1).queryParam(parameterName2, parameterValues2)
							.when().log().all()
							.delete(getApi);
		return rspns;
		
	}

	@Step("DELETE Operation:")
	public Response callDELETEMethod(String token, String requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.body(requestBody)
							.when().log().all()
							.delete(getApi);
		return rspns;
	}	
	
//PATCH METHODS: 
	@Step("PATCH Operation From Excel:")
	public Response callPATCHMethod(String token, String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.body(requestBody)
							.patch(getApi);
		return rspns;

	}
	//OPTIONS METHODS: 	
	@Step("POST Operation:")
	public Response callOPTIONSMethod(String token, String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.body(requestBody)
							.options(getApi);
		return rspns;

	}
	
	@Step("POST Operation:")
	public Response callOPTIONSMethod(String token, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.options(getApi);
		return rspns;
	
	 
	}
	@Step("POST Operation to upload documents with multiple form")
	public Response callPOSTMethod1(String token,String getApi,String filepath,String fileType,String fileName,String termloanId,String clientId,
			                    String parameterName, String parameterValues,String parameterName1, String parameterValues1)  {
		
		Response rspns= given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data").
				 queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1)
				.multiPart("file", new File(filepath)).multiPart("documentName","YUV213").multiPart("purpose","uploading file").multiPart("fileName",fileName)
				.multiPart("documentNo","QA121").multiPart("termloanId",termloanId).multiPart("fileType",fileType)
				.multiPart("clientId",clientId).when().log().all().post(getApi);
		return rspns;
		
		
	}
	@Step("POST Operation to upload documents with multiple form")
	public Response callPOSTMethodforBrowwer(String token,String getApi)  {
		
		Response rspns= given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data").
				 
				multiPart("is_primary_addr","0").multiPart("is_primary_addr","1").multiPart("address_code","23092020")
				.multiPart("name_primary","MAHESH").multiPart("street_address","210 Harvard St, Brookline").multiPart("city","BROOLINE")
				.multiPart("country_id","102").multiPart("state_province_id","205").multiPart("zip_code","02446")
				.multiPart("[phones_attributes][0][phone_type]","Business")
				.multiPart("[phones_attributes][0][phone_no]","+918553432171")
				.multiPart("[phones_attributes][0][id]","1425")
				.multiPart("menu_id","78").multiPart("commit","Save").when().log().all().post(getApi);
		return rspns;
		
		
	}
	@Step("POST Operation to upload documents with multiple form")
	public Response callPOSTMethod3(String token,String getApi,String filepath,String fileType,String fileName,String parameterName, String parameterValues,String parameterName1, String parameterValues1)  {
		
		Response rspns= given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data").
				 queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1)
				.multiPart("file", new File(filepath)).multiPart("documentName","YUV213").multiPart("purpose","uploading file").multiPart("fileName",fileName)
				.multiPart("documentNo","QA121").multiPart("termloanId","null").multiPart("fileType",fileType)
				.multiPart("clientId","11622").when().log().all().post(getApi);
		return rspns;
		
		
	}
	@Step("POST Operation to upload documents with multiple form")
	public Response callPOSTMethod2(String token,String getApi,String filepath,String fileType,String fileName ,String DocumentNo,String DocumentName ,String purpose,String termloanId,String clientId,
			String parameterName, String parameterValues,String parameterName1, String parameterValues1)  {
		
		Response rspns= given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data").
				queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1)
				.multiPart("file", new File(filepath)).multiPart("documentName",DocumentName).multiPart("purpose",purpose).multiPart("fileName",fileName)
				.multiPart("documentNo",DocumentNo).multiPart("termloanId",termloanId).multiPart("fileType",fileType)
				.multiPart("clientId",clientId).when().log().all().post(getApi);
		return rspns;
		
		
	}
@Step("PUT Operation to KeyValuePai:")
	
	public Response callPUTMethodforNormalPUTOperation(String token,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.when().log().all()
							.put(getApi);
		return rspns;

	}

public Response callPUTMethodforNormalPUTOperationWithQuery(String token,String getApi,String parameterName,String parameterValues,String parameterName1,String parameterValues1) throws FileNotFoundException, IOException, ParseException {
	Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
			.queryParam(parameterName, parameterValues).queryParam(parameterName1, parameterValues1)
						.when().log().all()
						.put(getApi);
	return rspns;

}

public Response callPUTMethodWithoutBodyOneQuery(String token,String getApi,String parameterName,String parameterValues) throws FileNotFoundException, IOException, ParseException {
	Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
			.queryParam(parameterName, parameterValues)
						.when().log().all()
						.put(getApi);
	return rspns;

}
public Response callPUTMethod1(String token, String keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
	Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
						.when().log().all()
						.put(getApi);
	return rspns;

}
}


