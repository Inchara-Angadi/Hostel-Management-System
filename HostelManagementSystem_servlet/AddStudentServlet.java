package servlet;

import dao.HostelDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddStudentServlet() {
        super();
    }

    // Handle GET requests (optional — not used for adding students)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("studentadd.jsp");
    }

    // Handle POST requests from the add student form
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 1. Read form parameters
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            String studentName = request.getParameter("studentName");
            String roomNumber = request.getParameter("roomNumber");
            LocalDate admissionDate = LocalDate.parse(request.getParameter("admissionDate"));
            BigDecimal feesPaid = new BigDecimal(request.getParameter("feesPaid"));
            BigDecimal pendingFees = new BigDecimal(request.getParameter("pendingFees"));

            // 2. Create Student object
            Student student = new Student(studentId, studentName, roomNumber,
                                          admissionDate, feesPaid, pendingFees);

            // 3. Save to database using DAO
            HostelDAO dao = new HostelDAO();
            dao.addStudent(student);

            // 4. Show success message
            request.setAttribute("message", "Student added successfully.");
            request.getRequestDispatcher("studentadd.jsp").forward(request, response);

        } catch (Exception e) {
            // 5. Handle error
            request.setAttribute("error", "Error adding student: " + e.getMessage());
            request.getRequestDispatcher("studentadd.jsp").forward(request, response);
        }
    }
}
