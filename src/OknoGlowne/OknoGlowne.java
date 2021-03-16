package OknoGlowne;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Hero.Hero;
import Hero.Odczytaj_z_pliku;


public class OknoGlowne extends JFrame implements ActionListener{

	JButton nowa_gra = new JButton("NOWA GRA");
	JButton wczytaj_gre = new JButton("WCZYTAJ GRE");
	Hero hero;
	
	private BufferedImage image;
	
	public OknoGlowne() throws IOException {

		setTitle("BOHATEROWIE I ZLODZIEJE!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		

		
		JPanel panel = new OknoGlowneObrazek();
		
		setLocationRelativeTo(null);
		
		add(panel);
		nowa_gra.addActionListener(this);
		wczytaj_gre.addActionListener(this);
		
		panel.add(nowa_gra);
		panel.add(wczytaj_gre);
		pack();
		setContentPane(panel);
		setVisible(true);
		
	}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if(eventSource == nowa_gra) {
			String nazwa = JOptionPane.showInputDialog("Podaj nazwe bohatera: ");
			hero = new Hero(nazwa,7,50,2);
			new OknoGry(hero);
			setVisible(false);
			
			
		}
		if(eventSource == wczytaj_gre) {
			Odczytaj_z_pliku od = new Odczytaj_z_pliku();
			try {
				hero= od.odczytaj();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new OknoGry(hero);
			setVisible(false);
			
		}
		

		this.requestFocus();
		
	}




	




}
	
	

