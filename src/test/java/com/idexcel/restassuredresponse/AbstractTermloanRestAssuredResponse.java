package com.idexcel.restassuredresponse;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.idexcel.utilities.DataFromPropertyFile;
import com.idexcel.utilities.JSONFileReader;

import com.mongodb.util.JSON;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author Shivaraj.Budeppa
 *
 */
public abstract class AbstractTermloanRestAssuredResponse extends com.idexcel.token.Token{
	 
	JSONFileReader json = new JSONFileReader();
	DataFromPropertyFile data = new DataFromPropertyFile();
 
	
	private SoftAssert softassert = new SoftAssert();
	@Step("click on this to check actual&expected status code for above method:")	
	public <T> void verifyingStatuscodes(T actual, T expected, T message ){
			softassert.assertEquals(actual, expected);
		
	}
	
//POST METHODS
	//	POST Operation:
	@Step("POST Operation:")
	public Response callPOSTMethod(String token, String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().urlEncodingEnabled(false).auth().oauth2(token).headers(getHeaders())
							.when().log().all()
							.body(requestBody)
							.post(getApi);
		return rspns;

	}
	@Step("POST Operation:")
	public Response callPOSTMethod(String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers(getHeaders())
							.when().log().all()
							.body(requestBody)
							.post(getApi);
		return rspns;

	}

	//	POST Operation to upload File:	
	@Step("POST Operation to upload File:")
	public <T>Response callPOSTMethod(T token, String keyname,String filepath, String fileType, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2((String) token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, new File(filepath), fileType)
							.post(getApi);
		return rspns;
	}
	@Step("POST Operation to upload File:")
	public <T>Response callPOSTMethod(T keyname,String filepath, String fileType, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart((String) keyname, new File(filepath), fileType)
							.post(getApi);
		return rspns;
	}
	
	
	//	POST Operation to call key pair value:
	@Step("POST Operation to call key pair value:")
	public Response callPOSTMethod(String token, String keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, value)
							.post(getApi);
		return rspns;

	}
	@Step("POST Operation to call key pair value:")
	public <T>Response callPOSTMethod(T keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart((String) keyname, value)
							.post(getApi);
		return rspns;

	}

	
	//	POST Operation to upload excelFile :
	@Step("POST Operation to upload File:")
	public Response callPOSTMethod(String token, String deposit_mappingFile,String filepath,
			String deposit_mappingName, String deposit_mappingNamevalue, 
			String deposit_mappingfile_format, String deposit_mappingfile_formatvalue, 
			String deposit_mappingcash_receipt_source_code_id, String string, 
			String deposit_mappingdata_type, String deposit_mappingdata_typevalue,
			String step, String stepvalue, 
			String state_event, String state_eventvalue, 
			String deposit_mappingsheet_no, String deposit_mappingsheet_novalue, String getAPI ) throws FileNotFoundException, IOException, ParseException {
		
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers("lenderId","staging","Accept","application/json","Content-Type","multipart/form-data")
				.when().log().all()
				.multiPart(deposit_mappingFile, new File(filepath), "excel/xlsx")
				.multiPart(deposit_mappingName, deposit_mappingNamevalue)
				.multiPart(deposit_mappingfile_format, deposit_mappingfile_formatvalue)
				.multiPart(deposit_mappingcash_receipt_source_code_id, string)
				.multiPart(deposit_mappingdata_type, deposit_mappingdata_typevalue)
				.multiPart(step, stepvalue)
				.multiPart(state_event, state_eventvalue)
				.multiPart(deposit_mappingsheet_no, deposit_mappingsheet_novalue)
				.post(getAPI);
		return rspns;
 
	}
	@Step("POST Operation to upload File:")
	public Response callPOSTMethod(String deposit_mappingFile,String filepath,
			String deposit_mappingName, String deposit_mappingNamevalue, 
			String deposit_mappingfile_format, String deposit_mappingfile_formatvalue, 
			String deposit_mappingcash_receipt_source_code_id, String string, 
			String deposit_mappingdata_type, String deposit_mappingdata_typevalue,
			String step, String stepvalue, 
			String state_event, String state_eventvalue, 
			String deposit_mappingsheet_no, String deposit_mappingsheet_novalue, String getAPI ) throws FileNotFoundException, IOException, ParseException {
		
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers("lenderId","staging","Accept","application/json","Content-Type","multipart/form-data")
				.when().log().all()
				.multiPart(deposit_mappingFile, new File(filepath), "excel/xlsx")
				.multiPart(deposit_mappingName, deposit_mappingNamevalue)
				.multiPart(deposit_mappingfile_format, deposit_mappingfile_formatvalue)
				.multiPart(deposit_mappingcash_receipt_source_code_id, string)
				.multiPart(deposit_mappingdata_type, deposit_mappingdata_typevalue)
				.multiPart(step, stepvalue)
				.multiPart(state_event, state_eventvalue)
				.multiPart(deposit_mappingsheet_no, deposit_mappingsheet_novalue)
				.post(getAPI);
		return rspns;
 
	}

	
	//	POST Operation to upload zipFile and excellFile:
	@Step("POST Operation to upload File:")
	public Response callPOSTMethod(String token, String deposit_mappingFile,String filepath, String deposit_mappingFile1,String filepath1,String getAPI ) throws FileNotFoundException, IOException, ParseException {
		
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers("lenderId","staging","Accept","application/json","Content-Type","multipart/form-data")
				.when().log().all()
				.multiPart(deposit_mappingFile, new File(filepath), "excel/xlsx")
				.multiPart(deposit_mappingFile1, new File(filepath1), "zip")
				.post(getAPI);
		return rspns;
 
	}
	@Step("POST Operation to upload File:")
	public Response callPOSTMethod(String deposit_mappingFile,String filepath, String deposit_mappingFile1,String filepath1,String getAPI ) throws FileNotFoundException, IOException, ParseException {
		
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers("lenderId","staging","Accept","application/json","Content-Type","multipart/form-data")
				.when().log().all()
				.multiPart(deposit_mappingFile, new File(filepath), "excel/xlsx")
				.multiPart(deposit_mappingFile1, new File(filepath1), "zip")
				.post(getAPI);
		return rspns;
 
	}

