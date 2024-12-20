module testjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base; // Ensure javafx.base is required
    requires java.sql; // If you are using JDBC

    opens application to javafx.base, javafx.fxml;

    exports application;
}
