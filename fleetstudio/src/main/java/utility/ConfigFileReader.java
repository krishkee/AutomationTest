package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private static File config_file;
	private static FileInputStream fis;
	private static Properties pro;
	
	public static String readconfig(String key) throws IOException
	{
		config_file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\config\\config.properties");
		try {
			fis = new FileInputStream(config_file);
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
