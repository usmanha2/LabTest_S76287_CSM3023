package com.drivesmart.dao;

import com.drivesmart.model.SessionBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sessionDAO {
    
    // Connection Method [
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivesmart_db", "root", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Insert Method 
    public boolean bookSession(SessionBean session) {
        boolean rowInserted = false;
        String sql = "INSERT INTO Training_Sessions (student_name, branch_location, lesson_type, status) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, session.getStudentName());
            statement.setString(2, session.getBranchLocation());
            statement.setString(3, session.getLessonType());
            statement.setString(4, session.getStatus());
            
            rowInserted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    // Retrieve Method 
    public List<SessionBean> getAllSessions() {
        List<SessionBean> sessions = new ArrayList<>();
        String sql = "SELECT * FROM Training_Sessions ORDER BY branch_location ASC";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            
            while (rs.next()) {
                SessionBean session = new SessionBean();
                session.setSessionId(rs.getInt("session_id"));
                session.setStudentName(rs.getString("student_name"));
                session.setBranchLocation(rs.getString("branch_location"));
                session.setLessonType(rs.getString("lesson_type"));
                session.setStatus(rs.getString("status"));
                sessions.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }
}