package Walka;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Random;

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

public class WalkaBossHell extends JFrame implements ActionListener {

	Hero hero;
	Devil devil;
	boolean czy_walczyles_juz = false;
	
	JTextArea arena = new JTextArea();
	JScrollPane scrollPaneForText = new JScrollPane(arena);
	
	
	JPanel panel = new WalkaObrazek();
	
	JButton walcz = new JButton("Walcz");

	JButton wyjdz = new JButton("WYJDZ");
	
	public WalkaBossHell(Hero hero,Devil devil) {
		this.hero = hero;
		this.devil = devil;
		
		setTitle("Hell!");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		arena.setEditable(false);

	
		panel.add(scrollPaneForText);
		
		panel.add(walcz);

		panel.add(wyjdz);
		
		arena.setEditable(false);
		arena.setRows(20);
		arena.setColumns(65);
		
		walcz.addActionListener(this);

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
		
		arena.append( "Natrafiasz na wœciek³¹ "+ devil.getNazwa()+"\n");
		arena.append("Poziom "+ devil.getLvl() + " Atak: "+ devil.getDmg() + " Zdrownie: "+devil.getHp()+ "\n\n");

		
	}
	
	public void WALKA() {
		

		int twoj_atak;
		int enemy_atak;
		int twoje_hp = hero.getHP();
		int enemy_hp = devil.getHp();
		Random rand = new Random();
		int szansa_skill;
		while(hero.getHP() > 0 && devil.getHp() > 0) {
			
			
			twoj_atak = devil.otrzymaj_obrazenia(hero.getDMG());
			arena.append("Zadajesz " + twoj_atak + " obrazen!\n");
			devil.zabierz_hp(twoj_atak);
			arena.append("Przeciwnikowi zostaje: "+ devil.getHp() +"hp\n\n");
			if(devil.getHp() <= 0) break;
			
			szansa_skill = rand.nextInt(3);
			if(szansa_skill== 0) {
				enemy_atak = hero.otrzymaj_obrazenia(devil.getSuperUmiejetnosc());
				arena.append(devil.getNazwa() +" wpad³ w sza³ i u¿ywa umiejêtnoœci " + devil.getSUPERUMIEJETNOSC() + "\n");
				arena.append(devil.getNazwa()+ " zadaje: " + enemy_atak + " obrazen!\n");
				hero.zabierz_hp(enemy_atak);
				arena.append("Zostalo ci " + hero.getHP() + "hp\n\n");
			} else {

			enemy_atak = hero.otrzymaj_obrazenia(devil.getDmg());
			arena.append("Przeciwnik zadaje: " + enemy_atak + " obrazen!\n");
			hero.zabierz_hp(enemy_atak);
			arena.append("Zostalo ci " + hero.getHP() + "hp\n\n");
			}
			
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
