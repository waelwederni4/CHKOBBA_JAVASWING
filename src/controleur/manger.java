package controleur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import AppPackage.AnimationClass;
import vue.Cards;
import vue.Graphique;

public class manger {
	ArrayList<Cards> liste;
	Cards CarteClicke;
	//public AnimationClass anim;
	public manger(ArrayList<Cards> liste) {
		super();
		this.liste = liste;
	}
	public void setCarteClicke(Cards carteClicke) {
		CarteClicke = carteClicke;
	}
	public Boolean test() {
		Boolean A = false;
		int i=0;
			while (i < liste.size() && A==false) {
				if(liste.get(i).getNb()==CarteClicke.getNb()) {
					liste.get(i).getLbimg().setVisible(false);
					liste.remove(i);
					CarteClicke.getLbimg().setVisible(false);
					A=true;
					}else {
					A=false;
					i++;
			}
			
		}
		return A;
	}
	public ArrayList<Cards> newliste(){
		return liste;
	}
}
