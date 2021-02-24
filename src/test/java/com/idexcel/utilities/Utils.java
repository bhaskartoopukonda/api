package com.idexcel.utilities;

import com.google.gson.JsonArray;

public class Utils {
    //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;

    //Sets Base URI
   /* public static void setBaseURI() {
        RestAssured.baseURI = "http://services.groupkt.com/country/get/iso2code";
    }

    //Sets base path
    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }*/

    //Sets ContentType
   /* public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    //Sets Json path term
    public static void setJsonPathTerm(String jsonPath) {
        jsonPathTerm = jsonPath;
    }

    //Created search query path
    public static void createSearchQueryPath(String searchTerm, String param, String paramValue) {
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    }

    //Returns response
    public static Response getResponse() {
        System.out.print("path: " + path +"\n");
        return get(path);
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath(io.restassured.response.Response rspns) {
        String json = rspns.asString();
       System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }*/
    
    public static String getDesiredFieldFromJsonPath(io.restassured.response.Response rspns, String fieldname) {
        String field = rspns.jsonPath().get(fieldname).toString();
       System.out.print("returned json: " + field +"\n");
        return field;
    }
    
    
    public static void callResponseLogsIfValidationFails(io.restassured.response.Response response){
    	response.then().log().ifValidationFails();
	}
    
    public static  String createJsonArray(String value) {
        JsonArray languages = new JsonArray();
        languages.add(value);
        return languages.toString();
        }
}