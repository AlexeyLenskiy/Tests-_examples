package pages;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.By.xpath;
import static com.codeborne.selenide.Selenide.$;

public class FormConstructorPage {

    // Form list
    public SelenideElement linkFormBlank(String name) {
            return $(xpath(String.format("//a[normalize-space()='%s']", name)));
    }

    // Add new form
    public SelenideElement linkAddNewForm = $(xpath("//a[@class='btn btn-link au-target']"));

    // New form blank
    public SelenideElement fieldNewFormName = $(xpath("//input[@id='model_name']"));
    public SelenideElement fieldNewFormDescription = $(xpath("//textarea[@id='model_description']"));
    public SelenideElement fieldNewFormOrg = $(xpath("//input[@placeholder='Поиск по названию / ИНН / ОГРН']"));
    public SelenideElement optionsNewFormOrgSearch(String name) {
        return $(xpath(String.format("//strong[contains(text(),'%s')]", name)));
    }
    // Select document type
    public SelenideElement selectNewFormDocType = $(xpath("//div[6]//div[1]//select[1]"));
    // Select document form
    public SelenideElement selectNewFormDocTemplate = $(xpath("//div[7]//div[1]//select[1]"));
    // Additional fields forms
    public SelenideElement newFormDragElement(int num) {
        return $(xpath(String.format("//div[@id='clbSidePanel']//div[%s]", num)));
    }
    public SelenideElement newFormDropField
            = $(xpath("//div[@class='options-holder insertable au-target moveable']"));

    // Methods
    // Adding new form
    public void chooseNewFormOrganisation(String pattern, String name) {
        fieldNewFormOrg.sendKeys(pattern);
        optionsNewFormOrgSearch(name).click();
    }

    public void selectNewFormDocOptions(String type, String template) {
        selectNewFormDocType.selectOption(type);
        selectNewFormDocTemplate.selectOption(template);
    }

}
