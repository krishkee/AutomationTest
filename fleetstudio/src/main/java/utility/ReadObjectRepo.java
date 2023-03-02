package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadObjectRepo {
	
	static File ob;
	static FileInputStream fis;
	static Properties pro;
	
	public static String getLocators(String key) throws IOException
	{
		ob = new File (System.getProperty("user.dir")+"\\src\\main\\resources\\locators\\objectrepo.properties");
		try {
			fis = new FileInputStream(ob);
			pro = new Properties();
			pro.load(fis);
			return pro.getProperty(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
