package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class AcceptPage {

    // Locators
    // Service type
    public SelenideElement fieldServices = $(xpath("//select[@id='model_subsidy']"));

    // Method type
    public SelenideElement fieldMethod = $(xpath("//select[@id='model_apply_method']"));

    // Applicant
    public SelenideElement fieldApplicant = $(xpath("//input[@placeholder='Поиск по названию / ИНН / ОГРН']"));
    public SelenideElement applicantList(String applicant) {
        return $(xpath(String.format("//strong[contains(text(),'%s')]", applicant)));
    }
    public SelenideElement fieldItem(String itemName) {
        return $(xpath(String.format("//option[contains(text(),'%s')]", itemName)));
    }

    public SelenideElement linkStatementType(String name) {
        return $(xpath(String.format("//div[@class='flex-grow-1 text-left' and contains(text(),'%s')]", name)));
    }

    // Tests
    public void searchApplicant(String pattern, String applicant) {
        fieldApplicant.sendKeys(pattern);
        applicantList(applicant).click();
    }

}
