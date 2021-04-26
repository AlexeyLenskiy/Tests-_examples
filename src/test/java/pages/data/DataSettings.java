package pages.data;

public class DataSettings {

    // Administrator Settings menu items
    private static final String[] adminSettingsItems = {"Типы документов",
            "Статусы документов",
            "Шаблоны документов",
            "Реестры документов",
            "Проверки", "Уведомления",
            "Дополнительные формы",
            "Услуги"};

    // Settings/DocTemplates/Doctypes
    private static final String[] documentTypes = {
            "Приказ",
            "Поручение",
            "Тестовая лицензия",
            "Тестовое заявление",
            "Письмо",
            "Квитанция",
            "Схема",
            "Договор",
            "Лицензия",
            "Заявление",
            "Отчет",
            "Выписка",
            "Справка",
            "Полномочия",
            "Другое",
            "Дополнительное соглашение"
            , "Соглашение",
            "Решение"
    };

    // Settings/DocTemplates
    private static final String[] documentTemplatesTypes = {
            "Бухгалтерский баланс",
            "Выписка из Единого государственного реестра прав на недвижимое имущество",
            "Выписка из реестра акционеров",
            "Выписка из реестра лицензий",
            "Гарантийное письмо о предоставлении земельного участка " +
                    "для осуществления геологического изучения недр",
            "Договор об условиях пользования участком недр"
    };


    public static String getAdminSettingItem(int num) {
        return adminSettingsItems[num];
    }

    public static String getDocumentTypes(int num) {
        return documentTypes[num];
    }

    public static String getDocumentTemplatesType(int num) {
        return documentTemplatesTypes[num];
    }
}
