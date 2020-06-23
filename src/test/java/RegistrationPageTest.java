import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {
    private WebDriver chromeDriver;
    private RegistrationPage regPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\main\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/registration");
        regPage = new RegistrationPage(chromeDriver);
    }
    @Test
    public void CheckErrorMessageUnderFieldName() {
        RegistrationPage qqq = regPage.RegWithInvalidCreds("aaa", "dfgh", "788");
        String errorFieldName = qqq.getErrorFieldName();
        Assert.assertEquals("Напишите имя кириллицей", errorFieldName);
    }
    @Test
    public void CheckErrorMessageUnderFieldEmail() {
        RegistrationPage qqq = regPage.RegWithInvalidCreds("aaa", "dfgh", "788");
        String errorFieldEmail = qqq.getErrorFieldEmail();
        Assert.assertEquals("Введите почту полностью. Например, info@av.by", errorFieldEmail);
    }
    @Test
    public void CheckErrorMessageUnderFieldPassword() {
        RegistrationPage qqq = regPage.RegWithInvalidCreds("aaa", "dfgh", "788");
        String errorFieldPassword = qqq.getErrorFieldPassword();
        Assert.assertEquals("В пароле должны быть цифры и латинские буквы", errorFieldPassword);
    }
    @Test
    public void CheckFiguresCreds() {
        RegistrationPage qqq = regPage.RegWithFiguresCreds("1111", "11111", "1111111");
        String errorFieldEmail = qqq.getErrorFieldEmail();
        String errorFieldPassword = qqq.getErrorFieldPassword();
        String errorFieldName = qqq.getErrorFieldName();
        Assert.assertEquals("Напишите имя кириллицей", errorFieldName);
        Assert.assertEquals("В пароле должны быть цифры и латинские буквы", errorFieldPassword);
        Assert.assertEquals("Введите почту полностью. Например, info@av.by", errorFieldEmail);
    }
    @Test
    public void checkHeadingtext() {
        String headinReg = regPage.getHeadingReg();
        Assert.assertEquals("Регистрация", headinReg);
    }

    @After
    public void tearDown() {
        chromeDriver.close();
    }
}
