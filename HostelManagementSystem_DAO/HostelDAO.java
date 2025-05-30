package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class HostelDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/hostel_db";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Add a new student
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO HostelStudents (StudentID, StudentName, RoomNumber, AdmissionDate, FeesPaid, PendingFees) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getStudentId());
            stmt.setString(2, student.getStudentName());
            stmt.setString(3, student.getRoomNumber());
            stmt.setDate(4, Date.valueOf(student.getAdmissionDate()));
            stmt.setBigDecimal(5, student.getFeesPaid());
            stmt.setBigDecimal(6, student.getPendingFees());
            stmt.executeUpdate();
        }
    }

    // Update a student
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE HostelStudents SET StudentName=?, RoomNumber=?, AdmissionDate=?, FeesPaid=?, PendingFees=? WHERE StudentID=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentName());
            stmt.setString(2, student.getRoomNumber());
            stmt.setDate(3, Date.valueOf(student.getAdmissionDate()));
            stmt.setBigDecimal(4, student.getFeesPaid());
            stmt.setBigDecimal(5, student.getPendingFees());
            stmt.setInt(6, student.getStudentId());
            stmt.executeUpdate();
        }
    }

    // Delete a student
    public void deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM HostelStudents WHERE StudentID=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        }
    }

    // Get all students or a specific student
    public List<Student> getStudents(Integer studentId) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = (studentId != null) ?
                "SELECT * FROM HostelStudents WHERE StudentID=?" :
                "SELECT * FROM HostelStudents";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (studentId != null) {
                stmt.setInt(1, studentId);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setRoomNumber(rs.getString("RoomNumber"));
                s.setAdmissionDate(rs.getDate("AdmissionDate").toLocalDate());
                s.setFeesPaid(rs.getBigDecimal("FeesPaid"));
                s.setPendingFees(rs.getBigDecimal("PendingFees"));
                students.add(s);
            }
        }
        return students;
    }

    // Report: Students with pending fees
    public List<Student> getStudentsWithPendingFees() throws SQLException {
        String sql = "SELECT * FROM HostelStudents WHERE PendingFees > 0";
        return getStudentsFromQuery(sql);
    }

    // Report: Students in a specific room
    public List<Student> getStudentsInRoom(String roomNumber) throws SQLException {
        String sql = "SELECT * FROM HostelStudents WHERE RoomNumber=?";
        return getStudentsFromQuery(sql, roomNumber);
    }

    // Report: Students admitted between dates String fromDate, String toDate
    public List<Student> getStudentsByAdmissionDate(String fromDate, String toDate) throws SQLException {
        String sql = "SELECT * FROM HostelStudents WHERE AdmissionDate BETWEEN ? AND ?";
        List<Student> students = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,fromDate );
            stmt.setString(2, toDate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setRoomNumber(rs.getString("RoomNumber"));
                s.setAdmissionDate(rs.getDate("AdmissionDate").toLocalDate());
                s.setFeesPaid(rs.getBigDecimal("FeesPaid"));
                s.setPendingFees(rs.getBigDecimal("PendingFees"));
                students.add(s);
            }
        }
        return students;
    }

    // Helper method for reports
    private List<Student> getStudentsFromQuery(String sql, String... params) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setString(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setRoomNumber(rs.getString("RoomNumber"));
                s.setAdmissionDate(rs.getDate("AdmissionDate").toLocalDate());
                s.setFeesPaid(rs.getBigDecimal("FeesPaid"));
                s.setPendingFees(rs.getBigDecimal("PendingFees"));
                students.add(s);
            }
        }
        return students;
    }
}
