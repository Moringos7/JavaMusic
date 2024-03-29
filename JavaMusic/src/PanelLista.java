import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLista extends JPanel{
	private Playlist<Cancion> playlist;
	private JButton btnRandom,
					btnOrden;
	private Image imagen;
	private Font fuente;
	private Reproductor reproductor;
	private PanelReproduccion pr;
	private JLabel labelTitulo;
	private LinkedList<JLabel>canciones;
	
	public PanelLista(Playlist<Cancion> playlist, Font fuente, PanelReproduccion pr) {
		super();
		this.setPreferredSize(new Dimension(1000,2000));
		this.pr=pr;
		this.setLayout(null);
		this.playlist=playlist;
		this.canciones=new LinkedList<>();
		this.reproductor=new Reproductor(this.playlist);
		this.imagen=new ImageIcon(playlist.First().getImg()).getImage();
		this.btnRandom=new JButton("Aleatorio");
		
		//Boton de Random
		this.btnRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Playlist<Cancion>nuevaPlaylist=playlist.getRandom();
				pr.setPlaylist(nuevaPlaylist);
				pr.getPlaylist().resetIterador();
				pr.setCancionActual(pr.getPlaylist().First());
				pr.setReproductor(new Reproductor(nuevaPlaylist));
				
			}
			
		});
		//Bot�n de Reproduccion
		this.btnOrden=new JButton("Reproducir");
		this.btnOrden.addActionListener(new ActionListener() {

			@Override
			//
			public void actionPerformed(ActionEvent e) {
				pr.setPlaylist(playlist);
				pr.getPlaylist().resetIterador();
				pr.setCancionActual(pr.getPlaylist().First());
				pr.setReproductor(new Reproductor(playlist));
			}
			
		});
		this.setBackground(Color.BLACK);
		this.fuente=fuente.deriveFont(20f);
		this.btnOrden.setBounds(325, 150, 100, 25);
		this.btnRandom.setBounds(450,150,100,25);
		this.labelTitulo=new JLabel(this.playlist.getTitulo());
		this.labelTitulo.setFont(this.fuente.deriveFont(40f));
		this.labelTitulo.setBackground(Color.BLUE);
		this.labelTitulo.setForeground(Color.WHITE);
		this.labelTitulo.setBounds(325,15,400,200);
		this.add(this.labelTitulo);
		int y=150;
		for(int i=0; i<this.playlist.size;i++) {
			Cancion cancion;
			if(i==0) {
				cancion=this.playlist.First();
			}else {
				cancion=this.playlist.next();
			}
			JLabel tituloCancion=new JLabel(cancion.getTitulo());
			tituloCancion.setFont(this.fuente);
			tituloCancion.setBackground(Color.BLUE);
			tituloCancion.setForeground(Color.WHITE);
			tituloCancion.setBounds(100,y,400,200);
			JLabel artista=new JLabel(cancion.getArtista());
			artista.setFont(this.fuente.deriveFont(15f));
			artista.setBackground(Color.BLUE);
			artista.setForeground(Color.WHITE);
			artista.setBounds(100, y+25, 200, 200);
			this.add(tituloCancion);
			this.add(artista);
			JButton btnReproducir= new JButton("Reproducir");
			btnReproducir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pr.setPlaylist(new Playlist<Cancion>());
					pr.setReproductor(new Reproductor(cancion));
					pr.setCancionActual(cancion);

				}
				
			});
			btnReproducir.setBounds(500, y+90, 100, 30);
			this.add(btnReproducir);
			y+=65;
		}
		this.add(this.btnOrden);
		this.add(this.btnRandom);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imagen, 100, 25, 200, 200, this);
		g.setColor(Color.WHITE);
		g.setFont(fuente);
		this.fuente=this.fuente.deriveFont(20f);
		
	}
	public void setImagen(String imagen) {
		this.imagen=new ImageIcon(imagen).getImage();
		this.repaint();
	}
	public void setReproductor(Reproductor reproductor) {
		this.reproductor=reproductor;
	}
}
