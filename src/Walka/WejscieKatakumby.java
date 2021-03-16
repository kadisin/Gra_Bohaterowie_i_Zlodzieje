package Walka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Hero.Hero;
import Maps.Hell;
import OknoGlowne.OknoGry;
import OknoGlowne.OknoGryObrazek;
import OknoGlowne.OknoPostaci;

public class WejscieKatakumby extends JFrame implements ActionListener {

	Hero hero;
	
	JButton mapa_hell = new JButton("Hell");
	JButton boss_hell = new JButton("Boss Hell");
	JButton wejdz_do_miasta = new JButton("Do miasta!");
	
	public WejscieKatakumby(Hero hero) {
		this.hero = hero;
		
	
		setTitle("BOHATEROWIE I ZLODZIEJE!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		
		
		JPanel panel = new WejscieKatakumbyObrazek();
		if(hero.getLVL() >= 0) {
		panel.add(mapa_hell);	
		}
		if(hero.getLVL() >= 5) {
		panel.add(boss_hell);
		}
		
		panel.add(wejdz_do_miasta);
		
		
		add(panel);
		
		mapa_hell.addActionListener(this);
		boss_hell.addActionListener(this);
		wejdz_do_miasta.addActionListener(this);
		
		pack();
		setContentPane(panel);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if(eventSource == mapa_hell) {
			new WalkaHell(hero,new Hell());
			setVisible(false);
		}
		if(eventSource == boss_hell) {
			JOptionPane.showMessageDialog(this, "Trafiles na wladce podziemi!\nPowodzenia!", "O hell no!", NORMAL);
			new WalkaBossHell(hero, new Hell().getBoss());
			setVisible(false);
		}
		if(eventSource == wejdz_do_miasta) {
			setVisible(false);
			new OknoGry(hero);
		}
		
	}
	
	
}


