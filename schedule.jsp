<%-- 
    Document   : schedule
    Created on : 16 Jun 2026, 3:05:21 PM
    Author     : Usman Harith
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.drivesmart.model.SessionBean" %>
<%@ include file="header.html" %>

<nav>
    <a href="index.jsp">Home</a>
    <a href="book_session.jsp">Register Training Session</a>
</nav>

<main>
    <h2 style="text-align: center;">Centralized Training Schedule (All Branches)</h2>
    
    <table>
        <thead>
            <tr>
                <th>Session ID</th>
                <th>Student Name</th>
                <th>Branch Location</th>
                <th>Lesson Type</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Retrieve the sessionList attribute from request [cite: 40, 48]
                List<SessionBean> sessionList = (List<SessionBean>) request.getAttribute("sessionList");
                if (sessionList != null && !sessionList.isEmpty()) {
                    // Iterate through the sessionList 
                    for (SessionBean s : sessionList) {
            %>
            <tr>
                <td><%= s.getSessionId() %></td>
                <td><%= s.getStudentName() %></td>
                <td><%= s.getBranchLocation() %></td>
                <td><%= s.getLessonType() %></td>
                <td><strong><%= s.getStatus() %></strong></td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="5" style="text-align: center;">No training sessions booked yet.</td>
            </tr>
            <% 
                } 
            %>
        </tbody>
    </table>
</main>

<%@ include file="footer.jsp" %>