package com.xmltojson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;


//import net.sf.json.JSONObject;

public class Converttojson {
	public static void main(String args[]) throws IOException {
		try  {
			InputStream inputStream = new FileInputStream(new File("input.xml"));
			String xml = IOUtils.toString(inputStream);

			JSONObject jObject = XML.toJSONObject(xml);  
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			Object json = mapper.readValue(jObject.toString(), Object.class);
			String output = mapper.writeValueAsString(json);
			System.out.println(output);
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
}
