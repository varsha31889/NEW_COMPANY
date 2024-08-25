package QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QA_AUTOMATION {

	WebDriver driver;                 // if driver will not taken then write this line 
	@BeforeClass
    public void setUp() {
        
        System.setProperty("webdriver.chrome.driver", "chromedriver-win64/chromedriver.exe");

       
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        
        driver.get("https://flipkart.com"); 
    }

    @Test
    public void testSearchFunctionality() {
        
        WebElement searchBox = driver.findElement(By.id("searchBox"));

        String searchTerm = "Selenium";
        searchBox.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.id("searchButton"));

   
        searchButton.click();

 
        WebElement resultsArea = driver.findElement(By.id("results"));

      
        String expectedResult = "Results for 'Selenium'";

        String actualResult = resultsArea.getText();

    
        Assert.assertEquals(actualResult, expectedResult, "The search results are not as expected.");
    }

    @AfterClass
    public void tearDown() {
     
        driver.quit();
    }

}
