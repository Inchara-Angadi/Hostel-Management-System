package servlet;

import dao.HostelDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DisplayStudentsServlet")
public class DisplayStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplayStudentsServlet() {
        super();
    }

    // Handle GET request to display all students
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HostelDAO dao = new HostelDAO();

            // Check if an individual student ID was provided
            String studentIdParam = request.getParameter("studentId");
            Integer studentId = (studentIdParam != null && !studentIdParam.isEmpty())
                                ? Integer.parseInt(studentIdParam) : null;

            // Get students (all or one)
            List<Student> studentList = dao.getStudents(studentId);

            // Pass list to JSP
            request.setAttribute("studentList", studentList);
            request.getRequestDispatcher("studentdisplay.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Error displaying students: " + e.getMessage());
            request.getRequestDispatcher("studentdisplay.jsp").forward(request, response);
        }
    }

    // POST behaves the same as GET here
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
