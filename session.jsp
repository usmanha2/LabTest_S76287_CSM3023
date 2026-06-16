<%-- 
    Document   : session
    Created on : 16 Jun 2026, 3:04:53 PM
    Author     : Usman Harith
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.html" %>

<nav>
    <a href="index.jsp">Home</a>
    <a href="ScheduleServlet">View Centralized Schedule</a>
</nav>

<main>
    <form action="BookSessionServlet" method="POST">
        <h2>Book a Training Session</h2>
        
        <label for="student_name">Student Name:</label>
        <input type="text" id="student_name" name="student_name" required placeholder="Enter full name">
        
        <label for="branch_location">Branch Location:</label>
        <select id="branch_location" name="branch_location" required>
            <option value="">-- Select Branch --</option>
            <option value="Kuala Lumpur">Kuala Lumpur</option>
            <option value="Penang">Penang</option>
            <option value="Johor">Johor</option>
        </select>
        
        <label for="lesson_type">Lesson Type:</label>
        <select id="lesson_type" name="lesson_type" required>
            <option value="">-- Select Lesson Type --</option>
            <option value="Manual Car">Manual Car</option>
            <option value="Automatic Car">Automatic Car</option>
            <option value="Motorcycle">Motorcycle</option>
        </select>
        
        <button type="submit">Submit Booking</button>
    </form>
</main>

<%@ include file="footer.jsp" %>