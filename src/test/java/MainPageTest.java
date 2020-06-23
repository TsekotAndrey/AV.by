import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver chromeDriver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\main\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/");
        mainPage = new MainPage(chromeDriver);
    }
    @Test
    public void checkHeading2text() {
        String heading2 = mainPage.getHeadig2Test();
        Assert.assertEquals("ПОПУЛЯРНЫЕ МАРКИ АВТОМОБИЛЕЙ:", heading2);
    }
    @After
    public void tearDown() {
        chromeDriver.close();
    }
}