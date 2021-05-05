package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import resources.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestClass {

    static WebDriver driver;
    static BasePage basePage;

    @BeforeClass
    private void beforeAll(){
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//        driver = new ChromeDriver();
        open("http://google.com");
        driver = getWebDriver();
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
