import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CompresseurFile extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jpanel1;
	private Container container;
	private JLabel jlabel1;
	private JFileChooser choixFichier;
	private JButton jbutton;
	private JMenuBar menu;
	private JMenu fichier;
	private String menuItem[] = {"Enegistrer sous","fermer"};
	private JMenuItem  jMenuitem[] = new JMenuItem[menuItem.length];
	private JMenu preferences;
	private JMenu about;
	
	public CompresseurFile() {
		container = this.getContentPane();
		this.setBounds(10, 20, 600, 600);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(600,60));
		inits();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	//tous les composants de l'interface graphique seront cree ici
	public void inits() {
		//Pour faire un chox de fichier
		
		menu = new JMenuBar();
		fichier= new JMenu("File ");
		preferences= new JMenu("Préferences ");
		about= new JMenu("A propos");		
		menu.add(fichier);
		for(int i=0;i<menuItem.length;i++) {
			jMenuitem[i] = new JMenuItem(menuItem[i]);
			fichier.addSeparator();
			fichier.add(this.jMenuitem[i]);
		}
		
		menu.add(preferences);
		menu.add(about);
		menu.setBackground(Color.BLUE);
		fichier.setMnemonic('F');
		
		jpanel1 = new JPanel();
		jpanel1.setLayout(null);
		jbutton = new JButton("Parcourir...");
		jbutton.setBounds(400, 400, 150, 30);
		
		choixFichier = new JFileChooser();
		choixFichier.setBounds(0, 80, 100, 60);
		choixFichier.setMultiSelectionEnabled(true);
		choixFichier.addInputMethodListener(new InputMethodListener() {
			
			@Override
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				JOptionPane.showMessageDialog(null,"Ok ça a changé");
			}
			
			@Override
			public void caretPositionChanged(InputMethodEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		choixFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//JOptionPane.showMessageDialog(null, "Ok nous avons choivis");
				
			}
		});
		
		jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent avctionevent) {
				new SelectionneurFichier().setVisible(true);
			}
		});
		
		jlabel1= new JLabel("Mon Compresseur de fichier");
		jlabel1.setBounds(150,20,300,80);
		jlabel1.setFont(new Font("URW Chancery L",2,30));
		
		
		
		/*
		 * Cette partie ne fais que des ajouts des composants dans d'autres
		 */
		//jpanel1.add(choixFichier);7
		jpanel1.add(menu);
		jpanel1.add(jlabel1);
		jpanel1.add(jbutton);
		this.setJMenuBar(menu);
		container.add(jpanel1);
	}
	
	public static void main(String args[]) {
		CompresseurFile c= new CompresseurFile();
	}
}
