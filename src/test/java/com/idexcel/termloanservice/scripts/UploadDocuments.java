package com.idexcel.termloanservice.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

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

public class UploadDocuments extends AbstractRestAssuredResponse{
	
	private static final int STATUS_CODE_200 =200;
	private static final int STATUS_CODE_400 =400;
	private static final int STATUS_CODE_201 =201;
	private static final int STATUS_CODE_204 =204;
	private static final int STATUS_CODE_404 =404;
	private static final int STATUS_CODE_422 =422;
	private static final int STATUS_CODE_500 =500;
  
	DataFromPropertyFile data = new DataFromPropertyFile();
	JSONFileReader json = new JSONFileReader(); 
	
	String path1 = System.getProperty("user.dir")+"\\input\\JavaDeveloperJD.pdf";
	String fileType1 = "pdf";
	String fileName1 ="pdffile";
	
	String path2 = System.getProperty("user.dir")+"\\input\\11 June Report.zip";
	String fileType2 = "zip";
	String fileName2 ="zipfile";
	
	String path3 = System.getProperty("user.dir")+"\\input\\Feedback Analysis.xls";
	String fileType3 = "xls";
	String fileName3 ="xlsfile";
	
	String path4 = System.getProperty("user.dir")+"\\input\\mytesttxt.txt";
	String fileType4 = "txt";
	String fileName4 ="txtfile";
	
	String path5 = System.getProperty("user.dir")+"\\input\\mydoctest.docx";
	String fileType5 = "docx";
	String fileName5 ="docxfile";
	
	String path6 = System.getProperty("user.dir")+"\\input\\testbitmap.BMP";
	String fileType6 = "BMP";
	String fileName6 ="BMPfile";
	
	String path7 = System.getProperty("user.dir")+"\\input\\testdocfile.doc";
	String fileType7 = "doc";
	String fileName7 ="docfile";
	
	String path8 = System.getProperty("user.dir")+"\\input\\testjpeg.jpeg";
	String fileType8 ="jpeg";
	String fileName8 ="jpegfile";
	
	String path9 = System.getProperty("user.dir")+"\\input\\testpng.png";
	String fileType9 ="png";
	String fileName9 ="pngfile";
	
	String path10 = System.getProperty("user.dir")+"\\input\\testxlsx.xlsx";
	String fileType10 ="xlsx";
	String fileName10 ="xlsxfile";
	
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload pdf file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyPDFuploadDocuments() {
		try {
			SoftAssert softassert = new SoftAssert();
			Response rspn =callPOSTMethod1(token,data.uploadFile(),path1,fileType1,fileName1,data.termloanId(),data.clientId(),
					"clientId",data.clientId(),"level","loan");
			int code =rspn.getStatusCode();
			System.out.println(code);
			softassert.assertEquals(code, STATUS_CODE_201);
			
		} catch (Exception e) {
			
		}
		softassert.assertAll();
		
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload zip file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyZIPuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path2,fileType2,fileName2,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
		
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload xls file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyXLSuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path3,fileType3,fileName3,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}	
	
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload txt file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyTXTuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path4,fileType4,fileName4,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload docx file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyDOCXuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path5,fileType5,fileName5,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload bmp file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyBMPuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path6,fileType6,fileName6,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload doc file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyDOCuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path7,fileType7,fileName7,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload jpeg file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyJPEGuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path8,fileType8,fileName8,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload png file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyPNGuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn =callPOSTMethod1(token,data.uploadFile(),path9,fileType9,fileName9,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify the upload xlsx file functionality of the API on loan level")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(groups= {"sanity", "smoke","regression" })
	public void verifyXLSXuploadDocument() {
		SoftAssert softassert = new SoftAssert();
		Response rspn = callPOSTMethod1(token,data.uploadFile(),path10,fileType10,fileName10,data.termloanId(),data.clientId(),
				"clientId",data.clientId(),"level","loan");
		int code =rspn.getStatusCode();
		System.out.println(code);
		softassert.assertEquals(code, STATUS_CODE_201);
	}
	@Feature("Documents")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("Verify and validate the document No value with more than 25 charcter invalid and valid character")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProviderClass=TestNGDataProvider.class,dataProvider="datafromexcel",groups= {"sanity","smoke","Regression"})
	public void documentNo(String DocumentNo,String DocumentName,String purpose,String termloanId,String clientId,String StatusCode) {
		SoftAssert softassert = new SoftAssert();
		try {
			Response rspn = callPOSTMethod2(token,data.uploadFile(),path10,fileType10,fileName10 ,DocumentNo,DocumentName ,purpose,termloanId,clientId
					,"clientId",data.clientId(),"level","loan");
			Thread.sleep(5000);
			int code =rspn.getStatusCode();
			System.out.println(code);
			String statusCode=String.valueOf(code);
			softassert.assertEquals(statusCode, StatusCode);
		} catch (Exception e) {
			
		}
		softassert.assertAll();
	}
	@Feature("Verify and validate the file name extention of the uploaded file")
	@Stories(value = { @Story(value = "Type of file accept validation")})
	@Description("This is a test case which verifies the file name: ")
	@Step("verifies document types")
	@Severity(SeverityLevel.BLOCKER)
	//@Test(groups= {"sanity", "smoke","regression" })
	public void fileNameExtention(){
		SoftAssert softassert = new SoftAssert();
		try {
			Response rspn1 = callPOSTMethod1(token,data.uploadFile(),path1,fileType1,fileName1,data.termloanId(),data.clientId(),
					"clientId",data.clientId(),"level","loan");
			Response getlist=callGETMethod(token, data.getDocumentList());
			System.out.println("Time spend in response"  +rspn1.getTimeIn(TimeUnit.MILLISECONDS));
			
			Date today = new Date();
			DateFormat df = new SimpleDateFormat("YYYYMMdd_HHmm");
			df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
			String IST = df.format(today);
			String actual_filename= fileName10+"_"+IST;
			System.out.println("My file name is"+actual_filename);
			System.out.println("Date in Indian Timezone (IST) : "+IST);
			System.out.println(getlist.getBody().asString());
			String expected_fileName = getlist.jsonPath().getString("fileName[0]");
			String[] words=expected_fileName.split("_");
			String expected_filename=words[0]+"_"+words[1]+"_"+words[2];
			//softassert.assertEquals(actual_filename, expected_filename);
			if(expected_fileName.equals(expected_filename)) {
				System.out.println("my test case is getting passed");
			}
			
		} catch (Exception e) {
			
		}
		softassert.assertAll();
		
	}
	
}
