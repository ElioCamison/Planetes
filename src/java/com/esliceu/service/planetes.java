package com.esliceu.service;

import com.esliceu.dao.mysql.MySQLDaoManager;
import com.esliceu.models.Satelit;

import java.sql.*;
import java.util.List;

public class planetes {

    public static void main(String[] args) {
        Connection connection = null;
        String jdbc = "jdbc:mysql://localhost:3306/univers";


        try{
            //connection = DriverManager.getConnection(jdbc,"root","");
            //Statement statement = connection.createStatement();
            //ResultSet set = statement.executeQuery("SELECT * FROM planeta");
            MySQLDaoManager manager = new MySQLDaoManager("root","","univers");
            List<Satelit> satelitList = manager.getSatelitsDao().getAll();
            System.out.println(satelitList);

            /*while(set.next()){
                int id_planeta = set.getInt("idplaneta");
                String nom_planeta = set.getString("nom");
                String massa = set.getString("massa");
                boolean habitable = set.getBoolean("habitable");
                System.out.println("Id planeta :" + id_planeta + "nom :" + nom_planeta.toUpperCase() + " massa : " + massa + " habitable: " + habitable);
            }*/
            //statement.close();
        } catch (SQLException sql){
            sql.printStackTrace();
        } finally {
            if(connection !=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
