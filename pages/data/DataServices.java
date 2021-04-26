package pages.data;

public class DataServices {

    // Services types
    // Ministries
    private static final String[] ministryTypes = {
            "Министерство Образования",
            "Минздрав",
            "Минконтроль",
            "Минприроды",
            "Минэкпром",
            "Тестовая организация"
    };

    // Ministry of healthcare services
    private static final String[] medServices = {
            "Лицензирование медицинской деятельности медицинских организаций",
            "Лицензирование деятельности по обороту наркотических средств и психотропных веществ",
            "Лицензирование фармацевтической деятельности",
    };


    public static String getMedServices(int num) {
        return medServices[num];
    }

    public static String getMinistryTypes(int num) {return ministryTypes[num]; }
}
