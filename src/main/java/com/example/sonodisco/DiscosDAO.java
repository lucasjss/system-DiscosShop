package com.example.sonodisco;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscosDAO {

    public static void adiciona(Discos c) throws SQLException {
        String sql = SQLConsts.INSERT;

        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getAutoria());
                stmt.setString(3, c.getGenero());
                stmt.setString(4, c.getLancamento());
                stmt.execute();
            }
        }
    }

    public static List<Discos> pesquisaTodos() throws SQLException {
        ArrayList discos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(SQLConsts.SEARCH);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Discos a = new Discos();

                    a.setNome(rs.getString("nome"));
                    a.setAutoria(rs.getString("autoria"));
                    a.setGenero(rs.getString("genero"));
                    a.setLancamento(rs.getString("lancamento"));
                    discos.add(a);
                }
            }
        }
        return discos;
    }

    public void alterar(Discos c) throws SQLException {
        String sql = SQLConsts.UPDATE;
        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(2, c.getAutoria());
                stmt.setString(3, c.getGenero());
                stmt.setString(4, c.getLancamento());
                stmt.execute();
            }
        }
    }

    public static void remove(Discos c) throws SQLException {
        String sql = SQLConsts.REMOVE;

        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, c.getNome());
                stmt.execute();
            }
        }
    }
}
