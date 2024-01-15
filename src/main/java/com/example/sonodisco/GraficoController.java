package com.example.sonodisco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class GraficoController {

    @FXML
    private PieChart grafico;

    @FXML
    private Button btnVoltar;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void inicializarGrafico() {
        try {
            List<Discos> d;

            d = DiscosDAO.pesquisaTodos();

            int totalDiscos = d.size();
            Map<String, Integer> contagemGenero = new HashMap<>();

            for (Discos discos : d) {
                String genero = discos.getGenero();
                contagemGenero.put(genero, contagemGenero.getOrDefault(genero, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : contagemGenero.entrySet()) {
                String genero = entry.getKey();
                int quantidade = entry.getValue();
                double porcent = ((double) quantidade / totalDiscos) * 100;
                grafico.getData().add(new PieChart.Data(genero, porcent));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
