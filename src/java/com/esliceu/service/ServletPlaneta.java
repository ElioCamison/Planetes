package com.esliceu.service;

import com.esliceu.dao.mysql.MySQLDaoManager;
import com.esliceu.models.Satelit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/planetes")
public class ServletPlaneta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        MySQLDaoManager manager = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            manager = new MySQLDaoManager("root","","univers");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Satelit> satelitList = manager.getSatelitsDao().getAll();
        req.setAttribute("satelits",satelitList);
        req.getRequestDispatcher("planetes.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }

}
