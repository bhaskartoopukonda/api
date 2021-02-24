package com.idexcel.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.util.JSON;

/**
 * @author Shivaraj.Budeppa
 *
 */
public class JSONFileReader {

	public String getJsonFile(String jsonInput) throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();

		Object object = parser
				.parse(new FileReader(jsonInput));
		String getFile = object.toString();

		return getFile;
	}

}