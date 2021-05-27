package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import resources.*;

public class TestClass {

    static WebDriver driver;
    static DriversSetUp drivers;
    static BasePage basePage;


    @BeforeClass
    private void beforeAll(){
        drivers = new DriversSetUp();
        driver = drivers.getChromeDriverWindows();
        basePage = new BasePage(driver);

        driver.get("http://google.com");
    }

    @Test(description = "Default Test")
    void startTest(){
        System.out.println("Test");
    }

    @Test
    void secondTest(){
        System.out.println(1+4);
    }

    @AfterClass
    private void afterAll(){
        driver.close();
    }

}
