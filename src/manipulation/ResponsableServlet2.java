package manipulation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResponsableServlet2")
public class ResponsableServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String jdbcURL = "jdbc:mysql://localhost:3306/db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    private static final String UPDATE = "update activité set état = ?  where année = ? ;";
	
	
	
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    public boolean updateActivité(int année, String état) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE);) {
            statement.setString(1, état);
            statement.setInt(2, année);
      

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    
    public ResponsableServlet2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		int année = Integer.parseInt(request.getParameter("année"));
        String nouvelle_état = request.getParameter("état");



        
			try {
				updateActivité(année, nouvelle_état);
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		
        
        String msg2="Activité modifiée avec succées";
        request.setAttribute("msg2", msg2);
		request.getRequestDispatcher("/resp2.jsp").forward(request, response);
		
		
	}

}
