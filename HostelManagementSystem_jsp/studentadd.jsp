<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student - Hostel Management System</title>
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
        input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .back-link {
            display: block;
            margin-top: 20px;
            text-align: center;
        }
        .back-link a {
            color: #4CAF50;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2>Add New Student</h2>

    <form action="AddStudentServlet" method="post">
        <label for="studentId">Student ID:</label>
        <input type="number" name="studentId" required>

        <label for="studentName">Student Name:</label>
        <input type="text" name="studentName" required>

        <label for="roomNumber">Room Number:</label>
        <input type="text" name="roomNumber" required>

        <label for="admissionDate">Admission Date:</label>
        <input type="date" name="admissionDate" required>

        <label for="feesPaid">Fees Paid:</label>
        <input type="number" step="0.01" name="feesPaid" required>

        <label for="pendingFees">Pending Fees:</label>
        <input type="number" step="0.01" name="pendingFees" required>

        <input type="submit" value="Add Student">
    </form>

    <div class="back-link">
        <a href="index.jsp">Back to Home</a>
    </div>

</body>
</html>
