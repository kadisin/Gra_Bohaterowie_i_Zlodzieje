package Maps;
import java.util.ArrayList;
import java.util.Random;

import Mobs.Devil;
public class Hell {

	private ArrayList<Devil> lista_devil = new ArrayList<Devil>();
	private Devil boss;
	public ArrayList<Devil> getLIST(){
		return lista_devil;
	}
	
	
	
	public Hell() {
		//(String nazwa,int lvl,int dmg,int hp,int pancerz)
		Devil d1 = new Devil("Slaby diabelek",1,5,20,1);
		Devil d2 = new Devil("Diabelek",2,7,30,2);
		Devil d3 = new Devil("Silny diabelek",4,10,50,3);
		this.boss = new Devil("Serafin",10,45,500,10,"Foch Stulecia");
		lista_devil.add(d1);
		lista_devil.add(d2);
		lista_devil.add(d3);
		
	}
	
	public Devil getBoss() {
		return boss;
	}
	
	public Devil losuj_przeciwnika() {
		Random rand = new Random();
		int wygenerowany = rand.nextInt(lista_devil.size());
		return lista_devil.get(wygenerowany);	
	}
	
	
	
	
	
}
