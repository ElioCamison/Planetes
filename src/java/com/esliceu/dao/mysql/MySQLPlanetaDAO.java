package com.esliceu.dao.mysql;

import com.esliceu.dao.PlanetaDAO;
import com.esliceu.models.Planeta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPlanetaDAO implements PlanetaDAO {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    final String INSERT = "INSERT INTO planeta(nom,massa,habitable) VALUES(?,?,?)";
    final String UPDATE = "UPDATE planeta SET nom=?, set massa= ?, set habitable = ? WHERE idplaneta=?)";
    final String DELETE = "DELETE FROM planeta WHERE idplaneta=?";
    final String GET_ALL = "SELECT * FROM planeta LIMIT 20;";
    final String GET_ONE = "SELECT * FROM planeta WHERE idplaneta=?;";

    public MySQLPlanetaDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Planeta p) {
        try{
            preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,p.getNom());
            preparedStatement.setDouble(2,p.getMassa());
            preparedStatement.setBoolean(3,p.isHabitable());
            if(preparedStatement.executeUpdate() == 0){
                throw new SQLException();
            }
            // Retorna l'id de l'objecte satèlit que acabam de crear a sa BD
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                p.setIdplaneta(resultSet.getInt(1));
            } else {
                throw new SQLException();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Planeta p) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,p.getNom());
            preparedStatement.setDouble(2,p.getMassa());
            preparedStatement.setBoolean(3,p.isHabitable());
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Planeta p) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,p.getIdplaneta());
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Planeta createObject(ResultSet resultSet) throws SQLException {
        int idplaneta = resultSet.getInt("idPlaneta");
        String nom = resultSet.getString("nom");
        Float massa = resultSet.getFloat("massa");
        Boolean habitable = resultSet.getBoolean("habitable");
        Planeta planeta = new Planeta();
        planeta.setIdplaneta(idplaneta);
        planeta.setNom(nom);
        planeta.setMassa(massa);
        planeta.setHabitable(habitable);
        return planeta;
    }

    @Override
    public List<Planeta> getAll() {
        ArrayList<Planeta> planetaList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                planetaList.add(createObject(resultSet));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            close_object(resultSet);
            close_preparedStatement(preparedStatement);
        }
        return planetaList;
    }

    @Override
    public Planeta getOne(Integer id) {
        ResultSet resultSet = null;
        Planeta planeta = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ONE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                planeta = createObject(resultSet);
            } else {
                throw new SQLException();
            }
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            close_object(resultSet);
            close_preparedStatement(preparedStatement);
        }
        return planeta;
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
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
