import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest extends BaseTest {
    private WebDriver chromeDriver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/");
        mainPage = new MainPage(chromeDriver);
    }
    @Test
    public void checkHeading2text() {
        String heading = mainPage.getHeadigTest();
        Assert.assertEquals("ПОПУЛЯРНЫЕ МАРКИ АВТОМОБИЛЕЙ:", heading);
    }
    @After
    public void tearDown() {
        chromeDriver.close();
    }
}