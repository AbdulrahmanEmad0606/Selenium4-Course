import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    WebDriver driver;
    @BeforeMethod
    public void setUpFireFox(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");
    }
    @Test
    public void TakeScreenShotToElement() throws IOException {
        WebElement element=driver.findElement(By.cssSelector("#post-8 h1"));
        File source = element.getScreenshotAs(OutputType.FILE);
        File destination = new File("header.png");
        FileUtils.copyFile(source, destination);
    }
}
