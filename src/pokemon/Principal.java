package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Principal {
	
	static TrainerP tPoke;
	PokemonsB pokeAttack;
	String trainerPoke;
	String wildName;

	public static void main(String[] args) {
		
		// Se instancia y se ejecuta la consulta-------------------------------------------------------
		PokeConsulta pokeConsulta=new PokeConsulta();
		
		pokeConsulta.ejecutaConsulta();
		
		// Se obtienen el nombre y tipo del pokemon del entrenador------------------------------------
		String initName=pokeConsulta.namet();
		
		String trainerType=pokeConsulta.typet(initName);
		
		// Se instancia la clase TrainerP y se le asigna el pokemon inicial--------------------------
		tPoke=new TrainerP();
		
		tPoke.setN(initName);
		tPoke.setT(trainerType);
		tPoke.addPokeTra(initName, trainerType);
		
		// Se llama al método de la secuencia de batalla----------------------------------------------
		new Principal().pokeFight(pokeConsulta);
			
	}
	

	
	public void pokeFight(PokeConsulta pokeConsulta) {
		
		// Se definen los nombres y la vida del pokemon salvaje y del pokemon del entrenador------------
		wildName=pokeConsulta.wname();
		
		String wildType=pokeConsulta.wtype();
		
		int wildLife=new PokemonsB().getlife();
		
		int trainerLife=new PokemonsB().getlife();
		
		new PokeWindow().pokeWindow(wildName, wildLife); // JOptionPane... aparece el pokemon salvaje
		
		trainerPoke=selectPoke(); // Se llama al método para elegir al pokemon que se usará en batalla...
		
		new PokeWindow().pokeWindow(trainerPoke, trainerLife, 0); // JOptionPane... aparece el pokemon del entrenador
		
		
		String [] options= {"Fight", "Run"};
		int actions= JOptionPane.showOptionDialog(null, "¿What will " + trainerPoke + " do?", "Message", 
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		
		if(actions==0) {
			
			int trainerhp; 
			int wildhp;
			
			do {
				
				wildhp=getWildPokemonHp(wildLife); // Comienza la secuencia de pelea (ataca el pokemon del entrenador)
				
				if(wildhp>0){
					new PokeWindow().pokeHp(wildName, wildhp);
					//if(wildhp<10 && Trainer.team.size()<6) new Trainer().getCaughtPokemon();
				}
				else{
					new PokeWindow().pokeFaint(wildName);
					Whatodo();	
				}
				
				trainerhp=getTrainerPokemonHp(trainerLife); 
				
				if (trainerhp>0) {
					new PokeWindow().pokeHp(trainerPoke, trainerhp);
				}
				else{
					new PokeWindow().pokeFaint(trainerPoke);
					System.exit(0);	
				}
				
				
				trainerLife=trainerhp;
				wildLife=wildhp;	
					
			}while (trainerhp>0 && wildhp>0);
			
		}
		else{
			new Pokemons().pokeWindow(0);
			System.exit(0);
			
		}
		
	}
		

	
	public String selectPoke () { 
		
		List<String> list=new ArrayList<String>();
	
		for(String i: tPoke.getPokeTra().keySet()) {
			
			list.add(i);
		}
			
		String [] ops=list.toArray(new String[0]);

		int does2= JOptionPane.showOptionDialog(null, "¡Choose your pokemon!", "Message", 
				JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ops,ops);
		
		return list.get(does2);
			
	}
	
public int getRandomPokemonAttack() {
		
		ArrayList<String> wild=new ArrayList<String>();
		
		pokeAttack=new PokemonsB();
		
		for (String z:pokeAttack.getAtacks().keySet()){
			
			wild.add(z);
			
		}
		
		String wildAttack=(String) wild.get(new Random().nextInt(wild.size()));
		
		new PokeWindow().wildAttack(wildName, wildAttack);
		
		return pokeAttack.getAtacks().get(wildAttack);
		
	}

public int  getTrainerPokemonAttack() {
	
	List<String> trainer=new ArrayList<String>();
	
	pokeAttack=new PokemonsB();
	
	for (String j:pokeAttack.getAtacks().keySet()){
		
		trainer.add(j);
		
	}
	
	String[] trainerAttack=trainer.toArray(new String[0]);
	
	int selectAttack= JOptionPane.showOptionDialog(null, "¿What will " + trainerPoke + " do?", "Message", 
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,trainerAttack,trainerAttack);
	
	new PokeWindow().trainerAttack(trainerPoke,trainerAttack[selectAttack]);
	
	return pokeAttack.getAtacks().get(trainerAttack[selectAttack]);
	
}



public int getTrainerPokemonHp(int trainerHp) {

	int trainerPokemonHp=trainerHp-getRandomPokemonAttack();
	return trainerPokemonHp;
}

public int getWildPokemonHp(int wildHp) {

	int wildPokemonHp=wildHp-getTrainerPokemonAttack();
	return wildPokemonHp;
	
}

public void Whatodo(){
	
	String [] ops= {"Keep going", "Run"};
	int todo= JOptionPane.showOptionDialog(null, "¿What will you do?", "Message", 
			JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ops,ops[0]);
	
	switch(todo){
	case 0:
		PokeConsulta pokeConsulta=new PokeConsulta();
		pokeConsulta.ejecutaConsulta();
		new Principal().pokeFight(pokeConsulta);
		
	case 1:
		JOptionPane.showMessageDialog(null, "¡Got away safely!", null,1,null);
		System.exit(1);
		
	}
}

}
