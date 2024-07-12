module com.zzhow.magiccalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zzhow.magiccalculator to javafx.fxml;
    exports com.zzhow.magiccalculator;
}