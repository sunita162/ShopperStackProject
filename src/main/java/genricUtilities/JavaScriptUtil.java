package genricUtilities;


	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class JavaScriptUtil {

		private JavascriptExecutor javaScript;
		
		public JavaScriptUtil(WebDriver driver) {
			javaScript = (JavascriptExecutor) driver;
		}
		
		 //This method is used to perform Click operation using JavascriptExecutor
		public void jsClick(WebElement element) {
			javaScript.executeScript("arguments[0].click();", element);
		}

		
		 //This method is used to send the data to a text filed using JavascriptExecutor
		public void jsSendkeys(String data,WebElement element) {
			javaScript.executeScript("arguments[0].value='"+data+"';", element);
		}
		
		// This method is used to perform scrolling action in X and Y direction using JavascriptExecutor
		// x pass the X pixels value (distance in X direction)
		 //  y pass the Y pixels value (distance in Y direction)
		 
		public void jsScrollBy(int X,int Y) {
			javaScript.executeScript("window.scrollBy("+X+","+Y+")");
		}
		// This method is used to perform scrolling action to a particular coordinate values using JavascriptExecutor
		 // X give the X-coordinate value
		 // Y give the Y-coordinate value
		 
		public void jsScrollTo(int X,int Y) {
			javaScript.executeScript("window.scrollTo("+X+","+Y+")");
		}
		// This method is used to scroll upto an element 
		 // bool if given true it will match the top of the element to top of the page and vice versa
		 // element upto which you want to scroll
		 
		public void jsScrollIntoView(boolean bool,WebElement element) {
			javaScript.executeScript("arguments[0].scrollIntoView("+bool+")",element);
		}

		//Used to scroll to the bottom of the page
		 
		public void jsScrollToBottomOfThePage() {
			javaScript.executeScript("arguments[0].scrollBy(0,document.body.scrollHeight')");
		}
		
		//Used to get the value present in the text box using JavascriptExecutor
		 // element text box element
		 //return the text present in the text box
		 
		public String jsFetchVale(WebElement element) {
			return (String)javaScript.executeScript("return arguments[0].value",element);
		}	
		
		 //Used to refresh the page 
		 
		public void jsRefresh() {
			javaScript.executeScript("history.go(0)");
		}
		
		//Used to clear the content in the text area using JavascriptExecutor
		  //element text box element
		
		public void jsClear(WebElement element) {
			javaScript.executeScript("arguments[0].vlue='';",element);
		}
	}



