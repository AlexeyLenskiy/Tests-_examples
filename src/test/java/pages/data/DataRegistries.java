package pages.data;

public class DataRegistries {

    // Statements types
    private static final String[] statementsTypes = {
            "Предоставление лицензии",
            "Получение лицензии",
            "Переоформление лицензий",
            "Внесение изменений и дополнений"
    };


    public static String getStatementsTypes(int num) {
        return statementsTypes[num];
    }


}
