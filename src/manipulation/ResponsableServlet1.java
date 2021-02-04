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








/**
 * Servlet implementation class ResponsableServlet1
 */
@WebServlet("/ResponsableServlet1")
public class ResponsableServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private String jdbcURL = "jdbc:mysql://localhost:3306/db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
        
        
        private static final String SELECT_DIRECTION = "SELECT  code_direction FROM direction WHERE nom_direction = ?;";
        private static final String SELECT_THEME = "SELECT  code_theme  FROM theme WHERE nom_theme = ?;";
        private static final String SELECT_PARTENAIRE = "SELECT  code_partenaire FROM partenaire WHERE nom_partenaire = ?;";

        private static final String INSERT_SOURCE_FIN = "INSERT INTO source_financiere" + "  (sourcefin) VALUES " +
                " (?);";
        private static final String INSERT_SOURCE_INF = "INSERT INTO source_information" + "  (sourceinf) VALUES " +
                " (?);";
        private static final String INSERT_ACTIVITE = "INSERT INTO activité" + "  (direction, année, theme, intitulé, indicateur, source_information, periode, partenaire, source_financiere, état) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
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
	
       
    
    public int selectDirection(String nom_direction) {
        int code=0;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIRECTION);) {
            preparedStatement.setString(1, nom_direction);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                 code = rs.getInt("code_direction");
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return code;
    }
    public int selectTheme(String nom_theme) {
        int code=0;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THEME);) {
            preparedStatement.setString(1, nom_theme);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                 code = rs.getInt("code_theme");
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return code;
    }
    public int selectPartenaire(String nom_partenaire) {
        int code=0;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARTENAIRE);) {
            preparedStatement.setString(1, nom_partenaire);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                 code = rs.getInt("code_partenaire");
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return code;
    }
    
    public void insertSource_fin(String source_fin) throws SQLException {
        
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SOURCE_FIN)) {
            preparedStatement.setString(1, source_fin);
            

            

            int i = preparedStatement.executeUpdate();
	        if (i>0) {
	        	System.out.println("insertion avec succée");
	        }
	        else {
	        	System.out.println("erreur de insertion ");
	        }

        } catch (SQLException e) {
            printSQLException(e);
        }
    }
public void insertSource_inf(String source_inf) throws SQLException {
        
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SOURCE_INF)) {
            preparedStatement.setString(1, source_inf);
            

            

            int i = preparedStatement.executeUpdate();
	        if (i>0) {
	        	System.out.println("insertion avec succée");
	        }
	        else {
	        	System.out.println("erreur de insertion ");
	        }

        } catch (SQLException e) {
            printSQLException(e);
        }
    }



public void insertActivité(int direction, int année, int theme, String intitulé, float indicateur, String source_inf, String periode, int partenaire, String source_fin, String etat) throws SQLException {
    
    // try-with-resource statement will auto close the connection.
    try (Connection connection = getConnection(); 
    	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACTIVITE)) {
        preparedStatement.setInt(1, direction);
        preparedStatement.setInt(2, année);
        preparedStatement.setInt(3, theme);
        preparedStatement.setString(4, intitulé);
        preparedStatement.setFloat(5, indicateur);
        preparedStatement.setString(6, source_inf);
        preparedStatement.setString(7, periode);
        preparedStatement.setInt(8, partenaire);
        preparedStatement.setString(9, source_fin);
        preparedStatement.setString(10, etat);

        int i = preparedStatement.executeUpdate();
        if (i>0) {
        	System.out.println("insertion avec succée");
        }
        else {
        	System.out.println("erreur de insertion ");
        }

    } catch (SQLException e) {
        printSQLException(e);
    }
}



public ResponsableServlet1() {
    super();
}
private void printSQLException(SQLException ex) {
    for (Throwable e: ex) {
        if (e instanceof SQLException) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
}

	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int d,t,p;
		
		String nom_direction = request.getParameter("nom_direction");
		
		d=selectDirection(nom_direction);
		
		String nom_partenaire = request.getParameter("nom_partenaire");
		
	    p=selectPartenaire(nom_partenaire);
	    
	    String nom_theme = request.getParameter("nom_theme");
	    
	    t=selectTheme(nom_theme);
	    
	    String source_fin=request.getParameter("source_fin");
	    
	    try {
			insertSource_fin(source_fin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String source_inf=request.getParameter("source_inf");
	    try {
			insertSource_inf(source_inf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    String intitulé = request.getParameter("intitulé");
	    float indicateur = (float) Double.parseDouble(request.getParameter("indicateur"));
	    String periode = request.getParameter("periode");
	    int année = Integer.parseInt(request.getParameter("année"));
	    
	    String etat = request.getParameter("état");
	    
	    
	    try {
	    insertActivité( d,  année, t,  intitulé,  indicateur,  source_inf,  periode,  p,  source_fin,  etat);
	    		
	    System.out.println("succéé");
        String msg2="activité ajoutée avec succées";
        request.setAttribute("msg2", msg2);
		request.getRequestDispatcher("/resp.jsp").forward(request, response);			
	}
	    catch (Exception e ) {
		    System.out.println("erreur d'insertion de l'activité");

	    }

}
}
