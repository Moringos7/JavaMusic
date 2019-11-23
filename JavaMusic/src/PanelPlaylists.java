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

public class PanelPlaylists extends JPanel {
	private Font fuente;
	private JButton[] botones;
	private Image[] imagenes;
	public PanelPlaylists(Font fuente) {
		super();
		this.setPreferredSize(new Dimension(1000,800));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.fuente=fuente.deriveFont(20f);
		this.imagenes=new Image[10];
		for (int i=0; i<this.imagenes.length;i++) {
			this.imagenes[i]=new ImageIcon("linkinpark.jpg").getImage();
		}
		this.botones=new JButton[10];
		int xbtn=50;
		int ybtn=220;
		for(int i=0; i<this.botones.length;i++) {
			if(i%4==0 && i!=0) {
				ybtn+=250;
				xbtn=50;
			}
			this.botones[i]=new JButton("Ver Playlist");
			this.botones[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			this.botones[i].setBounds(xbtn, ybtn, 100, 25);
			xbtn+=200;
			this.add(this.botones[i]);
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y=25;
		int x=25;
		for (int i=0; i<this.imagenes.length;i++) {
			if(i%4==0 && i!=0) {
				y+=250;
				x=25;
			}
			g.drawImage(this.imagenes[i], x, y, 150, 150, this);
			g.setFont(this.fuente);
			g.setColor(Color.WHITE);
			g.drawString("Tu Playlist", x, y+175);
			x+=200;
		}
	}
}
