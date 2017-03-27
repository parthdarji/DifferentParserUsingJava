package com.XSLParser;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertToHTML {
	public static void main(String args[]){
		if(args.length != 3){
			
			System.err.println("give command as follows : ");
			System.err.println("XSLTTest data.xml converted.xsl converted.html");
			return;
		}
		
		String data = args[0];
		String inputxsl = args[1];
		String outputHtml = args[2];
		
		ConvertToHTML html = new ConvertToHTML();
		try{
			html.transformtoHtml(data,inputxsl,outputHtml);
		}
		catch (TransformerConfigurationException e)

		{
			System.err.println("TransformerConfigurationException");
			System.err.println(e);
		}
		catch (TransformerException e)
		{
			System.err.println("TransformerException");
			System.err.println(e);
		}
	}
	public static void transformtoHtml(String dataXML, String inputXSL, String outputHTML)throws TransformerException,TransformerConfigurationException{
		TransformerFactory factory = TransformerFactory.newInstance();
		StreamSource xslStream = new StreamSource(inputXSL);
		
		Transformer transformer = factory.newTransformer(xslStream);
		StreamSource input = new StreamSource(dataXML);
		StreamResult output = new StreamResult(outputHTML);
		transformer.transform(input, output);
		
		 System.out.println("The generated HTML file is:" + outputHTML);
		 
	}
}
