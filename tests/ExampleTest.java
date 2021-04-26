package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.data.DataRegistries;
import pages.data.DataServices;
import pages.data.DataSettings;

import java.util.Random;
import static com.codeborne.selenide.Condition.*;


public class ExampleTest extends SetUp {
    Random random = new Random();
    int rnd = random.nextInt(1000);

    @Test
    // Checking new Ministry of healthcare statement creation
    public void testCase1_1_1() {
        // AIS Rosszdravnadzor services
        // Go to LKA
        logIn();
        Header header = new Header();
        header.chooseLkaSetting(DataSettings.getAdminSettingItem(7));
        LkaServicesPage lkaServicesPage = new LkaServicesPage();
        // Check that drivers is on LKA/Settings/Services page
        lkaServicesPage.linkServiceDriver(DataServices.getMedServices(0)).shouldBe(visible);
        lkaServicesPage.linkServiceDriver(DataServices.getMedServices(1)).shouldBe(visible);
        lkaServicesPage.linkServiceDriver(DataServices.getMedServices(2)).shouldBe(visible);
        // Change organisation to Ministry of nature
        header.changeOrganisation(DataServices.getMinistryTypes(1));
        // Creating new Ministry of nature statement
        header.goToLKO();
        header.clickAcceptLink();
        AcceptPage acceptPage = new AcceptPage();
        acceptPage.fieldServices.selectOption(DataServices.getMedServices(0));
        acceptPage.fieldMethod.selectOption(1);
        acceptPage.fieldApplicant.click();
        acceptPage.searchApplicant("тестовая", "ООО Тестовая организация");
        acceptPage.linkStatementType(DataRegistries.getStatementsTypes(0)).click();
        DocRegistrationPage docRegistrationPage = new DocRegistrationPage();
        docRegistrationPage.chooseRepresentative("иванов", "Иванов Иван");
        docRegistrationPage.checkboxGetMessagesOnEmail.click();
        docRegistrationPage.btnRegistration.click();
        String statementID = docRegistrationPage.getDocumentId();
        docRegistrationPage.confirmRegistration();
        docRegistrationPage.statementID(statementID).shouldBe(visible);
        // Check created statement request on LKA integration/requests page
        header.goToLKA();
        header.chooseLkaIntegration("Запросы");
        LkaIntegration lkaIntegration = new LkaIntegration();
        lkaIntegration.integrationRequestType(DataServices.getMedServices(0)).shouldBe(visible);
    }

    @Test
    // Checking statement status changes
    public void testCase1_2_3() {
        // Selecting license in Side menu/License registry
        logIn();
        Header header = new Header();
        header.changeOrganisation(DataServices.getMinistryTypes(1));
        header.goToLKO();
        SideMenu sideMenu = new SideMenu();
        sideMenu.linkLicensesRegistry.click();
        RegistriesPage registriesPage = new RegistriesPage();
        registriesPage.linkRegistryName(
                "Тестовая лицензия 3").click();
        registriesPage.btnChangeLicenseStatus.click();
        //registriesPage.selectLicenseStatusChange.click();
        registriesPage.selectLicenseStatusChange.selectOption(2);
        registriesPage.fieldLicenseStatusChangeCause.sendKeys("тест " + rnd);
        registriesPage.btnLicenseStatusChangeSave.click();
        registriesPage.textLicenseChangedStatus.shouldHave(text("Изменение статуса: Действующий"));
        registriesPage.textLicenseChangeCause("тест " + rnd).shouldBe(visible);
    }

    @Test
    // Checking FIAS module integration
    public void testCase2() {
        // FIAS module integration check
        logIn();
        SideMenu sideMenu = new SideMenu();
        sideMenu.linkApplicantsRegistry.click();
        RegistriesPage registriesPage = new RegistriesPage();
        registriesPage.fieldApplicantName.sendKeys("тестовая");
        registriesPage.linkApplicantRegistry("ООО Тестовая организация").click();
        registriesPage.linkEditRegistries.click();
        registriesPage.fieldApplicantLegalAddress.clear();
        registriesPage.fieldApplicantLegalAddress.sendKeys("калининград заставы 21");
        registriesPage.optionsApplicantsLegalAddress(1).click();
        registriesPage.btnSaveRegistry.click();
        registriesPage.textApplicantLegalAddress
                .shouldHave(text("Калининградская область, Калининград, улица Заставы, д. 21"));
    }

