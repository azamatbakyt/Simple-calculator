module com.azamat.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.azamat.calculator to javafx.fxml;
    exports com.azamat.calculator;
}