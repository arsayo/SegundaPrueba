package pokemon;

import java.util.HashMap;


public class Poke2 {
	
	private String name;
	private String type;
	private int healthpoints;
	private HashMap<String, Integer> atacks = new HashMap<String, Integer>();
	
public Poke2 () {
	  
	atacks.put("Tackle", 10); 
	atacks.put("Scratch", 15); 
	name= "";
	type="";
	healthpoints=0;	
	
}


public Poke2(String n,String t, int hp) {
	atacks.put("Tackle", 10); 
	atacks.put("Scratch", 15);
	name=n;
	type=t;
	healthpoints=hp;
	
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public HashMap<String,Integer> getAtacks() {
	return atacks;
}

public void addAtacks(String name, int damage) {
	this.atacks.put(name, damage);
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getHealthpoints() {
	return healthpoints;
}

public void setHealthpoints(int healthpoints) {
	this.healthpoints = healthpoints;
}

}
