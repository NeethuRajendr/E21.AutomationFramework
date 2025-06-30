package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * This class consist of generic methods related to specific
 * @author NR
 */

public class JavaUtility {

	
	/**
	 * This method will capture the current system date and return to caller
	 * @return date
	 */
	public String getSystemDate()	//screenshotName, reportName
	{
		Date d = new Date();	// 04 June 2025 Wednesday IST 12:54:28
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
	}
	
	
}
