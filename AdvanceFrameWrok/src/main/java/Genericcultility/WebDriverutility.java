package Genericcultility;

import java.util.Set;

public class WebDriverutility extends BaseClass {
	public void switchingWindow(Set<String>allId) {
		for(String id:allId) {
			driver.switchTo().window(id);
		}
	}
	public static void switchingBackWindow(String Id) {
		driver.switchTo().window(Id);
	}
		public static void switchingToFrame(String frameRef) {
			try {
				driver.switchTo().frame(frameRef);
			}catch(Exception demo) {
				int index=Integer.parseInt(frameRef);
				driver.switchTo().frame(index);		
				}

		}
	}


