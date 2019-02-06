

import java.io.FileInputStream;



import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Utility {
	 public static WebDriver driver;
	public static By by=null;
	public static Properties prop =null;
	 public Utility() throws Throwable
	 {
		 String config_file_path=System.getProperty("user.dir")+"\\config\\config.properties";
		 FileInputStream fis=new FileInputStream(config_file_path);
		prop= new Properties();
		 prop.load(fis);
		 prop.getProperty("browser");
	 }
	public static void launch_Browser() throws Throwable
	{
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","D:\\Automated_Tools\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Automated_Tools\\geckodriver.exe");
			driver=new FirefoxDriver();
			Thread.sleep(1000);
			
		}
		else if(browser.equalsIgnoreCase("microsoft edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\Automated_Tools\\Drivers\\MicrosoftWebDriver (2).exe");
			driver=new EdgeDriver();
			}
		driver.manage().window().maximize();
			
	}
	public static void launch_App()
	{
		String app_Url=prop.getProperty("url");
		driver.get(app_Url);
	}
//	public static String locName,locVal;
	
	
	public static By locators(String a, String b)
	{
		switch(a)
		{
		case "id":
		by=By.id(b);
		break;
		case "name":
			by=By.name(b);
			break;
		case "linkText":
			by=By.linkText(b);
			break;
		case "partialLinkText":
		by=By.partialLinkText(b);
		break;
		case "xpath":
			by=By.xpath(b);
			break;
		case "cssSelector":
			by=By.cssSelector(b);
			break;
		case "tagName":
			by=By.tagName(b);
			break;
	}
		return by;
	}

	public static void sendData(String LocName_LocVal_data)
	{
		String []sa=LocName_LocVal_data.split("###");
		driver.findElement(locators(sa[0], sa[1])).sendKeys(sa[2]);
		
	}
	public static void click_func(String LocsName_LocVal)
	{
		
		String []sa=LocsName_LocVal.split("###");
		driver.findElement(locators(sa[0],sa[1])).click();
	}	
	public static int size;
	public static void get_Size(String LoctName_LocVal)
	{
		String []sa=LoctName_LocVal.split("###");
		size=driver.findElements(locators(sa[0],sa[1])).size();
		System.out.println(size);
	}
	public static void get_Text(String LoctName_LocVal)
	{
		String []sa=LoctName_LocVal.split("###");
		for(int i=0;i<size;i++)
		{
			click_func(LoctName_LocVal);
		String Head_Text=driver.findElements(locators(sa[0],sa[1])).get(i).getText();
		System.out.println(Head_Text);
		}
	}
	public static void click_link(String LocfoName_LocVal_AVal)
	{
		String []sa=LocfoName_LocVal_AVal.split("###");
		for(int i=0;i<size;i++)
		{
			click_func(LocfoName_LocVal_AVal);
		String Link_Text=driver.findElements(locators(sa[0],sa[1])).get(i).getAttribute(sa[2]);
		System.out.println(Link_Text);
		}
	}
	/*public static void i_frame(String var_iframe)
	{
		
		driver.switchTo().frame(frameElement)
		click_func(var_iframe);
	}*/
}
