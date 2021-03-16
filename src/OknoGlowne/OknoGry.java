package OknoGlowne;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Hero.Hero;
import Walka.WejscieKatakumby;

public class OknoGry extends JFrame implements ActionListener {

	Hero hero;
	
	JButton o_postaci = new JButton("O postaci");
	JButton mapy_exp = new JButton("Idz expic");
	
	public OknoGry(Hero hero) {
		this.hero = hero;
		
	
		setTitle("BOHATEROWIE I ZLODZIEJE!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		
		
		JPanel panel = new OknoGryObrazek();
		
		setLocationRelativeTo(null);
		panel.add(o_postaci);
		panel.add(mapy_exp);
		
		
		add(panel);
		
		
		o_postaci.addActionListener(this);
		mapy_exp.addActionListener(this);
		
		pack();
		setContentPane(panel);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if(eventSource == o_postaci) {
			new OknoPostaci(hero);
			
		}
		if(eventSource == mapy_exp) {
			new WejscieKatakumby(hero);
			setVisible(false);
		}
		
	}
	
	
}
