package com.esliceu.dao.mysql;

import com.esliceu.dao.PlanetaDAO;
import com.esliceu.models.Planeta;

import java.sql.*;
import java.util.List;

public class MySQLPlanetaDAO implements PlanetaDAO {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
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
            preparedStatement.setBoolean(3,p.getHabitable());
            if(preparedStatement.executeUpdate() == 0){
                throw new SQLException();
            }
            // Retorna l'id de l'objecte satèlit que acabam de crear a sa BD
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
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

    }

    @Override
    public void delete(Planeta p) {

    }

    @Override
    public List<Planeta> getAll() {
        return null;
    }

    @Override
    public Planeta getOne(Integer id) {
        return null;
    }
}
