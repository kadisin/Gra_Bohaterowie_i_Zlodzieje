package Mobs;

public class Devil {

	private String nazwa;
	private int dmg;
	private int hp;
	private int pancerz;
	private int lvl;
	private String superumiejetnosc;
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public int getPancerz() {
		return pancerz;
	}
	public void setPancerz(int pancerz) {
		this.pancerz = pancerz;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public String getSUPERUMIEJETNOSC() {
		return superumiejetnosc;
	}
	
	
	public Devil(String nazwa,int lvl,int dmg,int hp,int pancerz) {
		this.nazwa = nazwa;
		this.dmg = dmg;
		this.hp = hp;
		this.pancerz = pancerz;
		this.lvl = lvl;
		
	}
	public Devil(String nazwa,int lvl,int dmg,int hp,int pancerz,String umka) {
		this.nazwa = nazwa;
		this.dmg = dmg;
		this.hp = hp;
		this.pancerz = pancerz;
		this.lvl = lvl;
		superumiejetnosc = umka;
		
	}
	
	public int getSuperUmiejetnosc () {
		return lvl*15;
	}
	
	public int otrzymaj_obrazenia(int enemy_atak) {
		if(enemy_atak - pancerz <0) return 0;
		return enemy_atak-pancerz;
	}
	public void zabierz_hp(int enemy_atak) {
		hp -= enemy_atak;
	}
	
}
