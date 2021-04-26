package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class LkaServicesPage {

    // Services drivers checkboxes
    public SelenideElement linkServiceDriver(String name) {
        return $(xpath(String.format("//a[contains(text(),'%s')]", name)));
    }
    public SelenideElement serviceDriverCheckbox(int number) {
        return $(xpath(String.format("//tbody/tr[%s]/td[4]/custom-switch[1]", number)));
    }
    public SelenideElement serviceDriversCheckboxes
            = $(xpath("//tbody/tr[1]/td[4]custom-switch[@class='au-target custom-control custom-switch']"));


    // Services menu
    public SelenideElement serviceMenuIcon(int number) {
        return $(xpath(String.format("//tbody/tr[%s]/td[5]/actions[1]", number)));
    }
    public SelenideElement serviceMenuOption(String name) {
        return $(xpath(String.format("//a[contains(text(),'%s')]", name)));
    }

}
