package com.djonesyking.evalsite.file;

public class FileLocator {
	
	private static String OS = null;
	private static String FILE_LOC = null;
	
	private static final String FILE_LOC_WIN = "C:/test/";
	private static final String FILE_LOC_LINUX = " /var/www/html/eval/docs/";
	private static final String PDF_LOCATION = "pdf/";
	private static final String PDF_EXTENSION = ".pdf";
	private static final String JSON_LOCATION = "json/";
	private static final String JSON_EXTENSION = ".json";
	
	public FileLocator() {
		OS = System.getProperty("os.name");
		if (OS.startsWith("Windows")) {
			FILE_LOC = FILE_LOC_WIN;
		} else {
			FILE_LOC = FILE_LOC_LINUX;
		}
	}
	
	public String getJSONFile(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append(FILE_LOC);
		sb.append(JSON_LOCATION);
		sb.append(id);
		sb.append(JSON_EXTENSION);
		return sb.toString();
	}
	
	public String getPDFFile(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append(FILE_LOC);
		sb.append(PDF_LOCATION);
		sb.append(id);
		sb.append(PDF_EXTENSION);
		return sb.toString();
	}
	public String getPDFLocation() {
		StringBuilder sb = new StringBuilder();
		sb.append(FILE_LOC);
		sb.append(PDF_LOCATION);
		return sb.toString();
	}
}
