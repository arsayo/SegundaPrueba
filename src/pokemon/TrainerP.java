package pokemon;

import java.util.HashMap;

public class TrainerP {
	
	private String n;
	private String t;
	private int l;
	private HashMap<String, String> pokeTra = new HashMap<String, String>(); 

	
	public TrainerP() {
		
		t="";
		n="";
		
		
	}
	
	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public HashMap<String, String> getPokeTra() {
		return pokeTra;
	}

	public void addPokeTra(String n,String t) {
		this.pokeTra.put(n,t);
	}

}
