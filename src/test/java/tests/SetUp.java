package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.*;

public class SetUp {
    @BeforeEach
    public void setup() {
        browser = "chrome";
        timeout = 10000;
        startMaximized = true;
        baseUrl = "http://some_url.ru/";
        Selenide.open(baseUrl);
    }

    // Tear down after each test
    @AfterEach
    public void closeMeth() {
        Selenide.closeWebDriver();
    }

    public void logIn() {
        Selenide.$(By.xpath("//input[@id='inputEmail']"))
                .sendKeys("some_login");
        Selenide.$(By.xpath("//input[@id='inputPassword']"))
                .sendKeys("some_password");
        Selenide.$(By.xpath("//button[contains(text(),'Войти')]")).click();
        Selenide.$(By.xpath("//strong[contains(text(),'Минприроды')]")).click();
    }

}
