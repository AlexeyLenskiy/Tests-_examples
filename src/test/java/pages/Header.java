package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class Header {

    // Locators
    // Logo
    public SelenideElement headerLogo = $(xpath("//img[@class='d-none d-md-inline']"));

    // Operator navbar links locators
    public SelenideElement acceptLink = $(xpath("//li[@id='link-accept']"));
    public SelenideElement myTasksLink = $(xpath("//a[contains(text(),'Мои задачи')]"));
    public SelenideElement issueLink = $(xpath("//a[contains(text(),'Выдача')]"));

    // Administrator navbar links locators
    // Settings
    public SelenideElement settingsLink = $(xpath("//li[@id='link-services']"));
    public SelenideElement settingsMenu = $(xpath("//div[@class='au-target dropdown-menu show']"));

    // Integration
    public SelenideElement integrationLink = $(xpath("//li[@id='link-integration']"));
    public SelenideElement integrationLinkItems(String name) {
        return $(xpath(String.format("//div[@class='au-target dropdown-menu show']" +
                "//a[contains(text(),'%s')]", name)));
    }

    // Drop menu items
    public SelenideElement menuItems(String name) {
        return $(xpath(String.format("//a[contains(text(), '%s')]", name)));
    }

    // Search field
    public SelenideElement searchField = $(xpath("//input[@placeholder='Быстрый поиск']"));

    // Menu button
    public SelenideElement menuButton = $(xpath("//div[@class='nav-link']"));

    // Menu items
    public SelenideElement menuChangeOrgLink = $(xpath("//a[contains(text(),'Сменить организацию')]"));
    public SelenideElement menuGoToLKA = $(xpath("//a[contains(text(),'Перейти в ЛКА')]"));
    public SelenideElement menuGoToLKO = $(xpath("//a[contains(text(),'Перейти в ЛКО')]"));
    public SelenideElement menuUserSettings = $(xpath("//a[contains(text(),'Настройки пользователя')]"));
    public SelenideElement menuQitButton = $(xpath("//a[contains(text(),'Настройки пользователя')]"));

    // Organisation names
    public SelenideElement changeOrgName(String name) {
        return $(xpath(String.format("//strong[contains(text(),'%s')]", name)));
    }


    // Tests
    public void goToLKO() {
        menuButton.click();
        menuGoToLKO.click();
        Selenide.refresh();
    }

    public void goToLKA() {
        menuButton.click();
        menuGoToLKA.click();
        Selenide.refresh();
    }

    public void clickAcceptLink() {
        acceptLink.click();
        Selenide.refresh();
    }

    public void chooseLkaSetting(String name) {
        settingsLink.click();
        menuItems(name).click();
        Selenide.refresh();
    }

    public void chooseLkaIntegration(String name) {
        integrationLink.click();
        integrationLinkItems(name).click();
        Selenide.refresh();
    }

    public void changeOrganisation(String name) {
        menuButton.click();
        menuChangeOrgLink.click();
        changeOrgName(name).click();
    }

}
