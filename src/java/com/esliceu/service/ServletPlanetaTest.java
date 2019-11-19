package com.esliceu.service;

import com.esliceu.models.Planeta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/planetes_test")
public class ServletPlanetaTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Connection connection = null;
        String jdbc = "jdbc:mysql://localhost:3306/univers";

        /*req.setAttribute("name", "Hussein Terek");
        req.getRequestDispatcher("index.jsp").forward(req, resp);*/

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbc,"root","");
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM planeta");

            ArrayList<Planeta> planetas_list =  new ArrayList<>();
            while(set.next()) {
                int id_planeta = set.getInt("idplaneta");
                String nom_planeta = set.getString("nom");
                float massa = set.getFloat("massa");
                Boolean habitable = set.getBoolean("habitable");
                Planeta planeta = new Planeta(nom_planeta,massa,habitable);
                planetas_list.add(planeta);
            }
            statement.close();
            req.setAttribute("planetes",planetas_list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException sql){
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
