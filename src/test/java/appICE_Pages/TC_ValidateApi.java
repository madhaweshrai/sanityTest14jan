package appICE_Pages;

import org.testng.annotations.Test;

import appICE_PageObject_Classes.Element_APivalidation;
import appICE_PageObject_Classes.ValidateApi;
import baseClasses.MultiBrowsers;

public class TC_ValidateApi extends MultiBrowsers{
	
	
	@Test
	public void initialisecheck()
	{
			// //table[@id='tblUsers']//tr
             
              
              ValidateApi api = new ValidateApi(wdriver);
	}

}
