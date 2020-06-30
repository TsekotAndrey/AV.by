import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest extends BaseTest {
    private WebDriver chromeDriver;
    private RegistrationPage regisrationPage;

    @Before
    public void setUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://av.by/registration");
        regisrationPage = new RegistrationPage(chromeDriver);
    }
    @Test
    public void CheckErrorMessageUnderFieldName() {
        RegistrationPage newRegistrationPage = regisrationPage.registrationWithInvalidCreds("aaa", "dfgh", "788");
        String errorFieldName = newRegistrationPage.getErrorFieldName();
        Assert.assertEquals("Напишите имя кириллицей", errorFieldName);
    }
    @Test
    public void CheckErrorMessageUnderFieldEmail() {
        RegistrationPage newRegistrationPage = regisrationPage.registrationWithInvalidCreds("aaa", "dfgh", "788");
        String errorFieldEmail = newRegistrationPage.getErrorFieldEmail();
        Assert.assertEquals("Введите почту полностью. Например, info@av.by", errorFieldEmail);
    }
    @Test
    public void CheckErrorMessageUnderFieldPassword() {
        RegistrationPage newRegistrationPage = regisrationPage.registrationWithInvalidCreds("aaa", "dfgh", "788");
        String errorFieldPassword = newRegistrationPage.getErrorFieldPassword();
        Assert.assertEquals("В пароле должны быть цифры и латинские буквы", errorFieldPassword);
    }
    @Test
    public void CheckFiguresCreds() {
        RegistrationPage newRegistrationPage = regisrationPage.registrationWithFiguresCreds("1111", "11111", "1111111");
        String errorFieldEmail = newRegistrationPage.getErrorFieldEmail();
        String errorFieldPassword = newRegistrationPage.getErrorFieldPassword();
        String errorFieldName = newRegistrationPage.getErrorFieldName();
        Assert.assertEquals("Напишите имя кириллицей", errorFieldName);
        Assert.assertEquals("В пароле должны быть цифры и латинские буквы", errorFieldPassword);
        Assert.assertEquals("Введите почту полностью. Например, info@av.by", errorFieldEmail);
    }
    @Test
    public void checkHeadingtext() {
        String headingRegistrationPage = regisrationPage.getHeadingRegistration();
        Assert.assertEquals("Регистрация", headingRegistrationPage);
    }

    @After
    public void tearDown() {
        chromeDriver.close();
    }
}
