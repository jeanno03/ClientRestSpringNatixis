package myservices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.function.Function;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;


import myEntities.Data;
import myEntities.DataParent;
import myEntities.MyUser;
import myEntities.result;
import myEntities.resultCsv;

@Service
public class MyService implements MyServiceInterface{
	
	Logger logger = Logger.getLogger("MyLog");  
	FileHandler fh; 

	@Override
	public String getTest() {
		// TODO Auto-generated method stub
		return "Hello World";
	}


	
	@Override
	public MyUser getMyUserTest() {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://test.jeannory.ovh:8080/main/getUserByEmail?email=terreiyaki@gmail.com";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("howtodoinjava", "password");		
		HttpEntity<String> entity = new HttpEntity<String> ("parameter", headers);
		ResponseEntity<MyUser>respEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, MyUser.class);
		MyUser result = respEntity.getBody();

		return result;
	}
	
	@Override
	public DataParent getDataParentIcaTest() {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/getIcaDataTest";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("howtodoinjava", "password");		
		HttpEntity<String> entity = new HttpEntity<String> ("parameter", headers);
		ResponseEntity<DataParent>respEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, DataParent.class);
		DataParent result = respEntity.getBody();

		return result;
	}
	@Override
	public void writeToFile() {
		DataParent dataParent = getDataParentIcaTest();
		Data data = dataParent.getData();
		result[] results = data.getResult();
		

		try {
			FileOutputStream f = new FileOutputStream(new File("C:/logs/myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			for(int i=0;i<results.length;i++) {
//				o.writeObject(results[i].getU_end_date());
				o.writeUTF(results[i].getU_end_date());
			}
			o.close();
			f.close();

//			FileInputStream fi = new FileInputStream(new File("C:/logs/myObjects.txt"));
//			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
//			Person pr1 = (Person) oi.readObject();
//			Person pr2 = (Person) oi.readObject();
//
//			System.out.println(pr1.toString());
//			System.out.println(pr2.toString());

//			oi.close();
//			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");

	}
	
	}
	
//	private String parent;
//	private String [] description;
//	private String u_end_date;
	
//	 File outputFile = new File("outagain.txt");
//	 FileReader in = new FileReader(inputFile);
//	 FileWriter out = new FileWriter(outputFile); 
	 
	//https://www.codejava.net/coding/super-csv-writing-pojos-to-csv-file-using-csvbeanwriter
	@Override
	public void writeCSVFile() {
		File outputFile = new File("C:/logs/myCsv.csv");
		
		DataParent dataParent = getDataParentIcaTest();
		Data data = dataParent.getData();
		result[] results = data.getResult();
		resultCsv[] resultCsv = transformResultTabToResultCsvTab( results);
		
	    ICsvBeanWriter beanWriter = null;
	    CellProcessor[] processors = new CellProcessor[] {
	            new NotNull(), // parent
	            new NotNull(), // description
	            new NotNull(), // u_end_date

	    };
	 
	    try {
	        beanWriter = new CsvBeanWriter(new FileWriter(outputFile), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
	        String[] header = {"parent", "description", "u_end_date"};
	        beanWriter.writeHeader(header);
	 
	        for (resultCsv r : resultCsv) {
	            beanWriter.write(r, header, processors);
	        }
	 
	    } catch (IOException ex) {
	        System.err.println("Error writing the CSV file: " + ex);
	    } finally {
	        if (beanWriter != null) {
	            try {
	                beanWriter.close();
	            } catch (IOException ex) {
	                System.err.println("Error closing the writer: " + ex);
	            }
	        }
	    }
	}
	
	private resultCsv[] transformResultTabToResultCsvTab(result[] results) {
		logger.info("je test transformResultTabToResultCsvTab");
		resultCsv[] resultCsvTab = new resultCsv[results.length];
	for(int i=0;i<results.length;i++) {
		resultCsv resultCsv = results[i].getReturnCsv();
		logger.info(resultCsv.getParent()); 
		resultCsvTab[i] = resultCsv;
	}
		
		return resultCsvTab;

		
	}
	
	
	
}
