package Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Odczytaj_z_pliku {


	
	public Hero odczytaj() throws FileNotFoundException {
		
		File file = new File("Save/Postac.txt");
        Scanner in = new Scanner(file);

        String[] odczytane = new String[6];
        for(int i=0;i<6;i++) {
        	odczytane[i] = in.nextLine();
        	
        }
        String imie = odczytane[0];
        int hp = Integer.parseInt(odczytane[1]);
        int dmg = Integer.parseInt(odczytane[2]);
        int pancerz = Integer.parseInt(odczytane[3]);
        int lvl = Integer.parseInt(odczytane[4]);
        int exp = Integer.parseInt(odczytane[5]);
		return new Hero(imie,hp,dmg,pancerz,lvl,exp);
        
        
    }
		
		
	}
	
	
	
	

