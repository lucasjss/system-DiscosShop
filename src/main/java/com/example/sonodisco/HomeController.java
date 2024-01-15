package com.example.sonodisco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HomeController {

    @FXML
    private Button btnAcervo;

    @FXML
    private void acessarAcervo(ActionEvent event) {
        btnAcervo.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("acervo.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setTitle("ACERVO");
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro");
            ex.printStackTrace();
        }
    }

    @FXML
    public void initialize() {

    }
}