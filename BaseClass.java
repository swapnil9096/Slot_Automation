package BaseMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	FileInputStream fis;
	public static Properties prop;
	public BaseClass() {
		String filename = System.getProperty("user.dir")+ "/src/main/resources/_config.properties";
		
		try {
			 fis = new FileInputStream(filename);
			 prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void init() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		}
			
		driver.get(prop.getProperty("url"));
		
		if(Boolean.parseBoolean(prop.getProperty("maximizeScreen")))
			driver.manage().window().fullscreen();
	}
	

}