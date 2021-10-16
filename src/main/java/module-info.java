module com.example.projectantoanthongtin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectantoanthongtin to javafx.fxml;
    exports com.example.projectantoanthongtin;
}