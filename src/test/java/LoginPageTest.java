import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseTest {
    private WebDriver chromeDriver;
    private LoginPage loginPage;


    @Before
    public void setUp()  {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/login");
        loginPage = new LoginPage(chromeDriver);
    }

    @Test
    public void loginWithInvalidCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("aaa", "dfgh");
        String error = newLoginPage.getErrorTest();
        Assert.assertEquals("Неверный логин или пароль. Если забыли пароль, восстановите его", error);
    }

    @Test
    public void loginWithFiguresCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithFiguresCredsTest("1111111", "1111111");
        String error = newLoginPage.getErrorTest();
        Assert.assertEquals("Неверный логин или пароль. Если забыли пароль, восстановите его", error);
    }

    @Test
    public void loginWithValidCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithValidCreds("andreytsekot@gmail.com", "p800w600100");
        String headingPopularCar = newLoginPage.getHeadingPopularCar();
        Assert.assertEquals("ПОПУЛЯРНЫЕ МАРКИ АВТОМОБИЛЕЙ:", headingPopularCar);
    }

    @Test
    public void checkHeadingtext() {
        String headingText = loginPage.getHeadigTest();
        Assert.assertEquals("Вход", headingText);
    }

    @After
    public void tearDown() {
        chromeDriver.close();
    }
}
