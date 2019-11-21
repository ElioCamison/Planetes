package com.esliceu.dao.mysql;

import com.esliceu.dao.UsuariDAO;
import com.esliceu.models.Satelit;
import com.esliceu.models.Usuari;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsuariDAO implements UsuariDAO {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    final String INSERT = "INSERT INTO usuari(nom,password) VALUES(?,?)";
    final String UPDATE = "UPDATE usuari SET nom=?, set password= ? WHERE idusuari=?)";
    final String DELETE = "DELETE FROM usuari WHERE idusuari=?";
    final String GET_ALL = "SELECT * FROM usuari LIMIT 20;";
    final String GET_ONE = "SELECT * FROM usuari WHERE idusuari=?;";

    @Override
    public void insert(Usuari u) {
        try{
            preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,u.getNom());
            preparedStatement.setString(2,u.getPasswoord());
            if(preparedStatement.executeUpdate() == 0){
                throw new SQLException();
            }
            // Retorna l'id de l'objecte satèlit que acabam de crear a sa BD
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                u.setIdusuari(resultSet.getInt(1));
            } else {
                throw new SQLException();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            close_preparedStatement(preparedStatement);
        }
    }

    @Override
    public void update(Usuari u) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,u.getNom());
            preparedStatement.setString(2,u.getPasswoord());
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            close_preparedStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Usuari u) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,u.getIdusuari());
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            close_preparedStatement(preparedStatement);
        }
    }

    private Usuari createObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("idusuari");
        String nom = resultSet.getString("nom");
        String password = resultSet.getString("password");
        Usuari usuari = new Usuari();
        usuari.setIdusuari(id);
        usuari.setNom(nom);
        usuari.setPasswoord(password);
        return usuari;
    }

    @Override
    public List<Usuari> getAll() {
        ArrayList<Usuari> usuarisList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                usuarisList.add(createObject(resultSet));
            }
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            close_object(resultSet);
            close_preparedStatement(preparedStatement);
        }

        return usuarisList;
    }

    @Override
    public Usuari getOne(Integer id) {
        ResultSet resultSet = null;
        Usuari usuari = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ONE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                usuari = createObject(resultSet);
            } else {
                throw new SQLException();
            }
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            close_object(resultSet);
            close_preparedStatement(preparedStatement);
        }
        return usuari;
    }


    private void close_object(ResultSet r){
        if(r != null){
            try {
                r.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private  void close_preparedStatement(PreparedStatement ps){
        if(ps != null){
            try { ps.close(); }
            catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
