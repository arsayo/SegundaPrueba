package pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

public class PokemonsB {
	
	public PokemonsB() {
		
		name="";
		type="";
		namet="";
		typet="";
		attacks.put("Tackle", 10); 
		attacks.put("Scratch", 15); 
		trainer.put(typet, namet);
		
	}
	
	public PokemonsB(String n, String t) {
		attacks.put("Tackle", 10); 
		attacks.put("Scratch", 15);
		name=n;
		type=t;
		namet="";
		typet="";
		trainer.put(typet, namet);
		
	}
	
	private String name;
	private String type;
	private String namet;
	private String typet;
	private int ind;
	private HashMap<String, Integer> attacks= new HashMap<String, Integer>();
	private HashMap<String, String> trainer= new HashMap<String, String>();
	
	
	public HashMap<String,Integer> getAtacks() {
		return attacks;
	}

	public void addAtacks(String namea, int damage) {
		this.attacks.put(namea, damage);
	}


	public HashMap<String,String> getPoket() {
		return trainer;
	}

	public void addPoket(String type, String name) {
		this.trainer.put(type, name);
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
	
}
