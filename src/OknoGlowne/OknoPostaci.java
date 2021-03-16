package OknoGlowne;


import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Hero.Hero;

		

			// Program wykona³: Tomasz £ogisz
			// 		Nr indeksu: 241370
			//			  Data: 21.10.2018

public class OknoPostaci extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	


	private Hero hero;

	

	Font font = new Font("MonoSpaced", Font.BOLD, 12);
	
	
	JLabel nazwaLabel = new JLabel("Nazwa: ");
	JLabel lvlLabel  = new JLabel("  Lvl: ");
	JLabel atakLabel      = new JLabel("Atak: ");
	JLabel hpLabel      = new JLabel("   Hp: ");
	JLabel expLabel  = new JLabel("  Exp: ");


	JTextField nazwaField = new JTextField(10);
	JTextField lvlField = new JTextField(10);
	JTextField atakField = new JTextField(10);
	JTextField hpField = new JTextField(10);
	JTextField expField = new JTextField(10);


	JButton OKButton = new JButton("  OK  ");
	
	
	

	public OknoPostaci(Hero hero) {


		this.hero = hero;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setTitle("Twoja Postac");
		

		JPanel panel = new OknoPostaciObrazek();
		add(panel);
		setLocationRelativeTo(null);
	
			nazwaField.setEditable(false);
			lvlField.setEditable(false);
			atakField.setEditable(false);
			hpField.setEditable(false);
			expField.setEditable(false);
		
			
			nazwaField.setText(hero.getNAZWA());
			lvlField.setText(hero.wyswietlLVL());
			atakField.setText(hero.wyswietlATAK());
			hpField.setText(hero.wyswietlHP());
			expField.setText(hero.wyswietlEXP()+"/"+hero.wyswietlEXP_TO_LVL());
		
		

		OKButton.addActionListener( this );

		

		
		panel.add(nazwaLabel);
		panel.add(nazwaField);
		
		panel.add(lvlLabel);
		panel.add(lvlField);
		
		panel.add(atakLabel);
		panel.add(atakField);
		
		panel.add(hpLabel);
		panel.add(hpField);
		
		panel.add(expLabel);
		panel.add(expField);
		
		panel.add(OKButton);
		pack();
		setContentPane(panel);
		

		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();
		
		if (source == OKButton) {
		

			dispose();
		
	}
	
	}
	
}


