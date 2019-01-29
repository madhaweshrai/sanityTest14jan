package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	static Properties pro;

	public static void configReader() {
		try {
            File src = new File("./propertyFiles/dataFile.properties");
			FileInputStream fls = new FileInputStream(src);
			pro = new Properties();
			pro.load(fls);

		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}

	}
	
	public static String getData(String Data)
	{
		configReader();
		String data = pro.getProperty(Data);
		return data;
		
		
	}
}
