package appICE_Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClasses.MultiBrowsers;
import net.sf.json.JSONObject;
import superPageObject_Classes.Apps_HomePage;
import superPageObject_Classes.AppICE_Home_Login_Pages;
import superPageObject_Classes.Panel_Page;

public class Install_API_DemoApp extends MultiBrowsers
{
	@Test
	public void installsWithAPI() throws InterruptedException{
		Panel_Page pp = new Panel_Page(wdriver);
		pp.loginbutton();
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.credencials("admin@semusi.com", "password");
		Apps_HomePage hp = new Apps_HomePage(wdriver);
		/*new DemoApp_DashBoard();*/
		hp.demoApp(wdriver);
		try {
			URL url = new URL(
					"https://panel.appice.io/o/metrices/getTotalStats?callback=jQuery19108586557654813183_1477636156780&args=%7B%22startDate_C%22%3A1475087400%2C%22endDate_C%22%3A1477679399.999%2C%22startDate_P%22%3A1472495400%2C%22endDate_P%22%3A1475087399.999%2C%22startDate_CNew%22%3A%222016-09-29%22%2C%22endDate_CNew%22%3A%222016-10-28%22%2C%22startDate_PNew%22%3A%222016-08-30%22%2C%22endDate_PNew%22%3A%222016-09-28%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=56740ceb566583c105000001&_=1477636156781");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
			}

			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();

			System.out.println("Response is  : " + entireResponse);

			scan.close();
			entireResponse = entireResponse.substring(entireResponse.indexOf("{"), entireResponse.length() - 1);
            JSONObject obj = new JSONObject();
			obj.getJSONArray("current");
			String uniqueInstalls = String.valueOf(obj.get("totalUniqueInstall"));
			System.out.println(uniqueInstalls);
			WebElement ele1 = wdriver.findElement(By.xpath(".//*[@id='uniqueInstalls']"));
			String uniqueInstalls1 = ele1.getText();
			System.out.println(uniqueInstalls1);
			
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
