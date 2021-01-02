package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

public class Prueba {
	
	private String name;
	private String type;
	private String namet;
	private String typet;
	private HashMap<String, Integer> atacks = new HashMap<String, Integer>();
	private HashMap<String, String> trainer = new HashMap<String, String>();
	
public Prueba() {
	
	atacks.put("Tackle", 10); 
	atacks.put("Scratch", 15); 
	
}
	
public HashMap<String,Integer> getAtacks() {
	return atacks;
}

public void addAtacks(String namea, int damage) {
	this.atacks.put(namea, damage);
}


public HashMap<String,String> getPoket() {
	return trainer;
}

public void addPoket(String namet, String typet) {
	this.trainer.put(namet, typet);
}



	
	public int getlife() {
		int life=new Random().nextInt(90)+10;
		return life;
	}


	 public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
	}
	

	void Algo() {
	
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
		//1. CREAR LA CONEXIÓN
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pokemon?autoReconnect=true&useSSL=false","root","");
		
		//2. PREPARAR LA CONSULTA
			//PreparedStatement miSentencia=miConexion.prepareStatement("SELECT * FROM POKEMONS WHERE ID=?");
			PreparedStatement miSentencia=miConexion.prepareStatement("SELECT POKEMONS.ID,NAME, TYPES.NAMET FROM POKEMONS INNER JOIN TYPES ON POKEMONS.TYPE=TYPES.IDT WHERE ID=?");
			int hp=new Random().nextInt(19)+1;
			System.out.println(hp);
			
			
		//3. ESTABLECER PARÁMETROS DE CONSULTA
			miSentencia.setInt(1,hp);
	
		//4. EJECUTAR CONSULTA	
			ResultSet rs=miSentencia.executeQuery();
			rs.next();
			
			name=rs.getString(2);
			
			type=rs.getString(3);
			
			rs.close();		
			
		//5. REUTILIZAR LA CONSULTA	
			for (int i=1;i<8;i+=3) {
				miSentencia.setInt(1, i);
				
					rs=miSentencia.executeQuery();
					rs.next();
					
					namet=rs.getString("NAME");
					
					typet=rs.getString("NAMET");
					
					trainer.put(namet, typet);	
			
			}
			
			
			rs.close();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		
	}	
	
}




	
	
	




