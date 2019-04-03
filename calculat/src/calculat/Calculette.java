package calculat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculette extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp = new JPanel();
	String button[] = {"1","2","3","4","5","6","7","8","9","0",",","+","-","*","/","="};
	public boolean update =false, clickop= false;
	JButton[] tab_button = new JButton[button.length];
	 JTextField champ;
	 private double chiffre;
	 private String operateur = "";



	public Calculette() {
		Container cont = getContentPane();
		//Donner un titre au Jframe
		this.setTitle("Calculatrice");
		//Definition de la taille du Jframe
		this.setSize(400, 350);
		//Action executée au clic de licone de fermeture
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//this.setResizable(false);
		//Positionner la fenetre 
		this.setLocation(500, 200);
		inits();
		this.setContentPane(jp);
		
	}
	
	public void inits() {
	//rendre visible le 	
		JPanel jp1 = new JPanel();
		champ = new JTextField("0");
		champ.setForeground(Color.black);
		champ.setBackground(Color.WHITE);
	    champ.setHorizontalAlignment(JTextField.RIGHT);
	    champ.setFont(new Font("Arial",1,18));

		champ.setBounds(1, 2 , 397,30);
		GridLayout gd = new  GridLayout(1,1);
		jp1.setLayout(gd);
		jp1.add(champ);
		JPanel jp2= new JPanel();
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(1,2));
		JPanel jp4 = new JPanel();
		jp4.setLayout(new BorderLayout());
		jp3.setVisible(true);
		jp.setLayout(null);
		jp1.setBounds(0, 0, 400, 70);
		jp2.setBounds(0,78,399,300);
		jp3.setBounds(0,301,399,50);
		GridLayout gd1 = new GridLayout(5,4);
		jp2.setLayout(gd1);
		
		for(int i=0;i<tab_button.length;i++) {
			tab_button[i] =new JButton(button[i]);
			tab_button[i].setFont(new Font("Arial",1,14));
			tab_button[i].getPreferredSize();
			//tab_button[i].setBorder(new EmptyBorder(5, 5, 5, 5));
			jp2.add(tab_button[i]);
				
			switch(i) {
				case 9:
					tab_button[i].addActionListener(new ActionListener() {
						  public void actionPerformed(ActionEvent e){
						      //On affiche le chiffre additionnel dans le label
						      String str = ((JButton)e.getSource()).getText();
						      if(update){
						        update = false;
						      }
						      else{
						        if(!champ.getText().equals("0"))
						          str = champ.getText() + str;
						      }
						      champ.setText(str);
					  }
					 });
					break;
					//Cas ou le boutton cliqué est les signe +
				case 11:tab_button[i].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0){
							      if(clickop){
							        makeCalcul();
							        champ.setText(String.valueOf(chiffre));
							      }
							      else{
							        chiffre = Double.valueOf(champ.getText()).doubleValue();
							        clickop = true;
							      }
							      operateur = "+";
							      update = true;
							    }
						});
						break;
				
						//Cas ou le boutton cliqué est les signe  -
				case 12:
					tab_button[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0){
					      if(clickop){
					        makeCalcul();
					        champ.setText(String.valueOf(chiffre));
					      }
					      else{
					        chiffre = Double.valueOf(champ.getText()).doubleValue();
					        clickop = true;
					      }
					      operateur = "-";
					      update = true;
					    }
				});
					break;
					
					//Cas ou le boutton cliqué est les signe  *
				case 13:
					tab_button[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0){
					      if(clickop){
					        makeCalcul();
					        champ.setText(String.valueOf(chiffre));
					      }
					      else{
					        chiffre = Double.valueOf(champ.getText()).doubleValue();
					        clickop = true;
					      }
					      operateur = "*";
					      update = true;
					    }
				});
					break;
				//Cas ou le boutton cliqué est les signe  /
				case 14: 
					tab_button[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0){
					      if(clickop){
					        makeCalcul();
					        champ.setText(String.valueOf(chiffre));
					      }
					      else{
					        chiffre = Double.valueOf(champ.getText()).doubleValue();
					        clickop = true;
					      }
					      operateur = "/";
					      update = true;
					    }
				});
					break;
					//Cas ou le signe est = 
				case 15: 
					//On met le background du bouton egale à rouge
						tab_button[i].setBackground(Color.RED);
					tab_button[i].addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0){
					      makeCalcul();
					      update = true;
					      clickop = false;
					    }
				});
				break;
				default :
						  tab_button[i].addActionListener(new ActionListener() {
							  public void actionPerformed(ActionEvent e){
							      //On affiche le chiffre additionnel dans le label
							      String str = ((JButton)e.getSource()).getText();
							      if(update){
							        update = false;
							      }
							      else{
							        if(!champ.getText().equals("0"))
							          str = champ.getText() + str;
							      }
							      champ.setText(str);
						  }
						 });
			}
		}
		
	    jp1.setBorder(BorderFactory.createLineBorder(Color.black));
	    jp2.setBorder(BorderFactory.createLineBorder(Color.black,5));
	    //jp3.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    
	    jp.add("North",jp1);
		jp.add("Center",jp2);
		//jp.add("East",jp3);
		
	}
	
	private void makeCalcul(){
		
	    if(operateur.equals("+")){
	      chiffre = chiffre + Double.valueOf(champ.getText()).doubleValue();
	      champ.setText(String.valueOf(chiffre));
	    }
	    if(operateur.equals("-")){
	      chiffre = chiffre - Double.valueOf(champ.getText()).doubleValue();
	      champ.setText(String.valueOf(chiffre));
	    }          
	    if(operateur.equals("*")){
	      chiffre = chiffre * Double.valueOf(champ.getText()).doubleValue();
	      champ.setText(String.valueOf(chiffre));
	    }     
	    if(operateur.equals("/")){
	      try{
	        chiffre = chiffre / Double.valueOf(champ.getText()).doubleValue();
	        champ.setText(String.valueOf(chiffre));
	      } catch(ArithmeticException e) {
	        champ.setText("0");
	      }
	    }
	  }
	
	
		
	public static void main(String args[]) {
	
	new Calculette().setVisible(true);
		
	}

}
