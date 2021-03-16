package Walka;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import Hero.Hero;
import Maps.Hell;
import Mobs.Devil;
import OknoGlowne.OknoGry;

public class WalkaHell extends JFrame implements ActionListener {

	Hero hero;
	Hell hell;
	Devil devil;
	boolean czy_walczyles_juz = false;
	
	JTextArea arena = new JTextArea();
	JScrollPane scrollPaneForText = new JScrollPane(arena);
	
	
	JPanel panel = new WalkaObrazek();
	
	JButton walcz = new JButton("Walcz");
	JButton uciekaj = new JButton("Uciekaj");
	JButton wyjdz = new JButton("WYJDZ");
	
	public WalkaHell(Hero hero,Hell hell) {
		this.hero = hero;
		this.hell = hell;
		devil = hell.losuj_przeciwnika();
		
		setTitle("Hell!");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		arena.setEditable(false);

	
		panel.add(scrollPaneForText);
		
		panel.add(walcz);
		panel.add(uciekaj);
		panel.add(wyjdz);
		
		arena.setEditable(false);
		arena.setRows(20);
		arena.setColumns(38);
		
		walcz.addActionListener(this);
		uciekaj.addActionListener(this);
		wyjdz.addActionListener(this);
		
		DefaultCaret caret = (DefaultCaret)arena.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		

		
		WALCZ();
		
		add(panel);
		pack();
		setContentPane(panel);
		setVisible(true);
		
		
		
	}

	public void WALCZ() {
		arena.setFont(new Font("Courier New", Font.ITALIC, 16));
	    arena.setForeground(Color.BLACK);
		
		arena.append( "Zostales zaatakowany przez "+ devil.getNazwa()+"\n");
		arena.append("Poziom "+ devil.getLvl() + " Atak: "+ devil.getDmg() + " Zdrownie: "+devil.getHp()+ "\n\n");

		
	}
	
	public void WALKA() {
		

		int twoj_atak;
		int enemy_atak;
		int twoje_hp = hero.getHP();
		int enemy_hp = devil.getHp();
		
		while(hero.getHP() > 0 && devil.getHp() > 0) {
			
		
			twoj_atak = devil.otrzymaj_obrazenia(hero.getDMG());
			arena.append("Zadajesz " + twoj_atak + " obrazen!\n");
			devil.zabierz_hp(twoj_atak);
			arena.append("Przeciwnikowi zostaje: "+ devil.getHp() +"hp\n\n");
			if(devil.getHp() <= 0) break;
			
			

			enemy_atak = hero.otrzymaj_obrazenia(devil.getDmg());
			arena.append("Przeciwnik zadaje: " + enemy_atak + " obrazen!\n");
			hero.zabierz_hp(enemy_atak);
			arena.append("Zostalo ci " + hero.getHP() + "hp\n\n");

			
		}

		if(devil.getHp() <= 0) {
			arena.append("GRATULACJE pokona³eœ " + devil.getNazwa() + "\n");
			arena.append("Otrzymujesz " + devil.getLvl()*2 + " expa\n");
			
			if(hero.EXP_UP(devil.getLvl()*2) == true) {
				arena.append("GRATULACJE awansujesz na POZIOM " + hero.getLVL()+"\n\n");
				hero.setHP(twoje_hp+2);
				
			}
			
			
			
			
		} else {
			arena.append("Zosta³eœ pokonany!\n");
			int stracony_exp = devil.getLvl()/2;
			arena.append("Tracisz " + stracony_exp + " expa\n\n");
			hero.EXP_UP(-stracony_exp);
			hero.setHP(twoje_hp);
			
			
			
		}
		
		

		devil.setHp(enemy_hp);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();

		
		if(eventSource == walcz) {
			if(czy_walczyles_juz == false)	WALKA();
			czy_walczyles_juz = true;
			
		
					
		}
		if(eventSource == uciekaj) {
			if(czy_walczyles_juz == true	) {
				JOptionPane.showMessageDialog(this, "Wygrales! Nie mozesz uciec! Wal sie na ryj.", "", NORMAL);
			} else {
			JOptionPane.showMessageDialog(this, "Uciekles, tracisz 5exp", "Ucieczka! Jestes frajerem.", NORMAL);
			hero.EXP_UP(-5);
			setVisible(false);
			new WejscieKatakumby(hero);
			}
		}
		if(eventSource == wyjdz) {
			if(czy_walczyles_juz == true) {
			setVisible(false);
			new WejscieKatakumby(hero);
			} else {
			JOptionPane.showMessageDialog(this, "Nie mozesz jeszcze wyjsc!", "", NORMAL);
			}
		
		}
		
		
	}
	
	
	
	

}