// GET METHODS:
	
	//	GET Operation:
	@Step("GET Operation:")
	public Response callGETMethod(String token,  String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers(getHeaders())
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	public Response callGETMethod(String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers(getHeaders())
							.when().log().all()
							.get(getApi);

		return rspns;
	}

	//	GET Operation With 1 query Parameter:	
	@Step("GET Operation With 1 query Parameter:")
	public Response callGETMethod(String token,  String parameterName, String parameterValues,  String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers(getHeaders())
				.queryParam(parameterName, parameterValues)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	
	@Step("GET Operation With 1 query Parameter:")
	public Response callGETMethod(String parameterName, String parameterValues,  String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers(getHeaders())
				.queryParam(parameterName, parameterValues)
							.when().log().all()
							.get(getApi);

		return rspns;
	}

	//	GET Operation With 2 query Parameter:
	@Step("GET Operation With 2 query Parameter:")
	public Response callGETMethod(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers(getHeaders())
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 2 query Parameter:")
	public Response callGETMethod(String parameterName, String parameterValues,String parameterName1, String parameterValues1, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers(getHeaders())
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.when().log().all()
							.get(getApi);

		return rspns;
	}

	
	//	GET Operation With 3 query Parameter:
	@Step("GET Operation With 3 query Parameter:")
	public Response callGETMethod(String token,  String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers(getHeaders())
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	@Step("GET Operation With 3 query Parameter:")
	public Response callGETMethod(String parameterName, String parameterValues,String parameterName1, String parameterValues1,String parameterName2, String parameterValues2, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers(getHeaders())
							.queryParam(parameterName, parameterValues)
							.queryParam(parameterName1, parameterValues1)
							.queryParam(parameterName2, parameterValues2)
							.when().log().all()
							.get(getApi);

		return rspns;
	}
	
	
	
	
//PUT METHODS:
	//PUT Operation:
	@Step("PUT Operation:")
	public Response callPUTMethod(String token, String  requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers(getHeaders())
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	@Step("PUT Operation:")
	public Response callPUTMethod(String  requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers(getHeaders())
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	
	
	//	PUT Operation to KeyValuePai:	
	@Step("PUT Operation to KeyValuePai:")
	public Response callPUTMethod(String token, String keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, value)
							.put(getApi);
		return rspns;

	}
	@Step("PUT Operation to KeyValuePai:")
	public <T>Response callPUTMethod(T keyname,String value, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart((String) keyname, value)
							.put(getApi);
		return rspns;

	}
	
	//	PUT Operation to upload File:	
	@Step("PUT Operation to upload File:")
	public Response callPUTMethod(String token, String keyname,String filepath, String fileType, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart(keyname, new File(filepath), fileType)
							.put(getApi);
		return rspns;

	}
	@Step("PUT Operation to upload File:")
	public <T>Response callPUTMethod(T keyname,String filepath, String fileType, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","multipart/form-data")
							.when().log().all()
							.multiPart((String) keyname, new File(filepath), fileType)
							.put(getApi);
		return rspns;

	}

	
	//	callPUTMethodWithQuaryParameter	
	@Step("PUT Operation With QuaryParameter:")
	public Response callPUTMethodWithQuaryParameter(String token, String parameterName, String parameterValues, String  requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().auth().oauth2(token).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	@Step("PUT Operation With QuaryParameter:")
	public Response callPUTMethodWithQuaryParameter(String parameterName, String parameterValues, String  requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers("lenderId",data.getLenderID(),"Accept","application/json","Content-Type","application/json")
							.queryParam(parameterName, parameterValues)
							.when().log().all()
							.body(requestBody)
							.put(getApi);
		return rspns;
	}
	

	
//DELETE METHODS:
	//DELETE Operation:	
	@Step("DELETE Operation:")
	public Response callDELETEMethod(String token,  String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers(getHeaders())
							.when().log().all()
							.delete(getApi);
		return rspns;
		
	}
	@Step("DELETE Operation:")
	public Response callDELETEMethod(String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().urlEncodingEnabled(false).auth().oauth2(getAccessToken()).headers(getHeaders())
							.when().log().all()
							.delete(getApi);
		return rspns;
		
	}

	//	DELETE Operation with RequestBody:
	@Step("DELETE Operation with RequestBody:")
	public Response callDELETEMethod(String token, String requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers(getHeaders())
							.body(requestBody)
							.when().log().all()
							.delete(getApi);
		return rspns;
	}	
	@Step("DELETE Operation with RequestBody:")
	public <T>Response callDELETEMethod(T requestBody, String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(getAccessToken()).headers(getHeaders())
							.body(requestBody)
							.when().log().all()
							.delete(getApi);
		return rspns;
	}	
	
	
	
//PATCH METHODS: 
	//	PATCH Operation From 
	@Step("PATCH Operation From Excel:")
	public Response callPATCHMethod(String token, String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(token).headers(getHeaders())
							.when().log().all()
							.body(requestBody)
							.patch(getApi);
		return rspns;

	}
	@Step("PATCH Operation From Excel:")
	public Response callPATCHMethod(String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
		Response  rspns =  given().auth().oauth2(getAccessToken()).headers(getHeaders())
							.when().log().all()
							.body(requestBody)
							.patch(getApi);
		return rspns;

	}
	

//OPTIONS METHODS: 
	//	OPTIONS Operation With Body:
	@Step("OPTIONS Operation With Body:")
	public Response callOPTIONSMethod(String token, String requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
			Response  rspns =  given().auth().oauth2(token).headers(getHeaders())
								.when().log().all()
								.body(requestBody)
								.options(getApi);
			return rspns;
		}
	@Step("OPTIONS Operation With Body:")
	public <T>Response callOPTIONSMethod(T requestBody,String getApi) throws FileNotFoundException, IOException, ParseException {
			Response  rspns =  given().auth().oauth2(getAccessToken()).headers(getHeaders())
								.when().log().all()
								.body(requestBody)
								.options(getApi);
			return rspns;
		}

//	OPTIONS Operation Without Body:
	@Step("OPTIONS Operation Without Body:")
	public Response callOPTIONSMethod(String token, String getApi) throws FileNotFoundException, IOException, ParseException {
			Response  rspns =  given().auth().oauth2(token).headers(getHeaders())
										.when().log().all()
										.options(getApi);
		return rspns;

	}
	@Step("OPTIONS Operation Without Body:")
	public Response callOPTIONSMethod(String getApi) throws FileNotFoundException, IOException, ParseException {
			Response  rspns =  given().auth().oauth2(getAccessToken()).headers(getHeaders())
										.when().log().all()
										.options(getApi);
		return rspns;

	}
 
	
	
	public  Headers getHeaders() {
			Headers headers;

			List<Header> headerlist = new ArrayList<Header>();
			headerlist.add(new Header("lenderId", data.getLenderID()));
			headerlist.add(new Header("Accept", "application/json"));
			headerlist.add(new Header("Content-Type", "application/json"));
			headers = new Headers(headerlist);

			return headers;
		}

}




























/*	@Step("POST Operation to upload File:")
	public Response callStagingPOSTMETHODToUploadFile(String token, String deposit_mappingFile,String filepath, String deposit_mappingFile1,String filepath1,String getAPI ) throws FileNotFoundException, IOException, ParseException {
		
		Response rspns =  given().urlEncodingEnabled(false).auth().oauth2(token).headers("lenderId","staging","Accept","application/json","Content-Type","multipart/form-data")
				.when().log().all()
				.multiPart(deposit_mappingFile, new File(filepath), "excel/xlsx")
				.multiPart(deposit_mappingFile1, new File(filepath1), "zip")
				.post(getAPI);
		return rspns;
 
	}
*/
	

