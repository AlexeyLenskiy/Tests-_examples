package pages;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.By.xpath;
import static com.codeborne.selenide.Selenide.$;

public class SideMenu {

    // Side menu registries
    // Common registries
    public SelenideElement linkApplicantsRegistry
            = $(xpath("//nav-group[@header='Общие реестры']//nav[@class='nav flex-column']/a[2]"));
    public SelenideElement linkLicensesRegistry = $(xpath("//nav-group[1]//nav[1]//a[5]"));

    // Users registries
    public SelenideElement linkAdNewUserRegistries = $(xpath("//icon[@name='${icon}']"));
    public SelenideElement linkUsersRegistries(String name) {
        return $(xpath(String.format("//span[normalize-space()='%s']", name)));
    }

    // Analytics field
    public SelenideElement linkAnalyticsPlatform = $(xpath("//a[@route-href='route: analytical_platform_reports']"));

}
