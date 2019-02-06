import org.testng.annotations.Test;

public class Test_Ng_Class extends Login_Page{

	public Test_Ng_Class() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public static void login_method() throws Throwable
	{
		launch_Browser();
		launch_App();
		login();
	}

}
