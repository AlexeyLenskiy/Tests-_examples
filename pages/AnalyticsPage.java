package pages;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.By.xpath;
import static com.codeborne.selenide.Selenide.$;

public class AnalyticsPage {

    // Add new report
    public SelenideElement btnAddReport = $(xpath("//a[contains(text(),'Добавить отчет')]"));

    // New report form
    public SelenideElement fieldNewReportName = $(xpath("//input[@id='form_name']"));
    // Report visualisation forms
    public SelenideElement radioNewReportVisualisationForm(String name) {
        return $(xpath(String.format("//label[contains(text(),'%s')]", name)));
    }

    // Report access role
    public SelenideElement selectNewReportAccessRole = $(xpath("//select[@id='form_role_ids']"));
    public SelenideElement selectNewReportAccessUser = $(xpath("//select[@id='form_user_ids']"));
    public SelenideElement optionNewReportAccessUser(String name) {
        return $(xpath(String.format("//option[contains(text(),'%s')]", name)));
    }

    // Add visible data button
    public SelenideElement btnAddVisibleData = $(xpath("//button[@class='btn btn-white au-target']"));
    // New data screen
    public SelenideElement fieldAddDataName = $(xpath("//input[@value.bind='form.name']"));
    public SelenideElement selectAddDataType = $(xpath("//ux-dialog-body/div[2]/div[1]/select[1]"));
    public SelenideElement radioAddDataPeriod(int num) {
        return $(xpath(String.format("//ux-dialog-body//custom-radio[@class='au-target']//div[%s]", num)));
    }
    public SelenideElement selectAddDataDocType = $(xpath("//ux-dialog-body/div[5]/div[1]/select[1]"));
    public SelenideElement selectAddDataDocTemplate = $(xpath("//ux-dialog-body/div[6]/div[1]/select[1]"));
    public SelenideElement selectAddDataDocStatus = $(xpath("//ux-dialog-body/div[7]/div[1]/select[1]"));
    public SelenideElement selectAddDatApplicantType = $(xpath("//ux-dialog-body/div[8]/div[1]/select[1]"));
    public SelenideElement selectAddDataApplicationMethod = $(xpath("//ux-dialog-body/div[9]/div[1]/select[1]"));
    public SelenideElement selectAddDataDocCreatedBy = $(xpath("//ux-dialog-body/div[10]/div[1]/select[1]"));
    // Close/save buttons
    public SelenideElement btnAddDataClose = $(xpath("//ux-dialog-footer[@class='au-target']" +
            "//button[contains(text(),'Закрыть')]"));
    public SelenideElement btnAddDataSave = $(xpath("//ux-dialog-footer[@class='au-target']" +
            "//button[contains(text(),'Сохранить')]"));

    // Create report button
    public SelenideElement btnCreateReport = $(xpath("//button[contains(text(),'Создать')]"));
    // Continue edition button
    public SelenideElement btnContinueEdition
            = $(xpath("//button[contains(text(),'Продолжить редактирование')]"));
    // Go to reports list button
    public SelenideElement btnGoToReportsList = $(xpath("//button[contains(text(),'Перейти в список')]"));


    // Reports Lis
    public SelenideElement linkReportTitle(String name) {
        return $(xpath(String.format("//span[contains(text(),'%s')]", name)));
    }

}



