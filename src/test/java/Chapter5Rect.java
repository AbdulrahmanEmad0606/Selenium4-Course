import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Chapter5Rect {
    WebDriver driver;

    @BeforeMethod
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationu.applitools.com/learningpaths.html?id=web-ui-java-path");
        driver.manage().window().maximize();
    }

    @Test
    public void getRectOfLogo() {
        WebElement el = driver.findElement(By.xpath("//div[@id='app']//header/a/img"));
        Rectangle rect = el.getRect();
        System.out.println("X : "+rect.getX());
        System.out.println("Y : "+rect.getY());
        System.out.println("Height : "+rect.getHeight());
        System.out.println("Width : "+rect.getWidth());
    }
}
