package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderPractice {

	@Test(dataProvider = "customerinfo")
	public void createCustomer(String cname, int cid)
	{
		//name, id -- run multiple times, different data
		//multiple customer in single execution
		System.out.println("Customer Name : "+cname);
		System.out.println("Customer ID : "+cid);	
	}
	
	//stock your data
	
	@DataProvider(name = "customerinfo") //rows and columns
	public Object[][] getData() // 4 set of Data and each set has 2 info
	{

		Object[][] data =  new Object[4][2];
		
		//First set of Data
		data[0][0] = "Gita";
		data[0][1] = 14;
		
		//Second set of Data
		data[1][0] = "Sita";
		data[1][1] = 16;
				
		//Third set of Data
		data[2][0] = "Rita";
		data[2][1] = 18;
				
		//Fourth set of Data
		data[3][0] = "Nita";
		data[3][1] = 20;
		
	
		return data;
		
		
	
	}

}
