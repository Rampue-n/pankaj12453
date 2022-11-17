package Genericcultility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyMainUtility {
public static String PropertyReader(String KeyValue) throws IOException {
	FileInputStream fis=new FileInputStream("./srs/test/resource/TestData/PropertyFile.properties");
	Properties property=new Properties();
	property.load(fis);
	String Value=property.getProperty(KeyValue);
	
	
	return Value;
	
}
}
