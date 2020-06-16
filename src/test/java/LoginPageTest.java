import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
    private WebDriver chromeDriver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\main\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/");
        loginPage = new LoginPage(chromeDriver);
    }

    @Test
    public void loginWithInvalidCredsTest(){
        LoginPage newLoginPage = loginPage.LoginWithInvalidCreds("1","1");
        String error=newLoginPage.getErrorTest();
        Assert.assertEquals("Неверный логин или пароль. Если забыли пароль, восстановите его", error);
    }

    @After
    public void tearDown() {
        chromeDriver.close();
    }
}
