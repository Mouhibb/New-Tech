package manipulation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L ;
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String SELECT = "SELECT * FROM utilisateur WHERE login = ? AND password = ? ";


		try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");


				PreparedStatement ps = connection.prepareStatement(SELECT)) {
            
           

			ps.setString(1, username);
	        ps.setString(2, password);            
            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
            String databaseUsername = rs.getString("login");
            String databasePassword = rs.getString("password");
            
            String databaseType = rs.getString("type");

            String d="directeur";
            String a="administrateur";
            String r="responsable direc";

            if (username.equals(databaseUsername) && password.equals(databasePassword) && a.equals(databaseType)) {
            	HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                
                request.getRequestDispatcher("/indexadmin.jsp").forward(request, response);
            }
            else if (username.equals(databaseUsername) && password.equals(databasePassword) && r.equals(databaseType)) {
            	
            	HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                
                request.getRequestDispatcher("/indexresp.jsp").forward(request, response);

            }
            else if ( username.equals(databaseUsername) && password.equals(databasePassword) && d.equals(databaseType)) {
            	
            	HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                
                request.getRequestDispatcher("/indexdir.jsp").forward(request, response);

            }
            	
            
            else {
                request.getRequestDispatcher("/sign in.jsp").forward(request, response);

            }


            }
		} catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
    	    }
        
		
		
		
		
     
        
    


	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}

	
}