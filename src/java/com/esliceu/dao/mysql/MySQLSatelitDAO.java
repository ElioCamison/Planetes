package com.esliceu.dao.mysql;

import com.esliceu.dao.SatelitsDAO;
import com.esliceu.models.Satelit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLSatelitDAO implements SatelitsDAO {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    final String INSERT = "INSERT INTO satelit(nom,massa,velocitat,planeta_idplaneta) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE satelit SET nom=?, set massa= ?, set velocitat = ?, set idplaneta=? WHERE idsatelit=?)";
    final String DELETE = "DELETE FROM satelit WHERE idsatelit=?";
    final String GET_ALL = "SELECT * FROM satelit LIMIT 20;";
    final String GET_ONE = "SELECT * FROM satelit WHERE idsatelit=?;";

    public MySQLSatelitDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Satelit p) {
        try{
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,p.getNom());
            preparedStatement.setDouble(2,p.getMassa());
            preparedStatement.setInt(3,p.getVelocitat());
            preparedStatement.setInt(4,p.getIdplaneta());
            if(preparedStatement.executeUpdate() == 0){
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
    public void update(Satelit p) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,p.getNom());
            preparedStatement.setDouble(2,p.getMassa());
            preparedStatement.setInt(3,p.getVelocitat());
            preparedStatement.setInt(4,p.getIdplaneta());
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
    public void delete(Satelit p) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,p.getIdsatelit());
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

    private Satelit createObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("idsatelit");
        String nom = resultSet.getString("nom");
        Double massa = resultSet.getDouble("massa");
        int velocitat = resultSet.getInt("velocitat");
        int idplaneta = resultSet.getInt("planeta_idplaneta");
        Satelit satelit = new Satelit(nom,massa,velocitat,idplaneta);
        return satelit;
    }

    @Override
    public List<Satelit> getAll() {
        ArrayList<Satelit> sateliteList = new ArrayList<>();
        ResultSet resultSet = null;
        Satelit satelit = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sateliteList.add(createObject(resultSet));
            }
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return sateliteList;
    }

    @Override
    public Satelit getOne(Integer id) {
        ResultSet resultSet = null;
        Satelit satelit = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ONE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                satelit = createObject(resultSet);
            } else {
                throw new SQLException();
            }
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return satelit;
    }
}
