package Hero;

import java.io.IOException;
import java.util.Scanner;

public class Hero {

	private String nazwa;
	private int hp;
	private int dmg;
	private int pancerz;
	private int lvl;
	private int exp;
	private boolean isDead;
	//gettery
	
	public String getNAZWA() {
		return nazwa;
	}
	
	public int getHP() {
		return hp;
	}
	
	public int getDMG() {
		return dmg;
	}
	
	public int getPANCERZ() {
		return pancerz;
	}
	
	public boolean getISDEAD() {
		return isDead;
	}
	public int getLVL() {
		return lvl;
	}
	public int getEXP() {
		return exp;
	}
	
	//settery
	
	public void setNAZWA(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public void setDMG(int dmg) {
		this.dmg = dmg;
	}
	
	public void setPANCERZ(int pancerz) {
		this.pancerz = pancerz;
	}
	
	public void setISDEAD(boolean isDead) {
		this.isDead = isDead;
	}
	
	public void setEXP(int exp) {
		this.exp = exp;
	}
	// konstruktory

	public Hero(String nazwa,int hp,int dmg,int pancerz,int lvl, int exp) {
		this.nazwa =nazwa;
		this.hp = hp;
		this.dmg = dmg;
		this.pancerz = pancerz;
		this.lvl = lvl;
		this.exp = exp;
		isDead= false;
		
	}
	
	public Hero(String nazwa, int dmg,int hp,int pancerz) {
		this.nazwa = nazwa;
		this.hp = hp;
		this.dmg = dmg;
		lvl =1;
		exp =0;
		this.pancerz = pancerz;
		isDead= false;
	}
	
	public Hero()  {
		Scanner odczyt = new Scanner(System.in);
		System.out.print("Podaj nick bohatera: ");
		String nazwa = odczyt.nextLine();
		System.out.println("");

		this.nazwa = nazwa;
		hp = 10;
		dmg = 10;
		pancerz = 10;
		lvl =1;
		isDead = false;
		exp = 0;
		
	}
	
	//metody
	
	public void showHero() {
		System.out.println("Nazwa postaci: "+ nazwa );
		System.out.println("Poziom postaci: "+ lvl );
		System.out.println("Atak postaci: "+ dmg );
		System.out.println("Poziom zycia postaci: "+hp);
		System.out.println("Pancerz postaci: "+ pancerz );
		System.out.println("Poziom doswiadczenia: "+exp+"/"+exp_to_lvl()+"\n\n\n ");
		
		
	}
	public int exp_to_lvl() {
		if(lvl < 10) {
			return lvl *3;
		}
		if( lvl >= 10 && lvl < 20) {
			return lvl *10;
		}
		return lvl*30;
	}
	
	public boolean EXP_UP(int _exp) {
		if(_exp+ exp < 0) {
			exp = 0;
			return false;
		}
		
		if(_exp + exp >= exp_to_lvl()) {
			lvl_up();
			return true;
		}
		else {
			exp += _exp;
			return false;
		}

	}
	
	public int otrzymaj_obrazenia(int enemy_atak) {
		if(enemy_atak - pancerz <0) return 0;
		return enemy_atak-pancerz;
	}
	public void zabierz_hp(int enemy_atak) {
		hp -= enemy_atak;
	}
	
	public void lvl_up() {
		lvl++;

		exp = 0;
		dmg += 2;
		hp += 2;
		pancerz += 2;
		
	}
	public String wyswietlLVL() {
		return String.valueOf(lvl);
	}
	public String wyswietlATAK() {
		return String.valueOf(dmg);
	}
	public String wyswietlHP() {
		return String.valueOf(hp);
	}
	public String wyswietlEXP() {
		return String.valueOf(exp);
	}
	public String wyswietlEXP_TO_LVL() {
		return String.valueOf(exp_to_lvl());
	}
	
	
}
