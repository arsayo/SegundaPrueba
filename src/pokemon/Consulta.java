package pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Consulta {
	
	PokeConexion miConexion;
	PokemonsB myPokemon=null;
	
	public Consulta() {
		miConexion=new PokeConexion();
	}
	
	public void ejecutaConsulta() {
		
		Connection accessBBDD=miConexion.getConnection();
		
		try {
		
		// 1. PREPARAR LA CONSULTA	
			PreparedStatement miSentencia=accessBBDD.prepareStatement("SELECT POKEMONS.ID,NAME, TYPES.NAMET FROM POKEMONS INNER JOIN TYPES ON POKEMONS.TYPE=TYPES.IDT WHERE ID=?");
			int hp=new Random().nextInt(19)+1;
			System.out.println(hp);
		// 2. ESTABLECER PARÁMETROS DE CONSULTA
			miSentencia.setInt(1, hp);
		
		// 3. EJECUTAR CONSULTA
			ResultSet rs=miSentencia.executeQuery();
			rs.next();
			
			myPokemon=new PokemonsB();
			System.out.println(rs.getString(2));
			myPokemon.setName(rs.getString(2));
			
			myPokemon.setType(rs.getString(3));
					
			rs.close();	
			
		//4. REUTILIZAR LA CONSULTA	
			//int ind=1;
			for (int i=1;i<8;i+=3) {
				miSentencia.setInt(1, i);
				
					rs=miSentencia.executeQuery();
					rs.next();
					
					myPokemon.addPoket(rs.getString("NAME"), rs.getString("NAMET"));
					//myPokemon.addPoket2(ind, rs.getString("NAMET"));	
					//ind++;
			
			}
			rs.close();	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String wname() {
		return myPokemon.getName();
	}
	
	public String wtype() {
		return myPokemon.getType();
	}
	
	public String namet() {
		ArrayList<String> pokeTrain = new ArrayList<String>();
		
		for (String i : myPokemon.getPoket().keySet()) {   
			System.out.println(i);
			pokeTrain.add(i);
			
		}
		
		String [] selectName= {"SQUIRTLE", "CHARMANDER", "BULBASAUR"};
		int x= JOptionPane.showOptionDialog(null, "Select your initial pokemon", "Message", JOptionPane.DEFAULT_OPTION,
		       JOptionPane.INFORMATION_MESSAGE,null,selectName,selectName[0]);
	
		return pokeTrain.get(x+1);
	}
	
	public String typet(String name) {
		
		return myPokemon.getPoket().get(name);
	}
	
	

}
