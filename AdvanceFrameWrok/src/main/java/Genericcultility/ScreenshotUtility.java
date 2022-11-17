package Genericcultility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtility extends BaseClass implements IautoConstant {


public static String takingScreenshot(String screenshotName) throws IOException {
	TakesScreenshot Screenshot=(TakesScreenshot) driver;
	 File photo = Screenshot.getScreenshotAs(OutputType.FILE);
	 String idt = LocalDateTime.now().toString().replace(':', '-');
	 String destination = System.getProperty("user.dir")+ERRORSHOTS+screenshotName+" "+idt+".png";
	 
	 File dest=new File("destination");
	 
	 FileUtils.copyFile(photo, dest);
	 return destination;
}
	
	}


