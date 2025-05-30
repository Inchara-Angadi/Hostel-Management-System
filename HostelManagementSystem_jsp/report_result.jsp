<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Student" %>
<%
    List<Student> studentList = null;
    String reportTitle = (String) request.getAttribute("reportTitle");

    Object listObj = request.getAttribute("reportData");
    if (listObj != null && listObj instanceof List<?>) {
        studentList = (List<Student>) listObj;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Results - Hostel Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f7;
            padding: 40px;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        table {
            margin: auto;
            border-collapse: collapse;
            width: 95%;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .back-link {
            margin-top: 30px;
        }
        .back-link a {
            color: #007bff;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2><%= reportTitle != null ? reportTitle : "Report Results" %></h2>

    <% if (studentList == null || studentList.isEmpty()) { %>
        <p>No records found.</p>
    <% } else { %>
        <table>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Room Number</th>
                <th>Admission Date</th>
                <th>Fees Paid</th>
                <th>Pending Fees</th>
            </tr>
            <% for (Student s : studentList) { %>
                <tr>
                    <td><%= s.getStudentId() %></td>
                    <td><%= s.getStudentName() %></td>
                    <td><%= s.getRoomNumber() %></td>
                    <td><%= s.getAdmissionDate() %></td>
                    <td><%= s.getFeesPaid() %></td>
                    <td><%= s.getPendingFees() %></td>
                </tr>
            <% } %>
        </table>
    <% } %>

    <div class="back-link">
        <a href="reports.jsp">Back to Reports</a>
    </div>

</body>
</html>
