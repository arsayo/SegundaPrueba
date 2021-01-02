package pokemon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ConfirmDialog2 extends JFrame {

    public ConfirmDialog2() {

        getContentPane().setBackground(new Color(238, 232, 170));
        getContentPane().setLayout(null);
        setTitle("Confirm Dialog in Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(450, 300);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

    }

    public JPanel panel() {

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 444, 271);
        panel.setBackground(new Color(176, 224, 230));
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblIcon = new JLabel("");
        lblIcon.setBounds(30, 30, 200, 200);
        lblIcon.setIcon(new ImageIcon("src/images/girl200.png"));
        panel.add(lblIcon);

        JLabel lblText2 = new JLabel("Lauren is the 4th daughter!");
        lblText2.setVerticalAlignment(SwingConstants.TOP);
        lblText2.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblText2.setHorizontalAlignment(SwingConstants.CENTER);
        lblText2.setBounds(240, 130, 175, 100);
        panel.add(lblText2);

        JLabel lblText1 = new JLabel("Yaaaay!");
        lblText1.setHorizontalAlignment(SwingConstants.CENTER);
        lblText1.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblText1.setBounds(240, 30, 175, 100);
        panel.add(lblText1);

        return panel;

    }

    public static void main(String[] args) {

        ConfirmDialog2 cdframe = new ConfirmDialog2();
        ImageIcon icon = new ImageIcon("src/images/girl64.png");
        String[] options = {"Mary", "Nora", "Anna", "Lauren"};
        int x = JOptionPane.showOptionDialog(cdframe, "Lauren's mom had four kids: Maria, Martha, Margaret...",
                "The missing kid", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);

        if (x == 3) {
            cdframe.getContentPane().add(cdframe.panel());
            cdframe.repaint();
            cdframe.revalidate();
        } else {
            cdframe.dispose();
            JOptionPane.showMessageDialog(null, "Nooope!");
        }

    }
}
