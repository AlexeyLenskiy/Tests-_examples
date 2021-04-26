package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class LkaIntegration {


    public SelenideElement integrationRequestType(String name) {
        return $(xpath(String.format("//tbody/tr[1]/td[2]/a[1][contains(text(),'%s')]", name)));
    }


}
