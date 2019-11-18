import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelAlbumes extends JPanel {
	private Font fuente;
	private Image[] imagenes;
	private JButton[] botones;
	private LinkedList<JLabel> textos;
	private LinkedList<Album> albumes;
	private Connection coneccion;
	public PanelAlbumes(Font fuente) {
		super();
		this.setPreferredSize(new Dimension(1000,800));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.fuente=fuente.deriveFont(15f);
		this.imagenes=new Image[10];
		this.textos=new LinkedList<>();
		try {
			this.albumes=coneccion.getAlbumes();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		for (int i=0; i<this.imagenes.length;i++) {
			this.imagenes[i]=new ImageIcon("DeathOfABachelor.jpg").getImage();
		}
		this.botones=new JButton[10];
		int xbtn=50;
		int ybtn=240;
		for(int i=0; i<this.botones.length;i++) {
			if(i%4==0 &&i!=0) {
				ybtn+=250;
				xbtn=50;
			}
			this.botones[i]=new JButton("Ver Album");
			this.botones[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			this.botones[i].setBounds(xbtn, ybtn, 100, 25);
			xbtn+=200;
			this.add(this.botones[i]);
			
		}
		int y=25;
		int x=25;
		int cont=0;
		for(Album album:this.albumes) {
			if(cont%4==0 && cont!=0) {
				y+=250;
				x=25;
			}
			JLabel nuevo=new JLabel(album.getTitulo());
			nuevo.setFont(this.fuente);
			nuevo.setBackground(Color.BLUE);
			nuevo.setForeground(Color.WHITE);
			nuevo.setBounds(x, y, 100, 100);
			this.add(nuevo);
			
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
			g.drawString("Death of A Bachelor", x, y+175);
			g.drawString("Panic! At The Disco", x, y+200);
			x+=200;
		}
	}
}
