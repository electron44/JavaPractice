
import java.awt.Container;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectionneurFichier  extends JFrame{
	
	private Container container;
	private JFileChooser choixFichier;
	private JPanel jpanel1;
	
	public SelectionneurFichier() {
		container = this.getContentPane();
		inits();
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public void inits() {
		jpanel1 = new JPanel();
		choixFichier = new JFileChooser();
		choixFichier.setToolTipText("dededede");
		choixFichier.setMultiSelectionEnabled(true);
		jpanel1.add(choixFichier);
		container.add(jpanel1);
	}
}
