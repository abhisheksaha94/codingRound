import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void ShouldThrowAnErrorIfSignInDetailsAreMissing() {

        Utility.SetDriverPath();

        driver.get("https://www.cleartrip.com/");
        Utility.WaitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();

        driver.findElement(By.id("signInButton")).click();

        String searchError = Utility.GetElementTest("errors1","ID");
        Assert.assertTrue(searchError.contains("There were errors in your submission"));
        driver.quit();
    }


}
