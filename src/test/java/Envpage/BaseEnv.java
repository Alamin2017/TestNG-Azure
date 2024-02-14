package Envpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.utils_task;
import java.time.Duration;
public class BaseEnv {
    public static WebDriver driver;
    @BeforeMethod
    public void setup()
    {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @AfterMethod
    public void screenShot(ITestResult result){
        String testName=result.getName();
        if(ITestResult.FAILURE==result.getStatus()) {
            try
            {
                utils_task utils=new utils_task(driver);
                utils.takeScreenshotForFailure(driver,testName);
            }
            catch (Exception exception)
            {
                System.out.println(exception.toString());
            }
        }
        else
        {
            try
            {
                utils_task utils=new utils_task(driver);
                utils.takeScreenshotForSuccess(driver,testName);
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        driver.close();
    }
}
