import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import vue.Graphique;
public class FenetreInit {

	private JFrame frame;
	private JPanel contentPane;
	private Image img;
	private JTextField nomJoueur;
	public JLabel labelnom;
	public JLabel labelhost;
	public JButton button;
	private JTextField Hostadv;
	public Graphique g;
	public static final String URI_IMG=System.getProperty("user.dir")+"\\src\\img\\" ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreInit window = new FenetreInit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreInit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		frame.setTitle("CKOBBA");
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    int xSize = ((int) tk.getScreenSize().getWidth());
	    int ySize = ((int) tk.getScreenSize().getHeight());
	    frame.setSize(363,1234);
	    frame.setResizable(false);
	    frame.pack();
	    Dimension size=new Dimension(922,512);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   contentPane = new JPanel() {  
		  public void paintComponent(Graphics g) {  
			 
			  img = Toolkit.getDefaultToolkit().getImage(URI_IMG+"initback.png");  
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
		      }  
		     };
		  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  frame.setContentPane(contentPane);
		  contentPane.setLayout(null);
		  Hostadv = new JTextField();
		  Hostadv.setColumns(10);
		  Hostadv.setBounds(270, 408, 395, 45);
		  contentPane.add(Hostadv);
		  nomJoueur = new JTextField();
		  nomJoueur.setBounds(270, 350, 395, 45);
		  contentPane.add(nomJoueur);
		  nomJoueur.setColumns(10);
		  labelnom = new JLabel();
		  labelnom.setBounds(90, 350, 50,90);
		  contentPane.add(labelnom);
		  labelhost = new JLabel();
		  labelhost.setBounds(90, 408, 50,90);
		  contentPane.add(labelhost);
		  button = new JButton();
		  button.setBounds(722, 350,50,90);
		  contentPane.add(button);
		  button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
			String joueur="joueur1";
			    new Graphique();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
