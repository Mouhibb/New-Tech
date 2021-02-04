package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	
	public static void main(String[] args) {
        try
        {           
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
            System.out.println("cnx etablie");
        }
        catch(SQLException e)
        {
           System.out.println(e);
        }
    }

}
