<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Students - Hostel Management System</title>
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
            padding: 20px;
            margin: 0 auto 30px;
            width: 400px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }
        label {
            display: block;
            font-weight: bold;
            margin-top: 10px;
        }
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
        }
        input[type="submit"] {
            margin-top: 15px;
            background-color: #2196F3;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #1976D2;
        }
        table {
            margin: auto;
            border-collapse: collapse;
            width: 90%;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #1976D2;
            color: white;
        }
        .back-link {
            margin-top: 20px;
        }
        .back-link a {
            color: #2196F3;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2>View Student Information</h2>

    <form action="DisplayStudentsServlet" method="get">
        <label for="studentId">Enter Student ID (leave blank to view all):</label>
        <input type="number" name="studentId">
        <input type="submit" value="View Student(s)">
    </form>

    <div class="back-link">
        <a href="index.jsp">Back to Home</a>
    </div>

</body>
</html>
