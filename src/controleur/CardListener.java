package controleur;



import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vue.Cards;
import vue.Graphique;
public class CardListener extends MouseAdapter  {
	public Cards card;
	public manger m;
	JLabel sourceCard;
	public ArrayList<Cards> Carteadd;
	public Boolean test;
	public Boolean testAdd;
	 private int x,y;
	public CardListener(Cards card) {
		super();
		this.card=card;
		 m=new manger(Graphique.cardsplateaux);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseDragged(e);
		card.getLbimg().setLocation(e.getX()+card.getX()-x,e.getY()+card.getY()-y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		sourceCard = (JLabel) e.getSource();
		super.mouseClicked(e);
		Point p = sourceCard.getLocation();	
		if(p.y>700) {
			
				m.setCarteClicke(card);
		
		}
			//		
		test=m.test();
		if(!test) {
			p.y -=600;
			e.getComponent().setLocation(p);
			Graphique.cardsplateaux.add(card);	
		}else {	
			Graphique.cardsplateaux=m.newliste();
		}
	}

	public void mousePressed(MouseEvent e) {		
			x= e.getX();
			y =e.getY();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
		sourceCard = (JLabel) e.getSource();
		Point p = sourceCard.getLocation();
		if(p.y>700) {
		p.y -=20;
		}
		sourceCard.setLocation(p);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		sourceCard = (JLabel) e.getSource();
		Point p = sourceCard.getLocation();
		if(p.y>700) {
		p.y +=20;
		}
		sourceCard.setLocation(p);
	}	

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}	

}
