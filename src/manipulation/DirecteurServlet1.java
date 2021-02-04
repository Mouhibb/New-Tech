package manipulation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.TestActivité;





@WebServlet("/DirecteurServlet1")
public class DirecteurServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
       
    

    
    
    private static final String SELECT_PAR_DIRECTION = " Select activité.*, direction.nom_direction, theme.nom_theme" + 
    		" from activité inner join direction " + 
    		" on activité.direction = direction.code_direction and  direction.nom_direction = ? and activité.année = ?  "
    		+ "inner join theme on theme.code_theme = activité.theme;";
    		
    		

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
    
   
    public List < TestActivité > selectAllTestActivité(String  nom_direction  ) {
		List<TestActivité> TestActivités = new ArrayList<TestActivité>();
        int year = Calendar.getInstance().get(Calendar.YEAR);

        // using try-with-resources to avoid closing resources (boiler plate code)
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAR_DIRECTION);) {
            preparedStatement.setString(1, nom_direction);
            preparedStatement.setInt(2, year);

            


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String direction = rs.getString("nom_direction");
                int année = rs.getInt("année");
                String theme = rs.getString("nom_theme");
                String intitulé = rs.getString("intitulé");
                double indicateur = rs.getFloat("indicateur");
                String source_inf = rs.getString("source_information");
                String periode = rs.getString("periode");
                int partenaire = rs.getInt("partenaire");
                String source_fin = rs.getString("source_financiere");
                String etat = rs.getString("état");
            
                TestActivité e = new TestActivité(direction, année, theme, intitulé, indicateur, source_inf, etat, source_fin, partenaire, periode);
  			  
  			  
  			  TestActivités.add(e); 
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return TestActivités;
    }
    
    
	
    public DirecteurServlet1() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try {
		String nom_direction = request.getParameter("nom_direction");
		

        

		List<TestActivité> listTestActivité = selectAllTestActivité(nom_direction);
		
		request.setAttribute("listTestActivités", listTestActivité);
		request.getRequestDispatcher("AffichageActivités.jsp").forward(request, response);
		System.out.println("succéé d'affichage");
        }
        catch (Exception ex) {
    		System.out.println(ex);

        }
		
	}

}
