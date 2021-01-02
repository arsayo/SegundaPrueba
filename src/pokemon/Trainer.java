package pokemon;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Trainer extends Pokegame {
	
public Trainer(){
		
	}
	
	static ArrayList<Poke2> team = new ArrayList<Poke2>();
	
/*public String getTrainerName() {

	String trainername=JOptionPane.showInputDialog("What's your name:");
	
	while (trainername.isEmpty()) {
		
			trainername=JOptionPane.showInputDialog("What's your name:");

			System.out.println("a");
			
	}
	return trainername;
	}*/

public void getCaughtPokemon() {

	String [] options= {"Pokeball", "Run"};
	int does= JOptionPane.showOptionDialog(null, "¿What will you do?", "Message", 
			JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

	if (does==0){
		
		int pokeball=new Random().nextInt(2);
	
	if (pokeball==1){
	
		team.add(wildpoke);
		counter++;	
		new Pokemons().pokeWindow(wildpoke.getName(),1);
		if (counter>=1) Whatodo();
		
	}
	else{
		
		new Pokemons().pokeWindow(2);
	}
	
	}
	else{
		new Pokemons().pokeWindow(0);
		Whatodo();
		
	}
}

private int counter;

}

	

		





