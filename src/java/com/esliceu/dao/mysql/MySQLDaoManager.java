package com.esliceu.dao.mysql;

import com.esliceu.dao.DaoManager;
import com.esliceu.dao.PlanetaDAO;
import com.esliceu.dao.SatelitsDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDaoManager implements DaoManager {

    private Connection connection;
    final String JDBC = "jdbc:mysql://localhost:3306/univers";
    private SatelitsDAO satelitsDAO = null;
    private PlanetaDAO planetaDAO = null;
    public MySQLDaoManager(String user, String pass, String db )throws SQLException {

        // Lo seu sería enviar també sa Base de dades pero pas una mica ara mateix
        connection = DriverManager.getConnection(JDBC,user,pass);
    }

    @Override
    public SatelitsDAO getSatelitsDao() {
        if(satelitsDAO == null){
            satelitsDAO = new MySQLSatelitDAO(connection);
        }
        return satelitsDAO;
    }

    @Override
    public PlanetaDAO getPlanetaDAO() {
        /*if(planetaDAO == null){
            planetaDAO = new MySQLPlanetaDAO(connection);
        }*/
        return planetaDAO;
    }
}
