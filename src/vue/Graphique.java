package vue;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppPackage.AnimationClass;
import controleur.CardListener;
import javax.swing.JButton;

public class Graphique {
	public static JFrame frame;
	private JPanel contentPane;
	public Image img;
	public ArrayList<Cards> tcards;
	public static ArrayList<Cards> cardsaddition=new ArrayList<Cards>();
	public ImageIcon[] imgcards=new ImageIcon[41];
	public JLabel[] labimg=new JLabel[40];
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public static Cards[] cardjoueur=new Cards[3];
	public static ArrayList<Cards> cardsplateaux=new ArrayList<Cards>();
	public AnimationClass anim;
	public JLabel lblplateaux;
	public static int nombreadd;
	public static final String URI_IMG=System.getProperty("user.dir")+"\\src\\img\\" ;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Graphique window = new Graphique();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Graphique() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,720,1234);
		frame.setVisible(true);
		frame.setTitle("CKOBBA");
	    frame.setSize(363,1234);
	    frame.setResizable(false);
	    frame.pack();
	    Dimension size=new Dimension(720,1234);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   contentPane = new JPanel() {  
		  public void paintComponent(Graphics g) {  
			  img = Toolkit.getDefaultToolkit().getImage(URI_IMG+"tapis.png");  
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
		      }  
		     };
		  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  frame.setContentPane(contentPane);
		    nombreadd=0;
		    remplirimg();
	        initGame();
	        remplirpanel();
		        	 anim.jLabelXRight(-120, 305, 10, 2, l1);
						anim.jLabelXRight(-120, 445, 10, 2, l2);
						anim.jLabelXRight(-120, 160, 10, 2, l3);
						 for(int i =0; i<tcards.size();i++){
					            Collections.shuffle(tcards);
						 }    
						 cardsplateaux.add(tcards.get(3));
					        cardsplateaux.add(tcards.get(4));
					        cardsplateaux.add(tcards.get(5));
					        cardsplateaux.add(tcards.get(6));
					            anim.jLabelXRight(-120, 445, 10, 2,tcards.get(0).getLbimg());				    
						        anim.jLabelXRight(-120, 305, 10, 2,tcards.get(1).getLbimg());
						        anim.jLabelXRight(-120, 160, 10, 2,tcards.get(2).getLbimg());
						        tcards.get(3).getLbimg().setLocation(-120, 250);
						        tcards.get(4).getLbimg().setLocation(-120, 450);
						        tcards.get(5).getLbimg().setLocation(-120, 250);
						        tcards.get(6).getLbimg().setLocation(-120,  450);
						        anim.jLabelXRight(-120, 64, 10, 2,tcards.get(3).getLbimg());					      
						        anim.jLabelXRight(-120, 64, 10, 2,tcards.get(4).getLbimg());					        
						        anim.jLabelXRight(-120, 500, 10, 2,tcards.get(5).getLbimg());
						        anim.jLabelXRight(-120, 500, 10, 2,tcards.get(6).getLbimg());
						        cardjoueur[0]=tcards.get(0);
						        cardjoueur[1]=tcards.get(1);
						        cardjoueur[2]=tcards.get(2);
						       
						      
	        frame.setVisible(true);
	}
	private void initGame() {
		// TODO Auto-generated method stub
		tcards=new ArrayList<Cards>();
	    l1=new JLabel(imgcards[0]);
	    l1.setBounds(-120,13,114,159);
        l2=new JLabel(imgcards[0]);
        l2.setBounds(-120,13,114,159);
        l3=new JLabel(imgcards[0]);
        l3.setBounds(-120,13,114,159);
        int j=1;
        for (int i = 1; i < imgcards.length; i++) {    	
			labimg[i-1]=new JLabel(imgcards[i]);
			tcards.add(new Cards(labimg[i-1],i,"careau"));
			tcards.get(i-1).getLbimg().setLocation(-120,872);
			tcards.get(i-1).getLbimg().setSize(114,159);
			tcards.get(i-1).getLbimg().addMouseListener(new CardListener(tcards.get(i-1)));
			contentPane.add(tcards.get(i-1).getLbimg());
		}
        for (int i = 0; i <tcards.size(); i+=4) {  	
			tcards.get(i).setNb(j);
			tcards.get(i+1).setNb(j);
			tcards.get(i+2).setNb(j);
			tcards.get(i+3).setNb(j);
			tcards.get(i).setType("careau");
			tcards.get(i+1).setType("coeur");
			tcards.get(i+2).setType("pique");
			tcards.get(i+3).setType("trefle");
			j++;
		}
        anim=new AnimationClass();
        contentPane.setLayout(null);
	}
	public void remplirpanel() {
        contentPane.add(l1);
        contentPane.add(l2);
        contentPane.add(l3);
	}
	public void remplirimg() {
		imgcards[0]=new ImageIcon(URI_IMG+"cards\\back_carte.png");
		imgcards[1]=new ImageIcon(URI_IMG+"cards\\As_careau.png");
		imgcards[2]=new ImageIcon(URI_IMG+"cards\\As_coeur.png");
		imgcards[3]=new ImageIcon(URI_IMG+"cards\\As_pique.png");
		imgcards[4]=new ImageIcon(URI_IMG+"cards\\As_trefle.png");
		imgcards[5]=new ImageIcon(URI_IMG+"cards\\deux_careau.png");
		imgcards[6]=new ImageIcon(URI_IMG+"cards\\deux_coeur.png");
		imgcards[7]=new ImageIcon(URI_IMG+"cards\\deux_pique.png");
		imgcards[8]=new ImageIcon(URI_IMG+"cards\\deux_trefle.png");
		imgcards[9]=new ImageIcon(URI_IMG+"cards\\trois_careau.png");
		imgcards[10]=new ImageIcon(URI_IMG+"cards\\trois_coeur.png");
		imgcards[11]=new ImageIcon(URI_IMG+"cards\\trois_pique.png");
		imgcards[12]=new ImageIcon(URI_IMG+"cards\\trois_trefle.png");
		imgcards[13]=new ImageIcon(URI_IMG+"cards\\quatre_careau.png");
		imgcards[14]=new ImageIcon(URI_IMG+"cards\\quatre_coeur.png");
		imgcards[15]=new ImageIcon(URI_IMG+"cards\\quatre_pique.png");
		imgcards[16]=new ImageIcon(URI_IMG+"cards\\quatre_trefle.png");
		imgcards[17]=new ImageIcon(URI_IMG+"cards\\chinqo_careau.png");
		imgcards[18]=new ImageIcon(URI_IMG+"cards\\chinqo_coeur.png");
		imgcards[19]=new ImageIcon(URI_IMG+"cards\\chinqo_pique.png");
		imgcards[20]=new ImageIcon(URI_IMG+"cards\\chinqo_trefle.png");
		imgcards[21]=new ImageIcon(URI_IMG+"cards\\six_careau.png");
		imgcards[22]=new ImageIcon(URI_IMG+"cards\\six_coeur.png");
		imgcards[23]=new ImageIcon(URI_IMG+"cards\\six_pique.png");
		imgcards[24]=new ImageIcon(URI_IMG+"cards\\six_trefle.png");
		imgcards[25]=new ImageIcon(URI_IMG+"cards\\sept_careau.png");
		imgcards[26]=new ImageIcon(URI_IMG+"cards\\sept_coeur.png");
		imgcards[27]=new ImageIcon(URI_IMG+"cards\\sept_pique.png");
		imgcards[28]=new ImageIcon(URI_IMG+"cards\\sept_trefl.png");
		imgcards[29]=new ImageIcon(URI_IMG+"cards\\dame_careau.png");
		imgcards[30]=new ImageIcon(URI_IMG+"cards\\dame_coeur.png");
		imgcards[31]=new ImageIcon(URI_IMG+"cards\\dame_pique.png");
		imgcards[32]=new ImageIcon(URI_IMG+"cards\\dame_trefle.png");
		imgcards[33]=new ImageIcon(URI_IMG+"cards\\valet_careau.png");
		imgcards[34]=new ImageIcon(URI_IMG+"cards\\valet_coeur.png");
		imgcards[35]=new ImageIcon(URI_IMG+"cards\\valet_pique.png");
		imgcards[36]=new ImageIcon(URI_IMG+"cards\\valet_trefle.png");
		imgcards[37]=new ImageIcon(URI_IMG+"cards\\roi_careau.png");
		imgcards[38]=new ImageIcon(URI_IMG+"cards\\roi_coeur.png");
		imgcards[39]=new ImageIcon(URI_IMG+"cards\\roi_pique.png");
		imgcards[40]=new ImageIcon(URI_IMG+"cards\\roi_trefle.png");
		
	}
	public static void setnombreaddition(int Val,Cards card) {
		nombreadd+=Val;
		cardsaddition.add(card);
	}
}
