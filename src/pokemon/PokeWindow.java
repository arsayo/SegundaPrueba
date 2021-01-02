package pokemon;

import javax.swing.JOptionPane;

public class PokeWindow {
	
public void pokeWindow(String name, int hp) {
		
	JOptionPane.showMessageDialog(null, "¡Wild " + name + " appeared!" + "  HP: " +hp, null, JOptionPane.WARNING_MESSAGE,null);
	}

public void pokeWindow(String name, int hp, int ind) {
	
	JOptionPane.showMessageDialog(null, "¡Go " + name + "!" + "  HP: " +hp, null, JOptionPane.WARNING_MESSAGE,null);
}

public void wildAttack(String name,String attack) {
	
	JOptionPane.showMessageDialog(null,"¡" + name + " used "+ attack + "!", "¡Fight!", JOptionPane.WARNING_MESSAGE,null);
}

public void trainerAttack(String name, String attack) {
	
	JOptionPane.showMessageDialog(null,"¡" + name + " used "+ attack + "!","¡Fight!", JOptionPane.WARNING_MESSAGE,null);
}

public void pokeHp(String name, int hp) {
	
	JOptionPane.showMessageDialog(null,name + "  HP: " + hp, null, JOptionPane.WARNING_MESSAGE,null);
}

public void pokeFaint(String name) {
	
	JOptionPane.showMessageDialog(null, "¡" + name + " fainted!", null,0,null);
}


}
