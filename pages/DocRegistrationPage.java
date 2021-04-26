package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class DocRegistrationPage {

    // Locators
    // Representative
    public SelenideElement fieldRepresentative = $(xpath("//input[@placeholder='поиск сотрудника']"));
    public SelenideElement btnRepresentative = $(xpath("//icon[@name='${createUpdateIcon}']//*[local-name()='svg']"));
    public SelenideElement listRepresentatives(String representative) {
        return $(xpath(String.format("//strong[contains(text(),'%s')]", representative)));
    }

    // Registration
    // Registration date field
    public SelenideElement registrationDateField = $(xpath("//input[@id='model_planned_issue_date']"));
    public SelenideElement registrationDateCalendarIcon = $(xpath("//input[@id='model_planned_issue_date']"));
    // Get message on email checkbox
    public SelenideElement checkboxGetMessagesOnEmail
            = $(xpath("//label[contains(text(),'получать уведомления на Email')]"));
    // Preview
    public SelenideElement previewButton = $(xpath("//button[contains(text(),'Предпросмотр')]"));
    public SelenideElement closePreviewButton = $(xpath("//button[contains(text(),'Закрыть')]"));
    // Registration button
    public SelenideElement btnRegistration = $(xpath("//button[contains(text(),'Зарегистрировать')]"));

    // Registration confirmation window
    public SelenideElement messageRegistrationConfirmed
            = $(xpath("//h5[contains(text(),'Обращение зарегистрировано')]"));
    public SelenideElement registrationId = $(xpath("//div[@class='row form-group']/div[2]"));
    public SelenideElement inputFile = $(xpath("//input[@type='file']"));
    public SelenideElement btnSendToWork = $(xpath("//button[contains(text(),'Отправить в работу')]"));

    // Statements page
    public SelenideElement statementID(String statement_id) {
        return $(xpath(String.format("//a[normalize-space()='%s']", statement_id)));
    }


    // Methods
    public void chooseRepresentative(String pattern, String representative) {
        fieldRepresentative.sendKeys(pattern);
        listRepresentatives(representative).click();
    }

    public String getDocumentId() {
        System.out.println(registrationId.getText());
        return registrationId.getText();
    }

    public void confirmRegistration() {
        messageRegistrationConfirmed.shouldBe(visible);
        inputFile.sendKeys("C:\\Testing\\Docs\\Test_doc.pdf");
        Selenide.sleep(1000);
        btnSendToWork.click();
    }
}
