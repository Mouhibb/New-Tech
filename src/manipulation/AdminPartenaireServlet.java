package manipulation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Partenaire;
/**
 * Servlet implementation class AdminPartenaireServlet
 */
@WebServlet("/")
public class AdminPartenaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	private String jdbcURL = "jdbc:mysql://localhost:3306/db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
        private static final String INSERT = "INSERT INTO partenaire" + "  (nom_partenaire, email) VALUES " +
            " (?, ?);";

        private static final String SELECT_ALL = "SELECT * FROM partenaire";
        private static final String DELETE = "DELETE FROM partenaire WHERE nom_partenaire = ? AND email = ?;";
        private static final String UPDATE = "update partenaire set nom_partenaire = ? , email = ? where nom_partenaire = ? and email = ?;";


        
        
        
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
        public void insertPartenaire(String nom, String mail) throws SQLException {
            
            // try-with-resource statement will auto close the connection.
            try (Connection connection = getConnection(); 
            	PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, mail);
                

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
        
        
        
        public List < Partenaire > selectAllPartenaire() {
    		List<Partenaire> partenaires = new ArrayList<Partenaire>();

            // using try-with-resources to avoid closing resources (boiler plate code)
            // Step 1: Establishing a Connection
            try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    String nom = rs.getString("nom_partenaire");
                    String emaile = rs.getString("email");
                    Partenaire e = new Partenaire(nom,emaile);
      			  
      			  
      			  partenaires.add(e); 
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return partenaires;
        }
        
        public boolean deletePartenaire(String nom_Partenaire, String email) throws SQLException {
            boolean rowDeleted;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE);) {
                statement.setString(1, nom_Partenaire);
                statement.setString(2, email);

                rowDeleted = statement.executeUpdate() > 0;
            }
            return rowDeleted;
        }
      
        public boolean updatePartenaire(String nv,String nm,String n,String m) throws SQLException {
            boolean rowUpdated;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE);) {
                statement.setString(1, nv);
                statement.setString(2, nm);
                statement.setString(3, n);
                statement.setString(4, m);


                

                rowUpdated = statement.executeUpdate() > 0;
            }
            return rowUpdated;
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
	
    
    

    
    public AdminPartenaireServlet() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	 
	  
        

		
		
		
		
		
		
		
		
		
	

        String action2 = request.getServletPath();
        
        try {
            switch (action2) {
                case "/AdminAjouter":
                    ReponseAjouterPartenaire(request, response);
                    break;
                
                case "/AdminSupprimer":
                    ReponseSupprimerPartenaire(request, response);
                    break;
                case "/AdminAfficher":
                    ReponseAfficherPartenaire(request, response);
                    break;
                case "/AdminModifier":
                    ReponseModifierPartenaire(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	private void ReponseAjouterPartenaire(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        String nom_partenaire = request.getParameter("nom_partenaire");
		        String email_partenaire = request.getParameter("email_partenaire");
		        insertPartenaire(nom_partenaire, email_partenaire);
		        System.out.println("succéé ajout");
		        String msg2="partenaire ajoutée avec succées";
		        request.setAttribute("msg2", msg2);
	    		request.getRequestDispatcher("/admin2.jsp").forward(request, response);
		        
		        
		    }
 private void ReponseModifierPartenaire(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        String nom_partenaire = request.getParameter("nom_partenaire");
		        String email_partenaire = request.getParameter("email_partenaire");
		        String nouveau_nom_partenaire = request.getParameter("nouveau_nom_partenaire");
		        String nouvelle_email_partenaire = request.getParameter("nouvelle_email_partenaire");


		        
		        updatePartenaire(nouveau_nom_partenaire,nouvelle_email_partenaire,nom_partenaire,email_partenaire);
		        
		        String msg2="partenaire modifiée avec succées";
		        request.setAttribute("msg2", msg2);
	    		request.getRequestDispatcher("/admin2.jsp").forward(request, response);
		        
		        
		    }
 private void ReponseSupprimerPartenaire(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        String nom_partenaire = request.getParameter("nom_partenaire");
		        String email_partenaire = request.getParameter("email_partenaire");
		        deletePartenaire(nom_partenaire,email_partenaire);
		        
		        String msg2="partenaire supprimée avec succées";
		        request.setAttribute("msg2", msg2);
	    		request.getRequestDispatcher("/admin2.jsp").forward(request, response);
		        
		        
		    }
 private void ReponseAfficherPartenaire(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
	        List<Partenaire> listPartenaire = selectAllPartenaire();
		        
		        request.setAttribute("listPartenaires", listPartenaire);
	    		request.getRequestDispatcher("AffichePartenaires.jsp").forward(request, response);
		        
		        
		    }
	
}
