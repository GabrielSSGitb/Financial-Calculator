module com.financialcalculator {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.financialcalculator to javafx.fxml;
    exports com.financialcalculator;
    exports MathFunctions;
    exports Statistics;
    exports Memory;
    exports FinancialClass;
    exports Formater;
}