import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelAlbumes extends JPanel {
	private Font fuente;
	private Image[] imagenes;
	private JButton[] botones;
	public PanelAlbumes(Font fuente) {
		super();
		this.setPreferredSize(new Dimension(1000,650));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.fuente=fuente;
		this.imagenes=new Image[10];
		for (int i=0; i<this.imagenes.length;i++) {
			this.imagenes[i]=new ImageIcon("DeathOfABachelor.jpg").getImage();
		}
		this.botones=new JButton[10];
		for(int i=0; i<this.botones.length;i++) {
			this.botones[i]=new JButton("Ver Album");
			this.botones[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y=25;
		int x=25;
		for (int i=0; i<this.imagenes.length-2;i++) {
			if(i%2==0) {
				y=25;
				g.drawImage(this.imagenes[i], x, y, 150, 150, this);
			}else{
				y=250;
				g.drawImage(this.imagenes[i], x, y, 150, 150, this);
				x+=200;
			}
		}
		g.drawImage(this.imagenes[8], 225, 400, 150, 150, this);
		g.drawImage(this.imagenes[9], 425, 400, 150, 150, this);
	}
	
}
