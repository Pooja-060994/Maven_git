import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class Login_Page extends Utility {
	public Login_Page() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void login() throws InterruptedException
	{
		String var_one=prop.getProperty("LocNameLocValdata");
		sendData(var_one);
		String var_two=prop.getProperty("LocsNameLocVal");
		sendData(var_two);
		Thread.sleep(1000);
		String button=prop.getProperty("LoctNameLocVal");
		System.out.println(button);
		click_func(button);
		//Thread.sleep(12000);
		WebElement elm=driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		System.out.println(elm);
		driver.switchTo().frame(elm);
		String l_out=prop.getProperty("LocfoNameLocVal");
		System.out.println(l_out);
		click_func(l_out);
	}

}
