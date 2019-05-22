import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver = new ChromeDriver();	

    @Test
    public void ShouldBeAbleToSearchForHotels() {
        Utility.SetDriverPath();

		Utility.WebNavigateTo("https://www.cleartrip.com/");
		
		Utility.SearchHotel("Indiranagar, Bangalore","Tue, 15 Oct, 2019","Fri, 18 Oct, 2019", "1 room, 2 adults");
		
		String searchResult = Utility.GetElementTest("//*[@id="area"]/section/div/div[2]/div[5]/section/div[1]/div/div[1]/span","Xpath");
        Assert.assertTrue(searchResult.contains("Showing properties by distance from"));
		
        driver.quit();
    }

}
