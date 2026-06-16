package com.drivesmart.controller;

import com.drivesmart.dao.sessionDAO;
import com.drivesmart.model.SessionBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private sessionDAO sessionDAO;

    public void init() {
        sessionDAO = new sessionDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Call getAllSessions() from DAO 
        List<SessionBean> list = sessionDAO.getAllSessions();
        
        // Set retrieved list as request attribute 
        request.setAttribute("sessionList", list);
        
        // Forward HTTP request to JSP schedule page using RequestDispatcher 
        RequestDispatcher dispatcher = request.getRequestDispatcher("schedule.jsp");
        dispatcher.forward(request, response);
    }
}