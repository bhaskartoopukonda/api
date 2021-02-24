package com.idexcel.utilities;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
/**
 * @author Shivaraj.Budeppa
 *
 */
public class ValidationJSON {

	public  static boolean validatingJSONBody(String  jsonData,String jsonSchema) throws IOException, ProcessingException {
		boolean report = false;
		try {
			final JsonNode JsonNodedata = JsonLoader.fromString(jsonData);
			final JsonNode JsonNodeschema = JsonLoader.fromString(jsonSchema);
			final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

			JsonValidator validator = factory.getValidator();

			ProcessingReport processingReport = validator.validate(JsonNodedata, JsonNodeschema);

			processingReport.isSuccess();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Schema is not valid: " +report);
		} 
		return report;	
	}
}
