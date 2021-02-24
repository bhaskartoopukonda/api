package com.idexcel.restassuredresponse;

import java.util.ArrayList;
import java.util.List;

import com.idexcel.utilities.DataFromPropertyFile;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public abstract class AbstractRestAssuredRequestspecification {
	DataFromPropertyFile data = new DataFromPropertyFile();
/*
	public RequestSpecification getRequesSpecifications() {
		RequestSpecification  requestSpec;
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("lenderId", data.getLenderID());
		builder.addHeader("Accept", "application/json");
		builder.addHeader("Content-Type", "application/json");
		builder.setBody(data.getcredentials());
		return requestSpec = builder.build();
	}*/



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




 