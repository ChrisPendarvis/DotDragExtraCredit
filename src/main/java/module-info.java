module com.example.dragdot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.dragdot to javafx.fxml;
    exports com.example.dragdot;
}