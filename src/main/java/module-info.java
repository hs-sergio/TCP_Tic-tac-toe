module com.example.tcp_tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tcp_tictactoe to javafx.fxml;
    exports com.example.tcp_tictactoe;
}