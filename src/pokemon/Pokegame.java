package pokemon;

import java.util.*;
import javax.swing.JOptionPane;

public class Pokegame {
	
	public Pokegame() {}
	
	
public static void main(String [] args) {
		
	 	Pokemons teste1=new Pokemons();
	
		Poke2 trainerpoke= teste1.getTrainerPokemon();
	
		Trainer.team.add(trainerpoke);
		
		pokenametrainer=trainerpoke.getName();
	
		
		new Pokegame().Fight();
		
	}


public void Fight() {	
	
	wildpoke=new Pokemons().getWildPokemon();
	
	new Pokemons().pokeWindow(wildpoke.getName(),wildpoke.getHealthpoints(),0,"");
	
	select();
	
	trainerHP3=Pokemons.getHp();	
	
	new Pokemons().pokeWindow(pokenametrainer, trainerHP3,1,"");
	
	String [] options= {"Fight", "Run"};
	int actions3= JOptionPane.showOptionDialog(null, "¿What will " + pokenametrainer + " do?", "Message", 
				JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
	
	if(actions3==0) {
	
		int trainerhp;
		int wildhp;
		int trainerHp=trainerHP3;
		int wildHp=wildpoke.getHealthpoints();
		
		do{
			wildhp=new Pokemons().getWildPokemonHp(wildHp);
			
			if(wildhp>0){
				new Pokemons().pokeWindow(wildpoke.getName(),wildhp,2,"");
				if(wildhp<10 && Trainer.team.size()<6) new Trainer().getCaughtPokemon();
			
			}else{
				new Pokemons().pokeWindow(wildpoke.getName(),0);
				Whatodo();	
				
			}
			
			trainerhp=new Pokemons().getTrainerPokemonHp(trainerHp);
			
			if (trainerhp>0) new Pokemons().pokeWindow(pokenametrainer, trainerhp,2,"");
			else{
				new Pokemons().pokeWindow(pokenametrainer,0);
				System.exit(0);
				
			}
			
			trainerHp=trainerhp;
			wildHp=wildhp;	
				
		}while (trainerhp>0 && wildhp>0);
		
	}
	else{
		new Pokemons().pokeWindow(0);
		System.exit(0);
		
	}
	
}


public void Whatodo(){
	
	String [] ops= {"Keep going", "Run"};
	int todo= JOptionPane.showOptionDialog(null, "¿What will you do?", "Message", 
			JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ops,ops[0]);
	
	switch(todo){
	case 0:
		
		new Pokegame().Fight();
		
	case 1:
		new Pokemons().pokeWindow(0);
		System.exit(1);
		
	}
}


public static void select () { 
	
	List<String> list=new ArrayList<String>();
		
	for(int i=0;i<Trainer.team.size();i++) list.add(Trainer.team.get(i).getName());
		
	String [] ops=list.toArray(new String[0]);

	int does2= JOptionPane.showOptionDialog(null, "¡Choose your pokemon!", "Message", 
			JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ops,ops);
	
	pokenametrainer=Trainer.team.get(does2).getName();
		
}

static Poke2 wildpoke;
static String pokenametrainer;
private int trainerHP3;

}
	



	
