package com.example.sonodisco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AcervoController implements Initializable {
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnGrafico;
    @FXML
    private TableView<Discos> discosTable;
    @FXML
    private TableColumn<Discos, String> nomeCol;
    @FXML
    private TableColumn<Discos, String> autoriaCol;
    @FXML
    private TableColumn<Discos, String> generoCol;
    @FXML
    private TableColumn<Discos, String> lancamentoCol;
    private ObservableList<Discos> acervoDiscos;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acervoDiscos = FXCollections.observableArrayList();
        discosTable.setItems(acervoDiscos);

        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        autoriaCol.setCellValueFactory(new PropertyValueFactory<>("autoria"));
        generoCol.setCellValueFactory(new PropertyValueFactory<>("genero"));
        lancamentoCol.setCellValueFactory(new PropertyValueFactory<>("lancamento"));

        discosTable.getColumns().clear();
        discosTable.getColumns().addAll(nomeCol, autoriaCol, generoCol, lancamentoCol);

        try {
            atualiza();
        } catch (Exception throwable) {
            Alert e = new Alert(Alert.AlertType.ERROR);

            e.setContentText("Erro no Banco de Dados.");
            e.setTitle("ERRO");
            e.showAndWait();
        }
    }

    @FXML
    private void acessarRegistrar(ActionEvent event) {
        btnRegistrar.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registro.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setTitle("REGISTRO");
            stage1.show();
        } catch (IOException ex) {
            Alert e = new Alert(Alert.AlertType.ERROR);

            e.setContentText("Erro ao acessar Registro.");
            e.setTitle("ERROR");
            e.showAndWait();
        }
    }

    @FXML
    public void delete(ActionEvent event) throws Exception {
        Discos c = discosTable.getSelectionModel().getSelectedItem();

        if (c != null) {
            DiscosDAO.remove(c);

            atualiza();
        } else {
            Alert d = new Alert(Alert.AlertType.ERROR);

            d.setContentText("Erro no delete do disco " + c.getNome());
            d.setTitle("ERROR");
            d.showAndWait();
        }
    }

    @FXML
    private void acessarGrafico(ActionEvent event) {
        btnGrafico.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("grafico.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setTitle("GRÁFICO");

            GraficoController grafico = loader.getController();
            grafico.inicializarGrafico();

            stage1.show();
        } catch (IOException ex) {
            Alert e = new Alert(Alert.AlertType.ERROR);

            e.setContentText("Erro ao acessar Gráfico.");
            e.setTitle("ERROR");
            e.showAndWait();
        }
    }

    public void atualiza() throws Exception {
        discosTable.getItems().clear();
        List<Discos> d;

        d = DiscosDAO.pesquisaTodos();
        for (Discos c : d) {
            Discos disco = (Discos) c;

            acervoDiscos.add(disco);
        }
        discosTable.refresh();
    }
}