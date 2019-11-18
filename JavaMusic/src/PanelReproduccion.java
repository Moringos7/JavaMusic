import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelReproduccion extends JPanel{
	private Album albumActual;
	private Cancion cancionActual;
	private JButton btnPlay,
					btnAnterior,
					btnSiguiente,
					btnMeGusta;
	private Reproductor reproductor;
	private JLabel labelTitulo,
				   labelArtista;
	private Font fuente;
	private Image imagen;
	
	public PanelReproduccion() {
		
	}
	public PanelReproduccion(Album albumActual,Cancion cancionActual, Font fuente) {
		super();
		this.setPreferredSize(new Dimension(850,100));
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		this.fuente=fuente.deriveFont(17f);
		this.albumActual=albumActual;
		this.cancionActual=cancionActual;
		this.imagen=new ImageIcon("DeathOfABachelor.jpg").getImage();
		this.btnMeGusta=new JButton("Me Gusta");
		this.btnMeGusta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnMeGusta.getText().equals("Me Gusta")) {
					btnMeGusta.setText("Ya No Me Gusta");
				}else {
					btnMeGusta.setText("Me Gusta");
				}
			}
		});
		this.btnMeGusta.setBounds(300, 30, 140, 20);
		this.add(this.btnMeGusta);
		this.labelTitulo=new JLabel("Victorious");
		this.labelTitulo.setFont(this.fuente);
		this.labelTitulo.setBackground(Color.BLUE);
		this.labelTitulo.setForeground(Color.WHITE);
		this.labelTitulo.setBounds(100, 20, 190, 50);
		this.add(this.labelTitulo);
		this.labelArtista=new JLabel("Panic! At The Disco");
		this.labelArtista.setFont(this.fuente);
		this.labelArtista.setBackground(Color.BLUE);
		this.labelArtista.setForeground(Color.WHITE);
		this.labelArtista.setBounds(100, 40, 190, 50);
		this.add(this.labelArtista);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imagen, 20, 20, 60, 60, this);
		g.setFont(this.fuente);
		g.setColor(Color.WHITE);
		//g.drawString("Victorious", 100, 45);
		//g.drawString("Panic! At The Disco", 100, 70);
	}
}
