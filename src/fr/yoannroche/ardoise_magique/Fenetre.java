package fr.yoannroche.ardoise_magique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class Fenetre extends JFrame {

	JPanel container = new JPanel ();

	private JMenuBar menuBar = new JMenuBar (); 
	private Panneau drawPanel = new Panneau ();
	private ItemListener iListener = new ItemListener();
	private MenuListener mListener = new MenuListener();
	private SizeListener sListener = new SizeListener();

	JToolBar toolBar = new JToolBar();
	JPanel menuItem = new JPanel ();

	/**
	 * Liste du Menu
	 */

	String [] tab_menus = { "Fichier","Edition","Taille","Couleur","Forme"} ;
	JMenu []  tab_menu = new JMenu[tab_menus.length];

	/**
	 * Liste du MenuItem
	 */

	String [] tab_menui = { "Effacer","Quitter","Rond","Carré","Noir","Jaune","Bleu","Rouge","Gomme","Enorme","Grand","Normal","Petit"};
	JMenuItem [] tab_menuI = new JMenuItem[tab_menui.length];

	/**
	 * Liste des Boutons qui iront dans le JToolBar.
	 * Les boutons sont raccordés a des ImageIcon.
	 */


	ImageIcon [] tab_button = {
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/carre.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/rond.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/yellow.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/red.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/blue.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/black.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/gomme.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/bigsize.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/upsize.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/normsize.png")),
			(new ImageIcon("src/fr/yoannroche/ardoise_magique/littlesize.png"))};
	JButton [] tab_buttont = new JButton[tab_button.length];


	public Fenetre () {
		this.setTitle("Ardoise Magique");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		this.initToolBar();
		this.initMenu();

		this.getContentPane().add(drawPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}



	private void initMenu() {
		/**
		 * Géneration de la liste JMenuItem
		 * On va définir leurs actions et leurs JPanel.
		 */
		for(int i = 0; i < tab_menui.length; i++){

			tab_menuI[i] = new JMenuItem(tab_menui[i]);
			switch(i) {
			case 9 : 
				tab_menuI[i].addActionListener(sListener);
				menuItem.add(tab_menuI[i]);

			case 10 :

			case 11 :

			case 12 :
				break ;
			}



		}


		/**
		 * Géneration de la liste tableau JMenu
		 * On va définir leurs actions et leurs JPanel.
		 */
		for(int i = 0; i < tab_menus.length; i++){

			tab_menu[i] = new JMenu(tab_menus[i]);
			switch(i) {
			case 0 :
				tab_menu[i].addActionListener(mListener);
				menuBar.add(tab_menu[i]);
				break ;
			case 1 :
				tab_menu[i].add("Couleur");
				tab_menu[i].add("Forme");
				menuBar.add(tab_menu[i]);
				break ;
			case 2 :
				tab_menu[i].add("Noir");
				tab_menu[i].add("Jaune");
				tab_menu[i].add("Rouge");
				tab_menu[i].add("Bleu");
				tab_menu[i].add("Gomme");



			}
		}

	}






	private void initToolBar() {

		/**
		 * Géneration de la liste JButton 
		 * On va définir leurs actions et leurs JPanel.
		 */
		for(int i = 0; i < tab_button.length; i++){

			tab_buttont[i] = new JButton(tab_button[i]);
			switch(i) {






			}
		}

		toolBar.addSeparator();

		toolBar.setBackground(Color.orange);
		toolBar.setBorder(BorderFactory.createLineBorder(Color.black));

		this.getContentPane().add(toolBar, BorderLayout.NORTH);
	}






	class ItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

		}

	}
	class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

		}
	}
	class SizeListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			if(e.getSource()=="Enorme")drawPanel.setPointerSize(50);
			if(e.getSource()=="Grand")drawPanel.setPointerSize(30);
			if(e.getSource()=="Normal")drawPanel.setPointerSize(10);
			if(e.getSource()=="Petit")drawPanel.setPointerSize(3);

		}
	}
}
