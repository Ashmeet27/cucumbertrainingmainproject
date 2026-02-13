package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {
public static WebDriver driver;
	
	public String getUrl() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream("C:\\Users\\Ashmeet.Kaur\\eclipse-workspace\\cucumberprojectfortraining1\\src\\main\\java\\data.properties"));
		return prop.getProperty("url");
	}

}
