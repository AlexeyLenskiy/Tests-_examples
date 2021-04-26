package pages;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.By.xpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistriesPage {

    // Users registries
    // Add new users registry
    public SelenideElement radioNewUsersRegistriesType(String name) {
        return $(xpath(String.format("//label[contains(text(),'%s')]", name)));
    }
    public SelenideElement fieldNewUsersRegistryName = $(xpath("//input[@id='model_name']"));
    public SelenideElement fieldNewUsersRegistryDescription = $(xpath("//textarea[@id='model_description']"));
    public SelenideElement btnNewUsersRegistrySave = $(xpath("//button[contains(text(),'Сохранить')]"));


    // New registry filters
    public SelenideElement selectNewUsersRegistryType = $(xpath("//select[@id='model_subsidy']"));
    public SelenideElement selectNewUsersRegistryServicesFilter = $(xpath("//select[@id='model_subsidy']"));
    public SelenideElement selectNewUsersRegistryArchiveFilter = $(xpath("//div[@class='form-group row']" +
            "//div//select[@id='filter_is_complete']"));
    public SelenideElement dateNewUsersRegistryFromFilter = $(xpath("//input[@id='model_date_to']"));
    public SelenideElement dateNewUsersRegistryTillFilter
            = $(xpath("//date-range-select[@class='au-target input-group']//input[@title='по дату']"));
    public SelenideElement selectNewUsersRegistryApplicationTypeFilter
            = $(xpath("//div[@class='form-group row']//div//select[@id='filter_apply_method']"));
    public SelenideElement selectNewUsersRegistryStatusFilter
            = $(xpath("//div[@class='form-group row']//div//select[@id='filter_state']"));


    // Registries list
    // Registries names
    public SelenideElement linkRegistryName(String name) {
        return $(xpath(String.format("//a[@class='au-target'][normalize-space()='%s']", name)));
    }
    // Registry page
    public SelenideElement optionsRegistryPageFilters(String option) {
        return $(xpath(String.format("//option[contains(text(),'%s')]", option)));
    }
    public SelenideElement dateRegistryPageTimeFrom = $(xpath("//input[@title='по дату']"));
    public SelenideElement dateRegistryPageTimeTo = $(xpath("//input[@id='filter_applied_at']"));


    // Applicants registries
    public SelenideElement linkApplicantRegistry(String name) {
        return $(xpath(String.format("//a[contains(text(),'%s')]", name)));
    }
    // Search field
    public SelenideElement fieldApplicantName = $(xpath("//input[@id='filter_name']"));
    public SelenideElement textApplicantLegalAddress = $(xpath("/entity-view[@class='au-target']/div[11]/div[2]"));
    // Edit registries page
    public SelenideElement linkEditRegistries = $(xpath("//a[contains(text(),'редактировать')]"));
    // Edit applicants registries screen
    public SelenideElement fieldApplicantLegalAddress = $(xpath("//input[@id='model_legal_address']"));
    public SelenideElement optionsApplicantsLegalAddress(int number) {
        return $(xpath(String.format("//router-view[@class='au-target']//li[%s]", number)));
    }
    public SelenideElement btnSaveRegistry = $(xpath("//button[contains(text(),'Сохранить')]"));


    // Change registry license status
    public SelenideElement btnChangeLicenseStatus = $(xpath("//icon[@name='plus']//*[local-name()='svg']"));
    // Change status window
    public SelenideElement selectLicenseStatusChange = $(xpath("//select[@class='au-target custom-select']"));
    public SelenideElement fieldLicenseStatusChangeCause
            = $(xpath("//textarea[@class='au-target form-control custom-textarea']"));
    public SelenideElement dateLicenseStatusChange = $(xpath("//input[@type='date']"));
    public SelenideElement loadLicenseStatusChangeDocLoad = $(xpath("//icon[@def.one-time='attachIcon']" +
            "//*[local-name()='svg']//*[name()='path' and contains(@fill,'currentCol')]"));
    public SelenideElement btnLicenseStatusChangeSave = $(xpath("//button[contains(text(),'Сохранить')]"));
    public SelenideElement btnLicenseStatusChangeCancel = $(xpath("//button[contains(text(),'Отмена')]"));

    // Status change cards
    public SelenideElement textLicenseChangeCause(String text) {
        return $(xpath(String.format("//p[contains(text(),'%s')]", text)));
    }
    public SelenideElement textLicenseChangedStatus = $(xpath("//div[@id='timeline']//div[2]//div[2]//h4"));


}
