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

public class PanelResultado extends JPanel{
	private Font fuente;
	private Reproductor reproductor;
	private Busqueda busqueda;
	
	public PanelResultado(Font fuente, Busqueda busqueda) {
		super();
		this.setPreferredSize(new Dimension(1000,1500));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.fuente=fuente;
		this.busqueda=busqueda;
		JLabel resultado=new JLabel("Resultados");
		resultado.setFont(this.fuente);
		resultado.setBackground(Color.BLUE);
		resultado.setForeground(Color.WHITE);
		resultado.setBounds(150, 50, 200, 200);
		this.add(resultado);
		if(this.busqueda.getCanciones().isEmpty() && this.busqueda.getArtistas().isEmpty() && this.busqueda.getAlbumes().isEmpty()) {
			JLabel noEncontrado= new JLabel("No se encontraron resultados");
			noEncontrado.setFont(this.fuente);
			noEncontrado.setBackground(Color.BLUE);
			noEncontrado.setForeground(Color.WHITE);
			noEncontrado.setBounds(150, 50, 200, 200);
			this.add(noEncontrado);
		}else {
			JLabel canciones= new JLabel("Canciones");
			canciones.setFont(this.fuente);
			canciones.setBackground(Color.BLUE);
			canciones.setForeground(Color.WHITE);
			canciones.setBounds(150, 50, 200, 200);
			this.add(canciones);
			for(Cancion cancion:this.busqueda.getCanciones()) { 
				JLabel tituloCancion= new JLabel(cancion.getTitulo());
				tituloCancion.setFont(this.fuente);
				tituloCancion.setBackground(Color.BLUE);
				tituloCancion.setForeground(Color.WHITE);
				tituloCancion.setBounds(150, 50, 200, 200);
				this.add(tituloCancion);
				JButton btnReproducir= new JButton("Reproducir");
				btnReproducir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
					}
					
				});
				btnReproducir.setBounds(500, 90, 100, 30);
				this.add(btnReproducir);
			}
			JLabel artistas= new JLabel("Artistas");
			artistas.setFont(this.fuente);
			artistas.setBackground(Color.BLUE);
			artistas.setForeground(Color.WHITE);
			artistas.setBounds(150, 50, 200, 200);
			this.add(artistas);
			for(Artista artista: this.busqueda.getArtistas()) {
				JLabel labelArtista= new JLabel(artista.getNombre());
				labelArtista.setFont(this.fuente);
				labelArtista.setBackground(Color.BLUE);
				labelArtista.setForeground(Color.WHITE);
				labelArtista.setBounds(150, 150, 200, 200);
				this.add(labelArtista);
				JButton btnReproducir= new JButton("Ver Artista");
				btnReproducir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
					}
					
				});
				btnReproducir.setBounds(500, y+90, 100, 30);
				this.add(btnReproducir);
			}
			JLabel albumes= new JLabel("Albumes");
			albumes.setFont(this.fuente);
			albumes.setBackground(Color.BLUE);
			albumes.setForeground(Color.WHITE);
			albumes.setBounds(150, 50, 200, 200);
			this.add(albumes);
			for(Album album: this.busqueda.getAlbumes()) {
				JLabel labelAlbum= new JLabel("Canciones");
				labelAlbum.setFont(this.fuente);
				labelAlbum.setBackground(Color.BLUE);
				labelAlbum.setForeground(Color.WHITE);
				labelAlbum.setBounds(150, 50, 200, 200);
				this.add(labelAlbum);
				JButton btnReproducir= new JButton("Ver Album");
				btnReproducir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
					}
					
				});
				btnReproducir.setBounds(500, y+90, 100, 30);
				this.add(btnReproducir);
				
			}
	
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if() {
			for(Cancion cancion: this.busqueda.getCanciones()) { //Ahorita vemos que pedooooo pt.3
				Image imagen=new ImageIcon(cancion.getImg()).getImage();
				g.drawImage(imagen, 100, 100, 100, 1000, this);
				x+=300;
			}
			for(Artista artista: this.busqueda.getArtistas()) { //Ahorita vemos que pedooooo pt.3
				Image imagen=new ImageIcon(artista.getImg()).getImage();
				g.drawImage(imagen, 250, 100, 100, 1000, this);
				x+=400;
			}
			for(Album album: this.busqueda.getAlbumes()) { //Ahorita vemos que pedooooo pt.3
				Image imagen=new ImageIcon(album.getImg()).getImage();
				g.drawImage(imagen, 250, 100, 100, 1000, this);
				x+=400;
			}
		}
	}
}
