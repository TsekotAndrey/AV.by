import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver chromeDriver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\main\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/login");
        loginPage = new LoginPage(chromeDriver);
    }

    @Test
    public void loginWithInvalidCredsTest() {
        LoginPage newLoginPage = loginPage.LoginWithInvalidCreds("aaa", "dfgh");
        String error = newLoginPage.getErrorTest();
        Assert.assertEquals("Неверный логин или пароль. Если забыли пароль, восстановите его", error);
    }

    @Test
    public void loginWithFiguresCredsTest1() {
        LoginPage newLoginPage = loginPage.LoginWitInvalidCreds1("1111111", "1111111");
        String error = newLoginPage.getErrorTest();
        Assert.assertEquals("Неверный логин или пароль. Если забыли пароль, восстановите его", error);
    }

    @Test
    public void loginWithValidCredsTest() {
        LoginPage newLoginPage = loginPage.LoginWithValidCreds("andreytsekot@gmail.com", "p800w600100");
        String heading1 = loginPage.getHeadig1Test();
        Assert.assertEquals("ПОПУЛЯРНЫЕ МАРКИ АВТОМОБИЛЕЙ:", heading1);
    }

    @Test
    public void checkHeadingtext() {
        String heading = loginPage.getHeadigTest();
        Assert.assertEquals("Вход", heading);
    }

    @After
    public void tearDown() {
        chromeDriver.close();
    }
}
