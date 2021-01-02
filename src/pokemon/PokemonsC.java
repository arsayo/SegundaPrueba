package pokemon;

import java.util.HashMap;
import java.util.Random;

public class PokemonsC {

	private String namet;
	private String typet;
	private String name;
	private String type;
	private HashMap<String, Integer> attacks= new HashMap<String, Integer>();
	private HashMap<String, String> trainer= new HashMap<String, String>();
	
	public String getNamet() {
		return namet;
	}


	public void setNamet(String namet) {
		this.namet = namet;
	}


	public String getTypet() {
		return typet;
	}


	public void setTypet(String typet) {
		this.typet = typet;
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


	public HashMap<String, Integer> getAttacks() {
		return attacks;
	}


	public void setAttacks(String namea, int damage) {
		this.attacks.put(namea, damage);
	}


	public HashMap<String, String> getTrainer() {
		return trainer;
	}


	public void setTrainer(String name, String type) {
		this.trainer.put(name, type);
	}
	
	public int getlife() {
		int life=new Random().nextInt(90)+10;
		return life;
	}


	public PokemonsC(String name, String type) {
		
		this.name = name;
		this.type = type;
		attacks.put("Tackle", 10); 
		attacks.put("Scratch", 15);
	}
	
	/*public PokemonsC(String namet, String typet) {
		
		this.namet = namet;
		this.typet = typet;
		addTrainer(getNamet(), getTypet());
		attacks.put("Tackle", 10); 
		attacks.put("Scratch", 15);
	
	}*/
	
	
}
