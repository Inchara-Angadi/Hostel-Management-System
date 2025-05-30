package servlet;

import dao.HostelDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteStudentServlet() {
        super();
    }

    // Redirect GET requests to the delete form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("studentdelete.jsp");
	}

	// Handle POST request to delete a student
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			// 1. Get student ID from form
			int studentId = Integer.parseInt(request.getParameter("studentId"));

			// 2. Use DAO to delete the student
			HostelDAO dao = new HostelDAO();
			dao.deleteStudent(studentId);

			// 3. Set success message
			request.setAttribute("message", "Student deleted successfully.");
			request.getRequestDispatcher("studentdelete.jsp").forward(request, response);

		} catch (Exception e) {
			// 4. Set error message
			request.setAttribute("error", "Error deleting student: " + e.getMessage());
			request.getRequestDispatcher("studentdelete.jsp").forward(request, response);
		}
	}
}
