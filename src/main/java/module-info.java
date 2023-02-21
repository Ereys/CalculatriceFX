module com.example.calculatricefx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.calculatricefx to javafx.fxml;
    exports com.example.calculatricefx;

    exports app;
}