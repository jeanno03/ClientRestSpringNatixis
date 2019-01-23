package natixis.drive;



import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import myEntities.Data;
import myEntities.DataParent;
import myEntities.MyGrant;
import myEntities.MyUser;
import myEntities.result;
import myservices.MyService;
import myservices.MyServiceInterface;

// u need to run https://github.com/jeanno03/ServiceRestSpringBoot
// and terreiyaki Restaurant

@SpringBootApplication
public class ClientRestSpringNatixisApplication {
	
	@Autowired
	private static MyServiceInterface myService = new MyService();

	public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(ClientRestSpringNatixisApplication.class);
	        app.setDefaultProperties(Collections
	          .singletonMap("server.port", "8083"));
	        app.run(args);

		
		Logger logger = Logger.getLogger("MyLog");  
		FileHandler fh;  

		try {  

			// This block configure the logger with handler and formatter  
			fh = new FileHandler("C:/logs/File.log");  
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);  

			// the following statement is used to log any messages  
			logger.info("My first log");  
			String testString = myService.getTest();
			logger.info(testString); 
		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  

		logger.info("Hi How r u?"); 
		
		String testString = myService.getTest();
		logger.info(testString); 
		
		
		MyUser myUser = myService.getMyUserTest();
		logger.info(myUser.toString());
		
		List<MyGrant> myGrants = myUser.getMyGrants();
		
		for(int i=0;i<myGrants.size();i++) {
			logger.info(myGrants.get(i).getName());
		}
		
		DataParent dataParent = myService.getDataParentIcaTest();
		Data data = dataParent.getData();
		result[] results = data.getResult();
		
		for(int i=0;i<results.length;i++) {
			logger.info(results[i].getParent());
		}
		
		myService.writeToFile();
		myService.writeCSVFile();
	}


	
	
}


