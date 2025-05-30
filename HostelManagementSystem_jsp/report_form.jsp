<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String type = request.getParameter("type");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Criteria - Hostel Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            padding: 40px;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 30px;
            margin: auto;
            width: 400px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
            text-align: left;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"], input[type="date"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            margin-top: 20px;
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .back-link {
            margin-top: 20px;
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

    <h2>Enter Report Criteria</h2>

    <form action="ReportServlet" method="get">
        <input type="hidden" name="type" value="<%= type %>">

        <% if ("roomWise".equals(type)) { %>
            <label for="roomNumber">Enter Room Number:</label>
            <input type="text" name="roomNumber" required>

        <% } else if ("dateRange".equals(type)) { %>
            <label for="startDate">Start Date:</label>
            <input type="date" name="startDate" required>

            <label for="endDate">End Date:</label>
            <input type="date" name="endDate" required>

        <% } else if ("pendingFees".equals(type)) { %>
            <p>This report will show all students with pending fees. No input is needed.</p>
        <% } else { %>
            <p>Invalid report type.</p>
        <% } %>

        <% if ("roomWise".equals(type) || "dateRange".equals(type) || "pendingFees".equals(type)) { %>
            <input type="submit" value="Generate Report">
        <% } %>
    </form>

    <div class="back-link">
        <a href="reports.jsp">Back to Reports</a>
    </div>

</body>
</html>
