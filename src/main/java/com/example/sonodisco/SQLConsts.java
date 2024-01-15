package com.example.sonodisco;

public class SQLConsts {
    public static final String INSERT = "insert into "
            + "discos (nome, autoria, genero, lancamento) "
            + "values (?,?,?,?)";

    public static final String UPDATE = "update disco set "
            + "autoria=?, genero=?, lancamento=? where nome=?";

    public static final String REMOVE = "delete from discos where nome=?";

    public static final String SEARCH = "select * from discos";

}
