module com.javafx.logisticcompanyfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.javafx.logisticcompanyfx to javafx.fxml;
    exports com.javafx.logisticcompanyfx;
    exports com.javafx.logisticcompanyfx.controller;
    opens com.javafx.logisticcompanyfx.controller to javafx.fxml;
}