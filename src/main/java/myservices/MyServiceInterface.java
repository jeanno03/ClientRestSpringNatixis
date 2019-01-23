package myservices;

import myEntities.DataParent;
import myEntities.MyUser;


public interface MyServiceInterface {
	
	public String getTest();
	public MyUser getMyUserTest() ;
	public DataParent getDataParentIcaTest() ;
	public void writeToFile();
	public void writeCSVFile();

}
