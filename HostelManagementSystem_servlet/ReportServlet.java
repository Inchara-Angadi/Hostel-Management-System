package servlet;

import dao.HostelDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReportServlet() {
        super();
    }

    // Redirect GET requests to the report form page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("report_form.jsp");
    }

    // Handle report generation based on user input
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String reportType = request.getParameter("reportType");
            if (reportType == null || reportType.trim().isEmpty()) {
                throw new IllegalArgumentException("Report type is required.");
            }
            reportType = reportType.trim();

            HostelDAO dao = new HostelDAO();
            List<Student> reportData = null;
            String reportTitle = "Report Results";

            switch (reportType) {
                case "pendingFees":
                    reportData = dao.getStudentsWithPendingFees();
                    reportTitle = "Students with Pending Fees";
                    break;

                case "room":
                    String roomNumber = request.getParameter("roomNumber");
                    if (roomNumber == null || roomNumber.trim().isEmpty()) {
                        throw new IllegalArgumentException("Room number is required for this report.");
                    }
                    roomNumber = roomNumber.trim();
                    reportData = dao.getStudentsInRoom(roomNumber);
                    reportTitle = "Students in Room: " + roomNumber;
                    break;

                case "admissionDate":
                    String fromDate = request.getParameter("fromDate");
                    String toDate = request.getParameter("toDate");
                    if (fromDate == null || fromDate.trim().isEmpty() || toDate == null || toDate.trim().isEmpty()) {
                        throw new IllegalArgumentException("Both from and to dates are required.");
                    }
                    fromDate = fromDate.trim();
                    toDate = toDate.trim();
                    reportData = dao.getStudentsByAdmissionDate(fromDate, toDate);
                    reportTitle = "Students Admitted from " + fromDate + " to " + toDate;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid report type.");
            }

            // Set attributes for JSP to use
            request.setAttribute("reportData", reportData);
            request.setAttribute("reportTitle", reportTitle);

            // Forward to report_result.jsp to display the report
            request.getRequestDispatcher("report_result.jsp").forward(request, response);

        } catch (Exception e) {
            // Forward back to form with error message
            request.setAttribute("error", "Error generating report: " + e.getMessage());
            request.getRequestDispatcher("report_form.jsp").forward(request, response);
        }
    }
}
