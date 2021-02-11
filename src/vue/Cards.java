package vue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Cards extends JLabel {
	public JLabel lbimg;
	public int nb;
	public String Type;
	public int x;
	public int y;
	public Cards(JLabel lbimg, int nb, String type) {
		super();
		this.lbimg = lbimg;
		this.nb = nb;
		Type = type;
	}
	public void setImage(ImageIcon img) {
		lbimg.setIcon(img);
	}
	public int getX() {
		return lbimg.getX();
	}
	public int getY() {
		return lbimg.getY();
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	public int getNb() {
		return nb;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getType() {
		return Type;
	}
	public JLabel getLbimg() {
		
		return lbimg;
	}
	public void setLbimg(JLabel lbimg) {
		this.lbimg = lbimg;
	}
	

}
