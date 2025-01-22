module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.codec;


    opens com.example.Coding to javafx.fxml;
    exports com.example.Coding;
}