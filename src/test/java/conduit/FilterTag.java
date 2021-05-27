package conduit;

import main.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.BasePage;
import resources.DriversSetUp;

public class FilterTag {

    static WebDriver driver;
    static DriversSetUp drivers;
    static BasePage basePage;
    static MainPage mainPage;


    @BeforeClass
    private void beforeAll(){
        drivers = new DriversSetUp();
        driver = drivers.getChromeDriverWindows();
        basePage = new BasePage(driver);

        mainPage = new MainPage(driver);
        driver.get("https://demo.realworld.io/#/");
        basePage.waitForPageLoaded();
    }

    @Test()
    void filterByTag(){
        String tagName = "HITLER";

        mainPage.waitUntilArticlesView();
        mainPage.filterByTag(tagName);
        if(mainPage.isTagTabPresent(tagName)){
            mainPage.waitUntilArticlesView();
            mainPage.isArticlesInTableOnlyWithTag(tagName);
        }
    }

    @AfterClass
    private void afterAll(){
        driver.close();
    }


}
