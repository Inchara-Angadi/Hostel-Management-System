<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student - Hostel Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 40px;
            text-align: center;
        }
        h2 {
            color: #d32f2f;
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
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            margin-top: 20px;
            background-color: #d32f2f;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #b71c1c;
        }
        .back-link {
            display: block;
            margin-top: 20px;
            text-align: center;
        }
        .back-link a {
            color: #d32f2f;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2>Delete Student Record</h2>

    <form action="DeleteStudentServlet" method="post">
        <label for="studentId">Enter Student ID:</label>
        <input type="number" name="studentId" required>

        <input type="submit" value="Delete Student">
    </form>

    <div class="back-link">
        <a href="index.jsp">Back to Home</a>
    </div>

</body>
</html>
