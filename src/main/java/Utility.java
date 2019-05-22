import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public static class Utility {

    WebDriver driver = new ChromeDriver();
	
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
	
	@FindBy(id = "CheckInDate")
	private WebElement checkInDate;
	
	@FindBy(id = "CheckOutDate")
	private WebElement checkOutDate;
	

    public static void WebNavigateTo(string _webAddress)
	{
		try
		{
			driver.get(_webAddress);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public static void WaitFor(int _durationInMilliSeconds) {
        try {
            Thread.sleep(_durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
	
	//Only for elements with search type as id or xpath
	public static string GetElementTest(string _idOrXpath, string _idOrXpathType)
	{
		if( _idOrXpathType.toLowerCase() == id)
		{
			return driver.findElement(By.id(_idOrXpath)).getText();
		}
		else if (_idOrXpathType.toLowerCase() == xpath)
		{
			return driver.findElement(By.xpath(_idOrXpath)).getText();
		}
		else
		{
			throw new IllegalArgumentException("No such type present" + _idOrXpathType);
		}
	}
	
	public static void SearchHotel(string _locality, string _checkInDate, string _checkOutDate, string _travellerSelection)
	{
		try
		{
			hotelLink.click();

			localityTextBox.sendKeys(_locality);
		
			checkInDate.sendKeys(_checkInDate);
		
			checkOutDate.sendKeys(_checkOutDate);
			
			new Select(travellerSelection).selectByVisibleText(_travellerSelection);
			searchButton.click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public static void WebClickButtonById(string _id)
	{
		try
			driver.findElement(By.id(_id)).click();
		catch (Exception e)
			System.out.println(e.message());
	}
	
	public static void WebEnterTextById(string _id, string text)
	{
		try{
			driver.findElement(By.id("_id")).clear();
			driver.findElement(By.id(_id)).sendKeys(text);
		}
		catch (Exception e)
			System.out.println(e.message());
	}
	
	public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
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
