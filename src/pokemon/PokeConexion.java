package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PokeConexion {
	
	Connection miConexion=null;
	
	public PokeConexion() {
		
	}
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		// 1. CREAR CONEXIÓN	
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pokemon?autoReconnect=true&useSSL=false","root","");
		
		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(ClassNotFoundException e2) {
			e2.printStackTrace();
			
		}
		
		return miConexion;
		
	}
	

}
