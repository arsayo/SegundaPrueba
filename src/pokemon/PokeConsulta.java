package pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class PokeConsulta {
	
	PokeConexion miConexion;
	PokemonsC myPokemon=null;
	
	public PokeConsulta() {
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
			System.out.println(rs.getString(2));
			myPokemon=new PokemonsC(rs.getString(2),rs.getString(3));
					
			rs.close();
			
		//4. REUTILIZAR LA CONSULTA	
			
			for (int i=1;i<8;i+=3) {
				miSentencia.setInt(1, i);
			
					rs=miSentencia.executeQuery();
					rs.next();
					System.out.println(rs.getString("NAME"));
					//myPokemon=new PokemonsC(rs.getString("NAME"), rs.getString("NAMET"));
					myPokemon.setTrainer(rs.getString("NAME"), rs.getString("NAMET"));
					
			}
				
			
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
	
	/*public String nameAttack(String i) {
		List<String> nameAttack=new ArrayList<String>();
	if(i=="w")	{
		
		for(String ata:myPokemon.getAttacks().keySet()) {
			
			nameAttack.add(ata);
		}
		
		return (String) nameAttack.get(new Random().nextInt(nameAttack.size()));
	}else if(i=="t") {
		String[] trainerAttack=nameAttack.toArray(new String[0]);
		
		int selectAttack= JOptionPane.showOptionDialog(null, "¿What will " + trainerPoke + " do?", "Message", 
						JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,trainerAttack,trainerAttack);
		
		new PokeWindow().trainerAttack(trainerPoke,trainerAttack[selectAttack]);
		
	}
	}*/
	
	public String namet() {
		ArrayList<String> pokeTrain = new ArrayList<String>();
		
		for (String i : myPokemon.getTrainer().keySet()) {   
			
			pokeTrain.add(i);
			
		}
		
		String [] selectName= {"SQUIRTLE", "CHARMANDER", "BULBASAUR"};
		int x= JOptionPane.showOptionDialog(null, "Select your initial pokemon", "Message", JOptionPane.DEFAULT_OPTION,
		       JOptionPane.INFORMATION_MESSAGE,null,selectName,selectName[0]);
	
		return pokeTrain.get(x);
	
	}
	
	public String typet(String name) {
		
		return myPokemon.getTrainer().get(name);
	}

}
