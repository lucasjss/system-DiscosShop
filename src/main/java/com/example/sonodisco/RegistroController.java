package com.example.sonodisco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegistroController {
    @FXML
    public Button btnRegistrar;
    @FXML
    private Button btnVoltar;
    @FXML
    private TextArea inputNome, inputAutoria, inputLancamento, inputGenero;

    @FXML
    public void registrar(ActionEvent event) {
        Discos disco = new Discos();

        disco.setNome(inputNome.getText());
        disco.setAutoria(inputAutoria.getText());
        disco.setGenero(inputGenero.getText());
        disco.setLancamento(inputLancamento.getText());
        try {
            DiscosDAO.adiciona(disco);

            Alert a = new Alert(Alert.AlertType.INFORMATION);

            a.setContentText("disco cadastrado com sucesso!");
            a.showAndWait();
        } catch (Exception ex) {
            Alert e = new Alert(Alert.AlertType.ERROR);
            System.out.println(ex);
            e.setContentText("Erro ao cadastrar disco.");

            e.setTitle("ERROR");
            e.showAndWait();
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        btnVoltar.getScene().getWindow().hide();
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

}