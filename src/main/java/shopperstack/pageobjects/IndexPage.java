package shopperstack.pageobjects;

import org.testng.annotations.Test;

import shopperstack.base.BaseClass;

public class IndexPage extends  BaseClass {
	
	@Test
		public  void Index() {
		driver.get("https://www.shoppersstack.com");
	}
}
