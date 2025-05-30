package servlet;

import dao.HostelDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateStudentServlet() {
        super();
    }

	// Redirect GET requests to update form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("studentupdate.jsp");
	}

	// Handle POST request for updating a student
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			// 1. Get data from form
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			String studentName = request.getParameter("studentName");
			String roomNumber = request.getParameter("roomNumber");
			LocalDate admissionDate = LocalDate.parse(request.getParameter("admissionDate"));
			BigDecimal feesPaid = new BigDecimal(request.getParameter("feesPaid"));
			BigDecimal pendingFees = new BigDecimal(request.getParameter("pendingFees"));

			// 2. Create Student object
			Student student = new Student(studentId, studentName, roomNumber,
				admissionDate, feesPaid, pendingFees);

			// 3. Update using DAO
			HostelDAO dao = new HostelDAO();
			dao.updateStudent(student);

			// 4. Set success message
			request.setAttribute("message", "Student updated successfully.");
			request.getRequestDispatcher("studentupdate.jsp").forward(request, response);

		} catch (Exception e) {
			// 5. Handle error
			request.setAttribute("error", "Error updating student: " + e.getMessage());
			request.getRequestDispatcher("studentupdate.jsp").forward(request, response);
		}
	}
}