    @Test
    // Checking new additional form creation
    public void testCase3_1() {
        // Creating new additional form
        logIn();
        Header header = new Header();
        header.changeOrganisation(DataServices.getMinistryTypes(1));
        header.chooseLkaSetting("Дополнительные формы");
        FormConstructorPage formConstructorPage = new FormConstructorPage();
        formConstructorPage.linkAddNewForm.click();
        formConstructorPage.fieldNewFormName.sendKeys("Тестовая форма " + rnd);
        formConstructorPage.fieldNewFormDescription.sendKeys("Описание новой тестовой формы");
        formConstructorPage.chooseNewFormOrganisation(DataServices.getMinistryTypes(1),
                DataServices.getMinistryTypes(1));
        formConstructorPage.selectNewFormDocOptions(DataSettings.getDocumentTypes(1)
               , DataSettings.getDocumentTemplatesType(1));
        // Drag and drop new fields
        for (int i = 1; i < 11; i++) {
            formConstructorPage.newFormDragElement(i).dragAndDropTo(formConstructorPage.newFormDropField); }
        // Click on new fields
        for (int i = 1; i < 11; i++) { formConstructorPage.newFormDragElement(i).click(); }
        header.chooseLkaSetting("Дополнительные формы");
        formConstructorPage.linkFormBlank("Тестовая форма " + rnd).shouldBe(visible);
    }


    @Test
    // Checking analytics platform functions
    public void testCase4_1() {
        // Creating new report
        logIn();
        SideMenu sideMenu = new SideMenu();
        sideMenu.linkAnalyticsPlatform.click();
        AnalyticsPage analyticsPage =new AnalyticsPage();
        analyticsPage.btnAddReport.click();
        analyticsPage.fieldNewReportName.sendKeys("Тестовый отчет " + rnd);
        analyticsPage.radioNewReportVisualisationForm("Круговая диаграма").click();
        // Adding data
        analyticsPage.btnAddVisibleData.click();
        analyticsPage.fieldAddDataName.sendKeys("Новые данные 001");
        analyticsPage.selectAddDataType.selectOption("Документы созданные (число)");
        analyticsPage.radioAddDataPeriod(2).click();
        analyticsPage.selectAddDataDocType.selectOption("Тестовая лицензия");
        analyticsPage.selectAddDataDocTemplate.selectOption(2);
        analyticsPage.selectAddDataDocStatus.selectOption("Действующий");
        analyticsPage.selectAddDatApplicantType.selectOption("Индивидуальный предприниматель");
        analyticsPage.selectAddDataApplicationMethod.selectOption("В бумажном виде лично");
        analyticsPage.selectAddDataDocCreatedBy.selectOption("Любой");
        analyticsPage.btnAddDataSave.click();
        // Adding access options
        analyticsPage.selectNewReportAccessRole.selectOption("Тестовый оператор");
        analyticsPage.selectNewReportAccessRole.selectOption("Тестовый администратор");
        analyticsPage.selectNewReportAccessUser.selectOption("Test User");
        analyticsPage.btnCreateReport.click();
        analyticsPage.btnGoToReportsList.click();
        analyticsPage.linkReportTitle("Тестовый отчет " + rnd).shouldBe(visible);
    }
    
    @Test
    // Checking new registry creation
    public void testCase6_1_1() {
        // Creating new statements registry
        logIn();
        SideMenu sideMenu = new SideMenu();
        sideMenu.linkAdNewUserRegistries.click();
        RegistriesPage registriesPage = new RegistriesPage();
        registriesPage.radioNewUsersRegistriesType("Реестр обращений").click();
        registriesPage.fieldNewUsersRegistryName.sendKeys("Реестр обращений " + rnd);
        registriesPage.fieldNewUsersRegistryDescription.sendKeys("Описание реестра обращений");
        registriesPage.selectNewUsersRegistryServicesFilter.selectOption("Лицензия на пользование недрами");
        registriesPage.selectNewUsersRegistryArchiveFilter.selectOption("Нет");
        registriesPage.dateNewUsersRegistryFromFilter.sendKeys("01012000");
        registriesPage.dateNewUsersRegistryTillFilter.sendKeys("01012025");
        registriesPage.selectNewUsersRegistryApplicationTypeFilter.selectOption("В бумажном виде лично");
        registriesPage.selectNewUsersRegistryStatusFilter.selectOption("Зарегистрировано");
        registriesPage.btnNewUsersRegistrySave.click();
        // Checking created registry
        Header header = new Header();
        header.goToLKO();
        sideMenu.linkUsersRegistries("Реестр обращений " + rnd).shouldBe(visible).click();
        registriesPage.optionsRegistryPageFilters("Лицензия на пользование недрами").shouldBe(visible);
        registriesPage.optionsRegistryPageFilters("Нет").shouldBe(visible);
        registriesPage.dateRegistryPageTimeFrom
                .shouldHave(attribute("min","2000-01-01"));
        registriesPage.dateRegistryPageTimeTo
                .shouldHave(attribute("max","2025-01-01"));
        registriesPage.optionsRegistryPageFilters("В бумажном виде лично").shouldBe(visible);
        registriesPage.optionsRegistryPageFilters("Зарегистрировано").shouldBe(visible);
    }

}