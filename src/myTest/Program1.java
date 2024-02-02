package myTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.ITestNGListener;  // Import the ITestNGListener interface

import java.time.Duration;

@Listeners({MyTestListener.class})  // Correct usage with curly braces and an array
public class Program1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Dev\\\\Downloads\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://amazon.sg");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void verifyTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.sg: Shop Online for Electronics, Computers, Books, Toys, DVDs, Baby, Grocery, & more";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyLogo() {
        boolean flag = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


