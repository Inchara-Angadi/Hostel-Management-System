package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ReportCriteriaServlet")
public class ReportCriteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReportCriteriaServlet() {
		super();
	}

	// Handles GET requests by redirecting to report form
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("report_form.jsp");
	}

	// Handles POST requests to determine selected report type
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String reportType = request.getParameter("reportType");

			// Set selected report type as a request attribute
			request.setAttribute("reportType", reportType);

			// Forward to report_form.jsp to show appropriate input fields
			request.getRequestDispatcher("report_form.jsp").forward(request, response);

		} catch (Exception e) {
			// Error handling
			request.setAttribute("error", "Unable to process report type: " + e.getMessage());
			request.getRequestDispatcher("report_form.jsp").forward(request, response);
		}
	}
}
