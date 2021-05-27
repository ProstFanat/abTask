package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import resources.BasePage;

import java.util.List;

import static java.lang.Thread.sleep;

public class MainPage extends BasePage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(), 'Global Feed')]")
    private WebElement tabGlobalFeed;

    @FindBy(xpath = "//article-list")
    private WebElement articleList;

    @FindBy(xpath = "//article-preview")
    public List<WebElement> articles;

    @FindBy(xpath = "//ul[@class = 'pagination']//li//a")
    public List<WebElement> paginationPages;

    public void waitUntilArticlesView(){

        waitToVisibilityOf(10000, articleList);
    }

    public void filterByTag(String tagName){
        driver.findElement(By.xpath("//*[@ng-bind = 'tagName'][text() = '" + tagName + "']")).click();
    };

    public boolean isTagTabPresent(String tagName){
        return driver.findElement(By.xpath("//*[contains(text(), '" + tagName + "')]")).isDisplayed();
    }

    public void isArticlesInTableOnlyWithTag(String tagName){
        for(int j = 1; j <= paginationPages.size(); j++) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            driver.findElement(By.xpath("//ul[@class = 'pagination']//li[" + j + "]//a")).click();
            waitUntilArticlesView();
            for (int i = 1; i <= articles.size(); i++) {
                Assert.assertTrue(driver.findElement(By.xpath("//article-preview[" + i + "]//ul[@class = 'tag-list']//li[contains(text(), '" + tagName + "')]")).isDisplayed());
            }
        }
    }

}
