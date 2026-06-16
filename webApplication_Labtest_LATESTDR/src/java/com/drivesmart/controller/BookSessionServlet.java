package com.drivesmart.controller;

import com.drivesmart.dao.sessionDAO;
import com.drivesmart.model.SessionBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookSessionServlet")
public class BookSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private sessionDAO sessionDAO;

    public void init() {
        sessionDAO = new sessionDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve parameters from web form 
        String studentName = request.getParameter("student_name");
        String branchLocation = request.getParameter("branch_location");
        String lessonType = request.getParameter("lesson_type");
        
        // Instantiate SessionBean and set values with default status "Booked" 
        SessionBean newSession = new SessionBean(studentName, branchLocation, lessonType, "Booked");
        
        // Pass object to DAO to save 
        boolean isSaved = sessionDAO.bookSession(newSession);
        
        if (isSaved) {
            // Redirect to Schedule Servlet upon success 
            response.sendRedirect("ScheduleServlet");
        } else {
            response.sendRedirect("book_session.jsp?error=1");
        }
    }
}