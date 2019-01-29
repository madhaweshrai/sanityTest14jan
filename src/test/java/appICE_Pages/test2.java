package appICE_Pages;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class test2 {
	
	@Test(groups={"1"})
	public void fun1()
	{

		Reporter.log("logging");
		System.out.println("sanity");
	}
	@Test(groups={"2"})
	public void fun2()
	{
		
		System.out.println("sanity2");
		
	}

}
