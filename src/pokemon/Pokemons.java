package pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pokemons extends Pokegame {
	
	Poke2 pokes=new Poke2();
	
public static  int getHp () {
		 
		int hp=new Random().nextInt(90)+10;
			return hp;
			
	}
	
	private HashMap<String, String> pokemonss = new HashMap<String, String>(); 
	private ArrayList<Poke2> wildPokemons = new ArrayList<Poke2>();
	
	Random rand=new Random();
	
public Pokemons() {
		
		pokemonss.put("Charmander", "Fuego"); 
		pokemonss.put("Charmeleon", "Fuego"); 
		pokemonss.put("Charizard", "Fuego");
		pokemonss.put("Bulbasaur", "Planta"); 
		pokemonss.put("Ivysaur", "Planta"); 
		pokemonss.put("Venusaur", "Planta");
		pokemonss.put("Squirtle", "Agua");
		pokemonss.put("Wartortle", "Agua"); 
		pokemonss.put("Blastoise", "Agua");
		pokemonss.put("Caterpie", "Bicho");
		pokemonss.put("Metapod", "Bicho");
		pokemonss.put("Butterfree", "Bicho");
		pokemonss.put("Weedle", "Bicho"); 
		pokemonss.put("Kakuna", "Bicho"); 
		pokemonss.put("Beedrill", "Bicho");
		pokemonss.put("Pidgey", "Normal");
		pokemonss.put("Pidgeotto", "Normal");
		pokemonss.put("Pidgeot", "Normal");
		pokemonss.put("Rattata", "Normal");
		pokemonss.put("Raticate", "Normal");
		pokemonss.put("Spearow", "Normal");
		pokemonss.put("Fearow", "Normal");
		pokemonss.put("Ekans", "Veneno");
		pokemonss.put("Arbok", "Veneno");
		pokemonss.put("Pikachu", "Eléctrico");
		pokemonss.put("Raichu", "Eléctrico");
		
			
		for (String i : pokemonss.keySet()) {   
		
			Poke2 miPoke=new Poke2(i, pokemonss.get(i), getHp());
			wildPokemons.add(miPoke);
			
		}
		
	}
	
	
public Poke2 getTrainerPokemon() {
		
		HashMap<String, String> trainpokemonss = new HashMap<String, String>(); 
		ArrayList<Poke2> trainPokemons = new ArrayList<Poke2>();
		
		trainpokemonss.put("Charmander", "Fuego"); 
		trainpokemonss.put("Bulbasaur", "Planta"); 
		trainpokemonss.put("Squirtle", "Agua");
		
		for (String i : trainpokemonss.keySet()) {   
			
			Poke2 miPoke2=new Poke2(i, trainpokemonss.get(i), getHp());
			trainPokemons.add(miPoke2);
			
		}
		
		String [] selectName= {"Charmander", "Bulbasaur", "Squirtle"};
		int x= JOptionPane.showOptionDialog(null, "Select your initial pokemon", "Message", JOptionPane.DEFAULT_OPTION,
		       JOptionPane.INFORMATION_MESSAGE,null,selectName,selectName[0]);
		Poke2 myspokes=trainPokemons.get(x);
		return myspokes;
		
	}


public  Poke2 getWildPokemon() {
	
		Poke2 wildpoke=wildPokemons.get(rand.nextInt(wildPokemons.size()));
		return wildpoke;
		
	}

public int getRandomPokemonAttack() {
		
		ArrayList<String> wild=new ArrayList<String>();
		
		for (String z:pokes.getAtacks().keySet()){
			
			wild.add(z);
			
		}
		
		String wildAttack=(String) wild.get(rand.nextInt(wild.size()));
		
		new Pokemons().pokeWindow(wildpoke.getName(),0,4,wildAttack);
		
		return pokes.getAtacks().get(wildAttack);
		
	}


public int  getTrainerPokemonAttack() {
		
		List<String> trainer=new ArrayList<String>();
		
		for (String j:pokes.getAtacks().keySet()){
			
			trainer.add(j);
			
		}
		
		String[] pokeTrainerAttack=trainer.toArray(new String[0]);
		
		int fightSequence= JOptionPane.showOptionDialog(null, "¿What will " + Pokegame.pokenametrainer + " do?", "Message", 
						JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,pokeTrainerAttack,pokeTrainerAttack);
		
		new Pokemons().pokeWindow(Pokegame.pokenametrainer,0,3,pokeTrainerAttack[fightSequence]);
		
		int trainerPokemonAttack=new Poke2().getAtacks().get(pokeTrainerAttack[fightSequence]);
		
		return trainerPokemonAttack;
		
	}



public int getTrainerPokemonHp(int trainerHp) {

		return trainerHp-getRandomPokemonAttack();
		
	}


public int getWildPokemonHp(int wildHp) {

		return wildHp-getTrainerPokemonAttack();
		
	}

public void pokeWindow(String name, int hp,int c,String attack) {
		
		HashMap<String, String> window = new HashMap<String, String>(); 
		
		window.put("Charmander","C:/Users/Arturo/Desktop/JAA/pokemon/charmander.png" );
		window.put("Charmeleon","C:/Users/Arturo/Desktop/JAA/pokemon/charmeleon.png" );
		window.put("Charizard","C:/Users/Arturo/Desktop/JAA/pokemon/charizard.png" );
		window.put("Bulbasaur","C:/Users/Arturo/Desktop/JAA/pokemon/bulbasaur.png" );
		window.put("Ivysaur","C:/Users/Arturo/Desktop/JAA/pokemon/ivysaur.png" );
		window.put("Venusaur","C:/Users/Arturo/Desktop/JAA/pokemon/venusaur.png" );
		window.put("Squirtle","C:/Users/Arturo/Desktop/JAA/pokemon/squirtle.png" );
		window.put("Wartortle","C:/Users/Arturo/Desktop/JAA/pokemon/wartortle.png" );
		window.put("Blastoise","C:/Users/Arturo/Desktop/JAA/pokemon/blastoise.png" );
		window.put("Caterpie","C:/Users/Arturo/Desktop/JAA/pokemon/caterpie.png" );
		window.put("Metapod","C:/Users/Arturo/Desktop/JAA/pokemon/metapod.png" );
		window.put("Butterfree","C:/Users/Arturo/Desktop/JAA/pokemon/butterfree.png" );
		window.put("Weedle","C:/Users/Arturo/Desktop/JAA/pokemon/weedle.png" );
		window.put("Kakuna","C:/Users/Arturo/Desktop/JAA/pokemon/kakuna.png" );
		window.put("Beedrill","C:/Users/Arturo/Desktop/JAA/pokemon/beedrill.png" );
		window.put("Pidgey","C:/Users/Arturo/Desktop/JAA/pokemon/pidgey.png" );
		window.put("Pidgeotto","C:/Users/Arturo/Desktop/JAA/pokemon/pidgeotto.png" );
		window.put("Pidgeot","C:/Users/Arturo/Desktop/JAA/pokemon/pidgeot.png" );
		window.put("Rattata","C:/Users/Arturo/Desktop/JAA/pokemon/rattata.png" );
		window.put("Raticate","C:/Users/Arturo/Desktop/JAA/pokemon/raticate.png" );
		window.put("Spearow","C:/Users/Arturo/Desktop/JAA/pokemon/spearow.png" );
		window.put("Fearow","C:/Users/Arturo/Desktop/JAA/pokemon/fearow.png" );
		window.put("Ekans","C:/Users/Arturo/Desktop/JAA/pokemon/ekans.png" );
		window.put("Arbok","C:/Users/Arturo/Desktop/JAA/pokemon/arbok.png" );
		window.put("Pikachu","C:/Users/Arturo/Desktop/JAA/pokemon/pikachu.png" );
		window.put("Raichu","C:/Users/Arturo/Desktop/JAA/pokemon/raichu.png" );
		
		ImageIcon icon=new ImageIcon(window.get(name));
		
		if(window.containsKey(name) && c==0) {
		JOptionPane.showMessageDialog(null, "¡Wild " + name + " appeared!" + "  HP: " +hp, null, JOptionPane.WARNING_MESSAGE,icon);
	
		}else if(window.containsKey(name) && c==1) {
			JOptionPane.showMessageDialog(null, "¡Go " + name + "!" + "  HP: " +hp, null, JOptionPane.WARNING_MESSAGE,icon);
		
		}else if(window.containsKey(name) && c==2) {
			JOptionPane.showMessageDialog(null,name + "  HP: " + hp, null, JOptionPane.WARNING_MESSAGE,icon);
		
		}else if(window.containsKey(name) && c==3) {
			JOptionPane.showMessageDialog(null,"¡" + name + " used "+ attack + "!","¡Fight!", JOptionPane.WARNING_MESSAGE,icon);
		
		}else if(window.containsKey(name) && c==4) {
			JOptionPane.showMessageDialog(null,"¡" + name + " used "+ attack + "!", "¡Fight!", JOptionPane.WARNING_MESSAGE,icon);
		}
			
	}
	
public void pokeWindow(String name, int o) {
		
		if(o==0) {
		JOptionPane.showMessageDialog(null, "¡" + name + " fainted!", null,0,null);
		}else if(o==1) {
		JOptionPane.showMessageDialog(null, "¡Wild " + name + " captured!", null,1,null);
		}
	}
	
public void pokeWindow(int n) {
		
		if(n==0)		JOptionPane.showMessageDialog(null, "¡Got away safely!", null,1,null);
		else if(n==2)	JOptionPane.showMessageDialog(null, "¡Wild Pokemon escaped!", null,1,null);	
		
	}
	
	
}
















