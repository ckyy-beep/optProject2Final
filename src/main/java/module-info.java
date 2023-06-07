module com.example.optproject2final {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.optproject2final to javafx.fxml;
    exports com.example.optproject2final;
}