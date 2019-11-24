import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelResultado extends JPanel{
	private Font fuente;
	private Reproductor reproductor;
	private Busqueda busqueda;
	private PanelReproduccion pr;
	private VentanaJavaMusic ventana;
	private Connection coneccion;
	
	public PanelResultado(Font fuente, Busqueda busqueda, VentanaJavaMusic ventana) {
		super();
		this.setPreferredSize(new Dimension(1000,1000));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.fuente=fuente.deriveFont(40f);
		this.busqueda=busqueda;
		this.ventana=ventana;
		this.coneccion=new Connection();
		JLabel resultado=new JLabel("Resultados");
		resultado.setFont(this.fuente);
		resultado.setBackground(Color.BLUE);
		resultado.setForeground(Color.WHITE);
		resultado.setBounds(0, -50, 400, 200);
		this.add(resultado);
		if(busqueda.getCanciones().isEmpty() && busqueda.getArtistas().isEmpty() && busqueda.getAlbumes().isEmpty()) { //Ahorita vemos que pedoooo
			JLabel noEncontrado= new JLabel("No se encontraron resultados");
			noEncontrado.setFont(this.fuente);
			noEncontrado.setBackground(Color.BLUE);
			noEncontrado.setForeground(Color.WHITE);
			noEncontrado.setBounds(25, 50, 1000, 200);
			this.add(noEncontrado);
		}else {
			int xlabel=25;
			int ylabel=220;
			int contLabel=0;
			int xbtn=50;
			int ybtn=335;
			this.fuente=this.fuente.deriveFont(20f);
			if(!this.busqueda.getCanciones().isEmpty()) {
				JLabel canciones= new JLabel("Canciones");
				canciones.setFont(this.fuente);
				canciones.setBackground(Color.BLUE);
				canciones.setForeground(Color.WHITE);
				canciones.setBounds(25, 10, 200, 200);
				this.add(canciones);
				for(Cancion cancion: busqueda.getCanciones() ) { 
					if(contLabel%4==0 && contLabel!=0) {
						ylabel+=250;
						xlabel=25;
						ybtn+=250;
						xbtn=50;
					}
					JLabel tituloCancion= new JLabel(cancion.getTitulo());
					tituloCancion.setFont(this.fuente);
					tituloCancion.setBackground(Color.BLUE);
					tituloCancion.setForeground(Color.WHITE);
					tituloCancion.setBounds(xlabel, ylabel, 200, 200);
					this.add(tituloCancion);
					JButton btnReproducir= new JButton("Reproducir");
					btnReproducir.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							ventana.getPanelReproduccion().setPlaylist(new Playlist<Cancion>());
							ventana.getPanelReproduccion().setReproductor(new Reproductor(cancion));
							ventana.getPanelReproduccion().setCancionActual(cancion);
						}
						
					});
					btnReproducir.setBounds(xbtn, ybtn, 100, 30);
					this.add(btnReproducir);
					xlabel+=200;
					xbtn+=200;
				}
				ylabel+=300;
				xlabel=25;
				ybtn+=300;
				xbtn=50;
				contLabel=0;
			}
			if(!this.busqueda.getArtistas().isEmpty()) {
				JLabel artistas= new JLabel("Artistas");
				artistas.setFont(this.fuente);
				artistas.setBackground(Color.BLUE);
				artistas.setForeground(Color.WHITE);
				artistas.setBounds(25, ylabel-200, 200, 200);
				this.add(artistas);
				for(Artista artista: busqueda.getArtistas()) { 
					if(contLabel%4==0 && contLabel!=0) {
						ylabel+=250;
						xlabel=25;
						ybtn+=250;
						xbtn=50;
					}
					JLabel labelArtista= new JLabel(artista.getNombre());
					labelArtista.setFont(this.fuente);
					labelArtista.setBackground(Color.BLUE);
					labelArtista.setForeground(Color.WHITE);
					labelArtista.setBounds(xlabel, ylabel, 200, 200);
					this.add(labelArtista);
					JButton btnArtista= new JButton("Ver Artista");
					btnArtista.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Playlist<Cancion> playlist=null;
							try {
								playlist=coneccion.getCancionesArtista(artista.getId());
								playlist.setTitulo(artista.getNombre());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							PanelLista pl=new PanelLista(playlist,fuente,ventana.getPanelReproduccion());
							pl.setImagen(artista.getImg());
							ventana.setPanelActual(pl);
						}
						
					});
					btnArtista.setBounds(xbtn, ybtn, 100, 30);
					this.add(btnArtista);
					xlabel+=200;
					xbtn+=200;
				}
				ylabel+=300;
				xlabel=25;
				ybtn+=300;
				xbtn=50;
				contLabel=0;
			}
			if(!this.busqueda.getAlbumes().isEmpty()) {
				JLabel albumes= new JLabel("Albumes");
				albumes.setFont(this.fuente);
				albumes.setBackground(Color.BLUE);
				albumes.setForeground(Color.WHITE);
				albumes.setBounds(25, ylabel-200, 200, 200);
				this.add(albumes);
				for(Album album: busqueda.getAlbumes()) {
					if(contLabel%4==0 && contLabel!=0) {
						ylabel+=250;
						xlabel=25;
						ybtn+=250;
						xbtn=50;
					}
					JLabel labelAlbum= new JLabel(album.getTitulo());
					labelAlbum.setFont(this.fuente);
					labelAlbum.setBackground(Color.BLUE);
					labelAlbum.setForeground(Color.WHITE);
					labelAlbum.setBounds(xlabel, ylabel, 200, 200);
					this.add(labelAlbum);
					JButton btnAlbum= new JButton("Ver Album");
					btnAlbum.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Playlist<Cancion> playlist=null;
							try {
								playlist=coneccion.getCancionesArtista(album.getId());
								playlist.setTitulo(album.getTitulo());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							PanelLista pl=new PanelLista(playlist,fuente,ventana.getPanelReproduccion());
							pl.setImagen(album.getImg());
							ventana.setPanelActual(pl);
						}
						
					});
					btnAlbum.setBounds(xbtn, ybtn, 100, 30);
					this.add(btnAlbum);
					xlabel+=200;
					xbtn+=200;
				}
			}
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x=25;
		int y=150;
		int cont=0;
		if(!this.busqueda.getCanciones().isEmpty()) {
			for(Cancion cancion: busqueda.getCanciones()) { 
				if(cont%4==0 && cont!=0) {
					y+=250;
					x=25;
				}
				Image imagen=new ImageIcon(cancion.getImg()).getImage();
				g.drawImage(imagen, x, y, 150, 150, this);
				x+=200;
				cont++;
			}
			x=25;
			y+=300;
			cont=0;
		}
		if(!this.busqueda.getArtistas().isEmpty()) {
			for(Artista artista: busqueda.getArtistas()) {
				if(cont%4==0 && cont!=0) {
					y+=250;
					x=25;
				}
				Image imagen=new ImageIcon(artista.getImg()).getImage();
				g.drawImage(imagen, x, y, 150, 150, this);
				x+=200;
				cont++;
			}
			x=25;
			y+=300;
			cont=0;
		}
		if(!this.busqueda.getAlbumes().isEmpty()) {
			for(Album album: busqueda.getAlbumes()) {
				if(cont%4==0 && cont!=0) {
					y+=250;
					x=25;
				}
				Image imagen=new ImageIcon(album.getImg()).getImage();
				g.drawImage(imagen, x, y, 150, 150, this);
				x+=200;
			}
		}
	}
}
