<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reports - Hostel Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f7;
            text-align: center;
            padding: 50px;
        }
        h2 {
            color: #333;
        }
        .report-options {
            margin-top: 30px;
        }
        .report-options a {
            display: block;
            margin: 15px auto;
            padding: 15px 25px;
            width: 300px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: background-color 0.3s;
        }
        .report-options a:hover {
            background-color: #0056b3;
        }
        .back-link {
            margin-top: 40px;
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

    <h2>Generate Reports</h2>

    <div class="report-options">
        <a href="report_form.jsp?type=pendingFees">Students with Pending Fees</a>
        <a href="report_form.jsp?type=roomWise">Students in a Specific Room</a>
        <a href="report_form.jsp?type=dateRange">Students Admitted in a Date Range</a>
    </div>

    <div class="back-link">
        <a href="index.jsp">Back to Home</a>
    </div>

</body>
</html>
