package main.java.controller;

import main.java.dao.ItemDao;
import main.java.model.Iteminfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/item")
public class ItemController extends HttpServlet{
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ItemDao itemDao = new ItemDao();
        List<Iteminfo> iteminfo = itemDao.findAll();
        request.getRequestDispatcher("/WEB-INF/jsp/item.jsp")
                .forward(request, response);
    }

}


