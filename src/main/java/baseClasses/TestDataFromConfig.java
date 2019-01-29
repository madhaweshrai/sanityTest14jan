package baseClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TestDataFromConfig {

	private String fileLocation;

	public TestDataFromConfig(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public HashMap<String, String[]> getData() {
	//	FileInputStream fs;
		HashMap<String, String[]> keyValuePair = new HashMap<String, String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
			String stringLine;
			// Read File Line By Line
			while ((stringLine = br.readLine()) != null) {
				// Print the content on the console
				String[] keyValue = stringLine.split("=");
				keyValuePair.put(keyValue[0], keyValue[1].split("-"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return keyValuePair;

	}

}
