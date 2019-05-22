import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public static class Utility {

    WebDriver driver = new ChromeDriver();

    public static void WebNavigateTo(string webAddress)
	{
		try
		{
			driver.get(webAddress);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public static void WaitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
	
	//Only for elements with search type as id or xpath
	public static string GetElementTest(string idOrXpath, string idOrXpathType)
	{
		if( idType.toLowerCase() == id)
		{
			return driver.findElement(By.id(idOrXpath)).getText();
		}
		else if (idType.toLowerCase() == xpath)
		{
			return driver.findElement(By.xpath(idOrXpath)).getText();
		}
		else
		{
			throw new IllegalArgumentException("No such type present" + idOrXpathType);
		}
	}

    public static void SetDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }


}
