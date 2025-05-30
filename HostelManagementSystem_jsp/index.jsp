<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hostel Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #333;
        }
        .nav-links {
            margin-top: 30px;
        }
        .nav-links a {
            display: inline-block;
            margin: 10px 20px;
            padding: 12px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: background-color 0.3s;
        }
        .nav-links a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h1>Welcome to Hostel Management System</h1>

    <div class="nav-links">
        <a href="studentadd.jsp">Add Student</a>
        <a href="studentupdate.jsp">Update Student</a>
        <a href="studentdelete.jsp">Delete Student</a>
        <a href="studentdisplay.jsp">View Students</a>
        <a href="reports.jsp">Generate Reports</a>
    </div>

</body>
</html>
