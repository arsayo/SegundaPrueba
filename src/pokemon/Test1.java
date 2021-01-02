package pokemon;

import javax.swing.JFrame;

public class Test1 {

	public static void main(String[] args) {
		
		PokeConsulta pokeConsulta=new PokeConsulta();
		
		pokeConsulta.ejecutaConsulta();
		
		String initName=pokeConsulta.namet();
		
		String trainerType=pokeConsulta.typet(initName);
		
		//String wildName=pokeConsulta.wname();
		
		//String wildType=pokeConsulta.wtype();
		
		System.out.println(initName + "    " +  trainerType);
		
		//System.out.println(wildName + "    " +  wildType);
		
		/*Marco_P miMarco=new Marco_P();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);*/
		
	}

}
