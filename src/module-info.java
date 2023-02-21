module com.example.calculatricefx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens controllers to javafx.fxml;
    exports controllers to javafx.fxml;
    opens app to javafx.fxml;

    exports app;
}
