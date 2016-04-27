package com.djonesyking.evalsite.pdf;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import com.djonesyking.evalsite.submit.domain.Evaluation;

public class FirstPdfTest {

	@Test
	@Ignore
	public void test() throws JsonParseException, JsonMappingException, IOException {
		FirstPdf classUnderTest = new FirstPdf();
		ObjectMapper mapper = new ObjectMapper();
		
		Evaluation eval = mapper.readValue(new File("c:/temp/recorded.json"), Evaluation.class);
		
		classUnderTest.buildPDF(eval);
		
	}
	

}
