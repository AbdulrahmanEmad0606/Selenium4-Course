import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Selenium4 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        System.out.println("Window Title : " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenNewWindow() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://automationpractice.com/index.php?controller=my-account");
        System.out.println("Window Title : " + driver.getTitle());
    }

    @Test
    public void testWorkingInBothWindowTab() {
        //Automatically open and switch to new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println("Window Title : " + driver.getTitle());
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@TAU.com");
        driver.findElement(By.id("SubmitCreate")).click();
        //Get the window id handle
        Set<String> allWindowsTabs = driver.getWindowHandles();
        Iterator<String> iterate = allWindowsTabs.iterator();
        String FirstWindow = iterate.next(); // to get the first opened window
        //Switch and work with the main opened tab
        driver.switchTo().window(FirstWindow);
        driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Window Title : " + driver.getTitle());
    }
}







