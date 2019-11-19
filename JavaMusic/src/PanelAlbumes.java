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
	private LinkedList<Image> imagenes;
	private LinkedList<Album> albumes;
	private Connection coneccion;
	private VentanaJavaMusic ventana;
	private PanelOpciones po;
	public PanelAlbumes(Font fuente, VentanaJavaMusic ventana) {
		super();
		this.setPreferredSize(new Dimension(1000,800));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.ventana=ventana;
		this.po=po;
		this.fuente=fuente.deriveFont(15f);
		this.imagenes=new LinkedList<>();
		this.coneccion=new Connection();
		try {
			this.albumes=coneccion.getAlbumes();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		int xbtn=50;
		int ybtn=240;
		int y=90;
		int x=25;
		int cont=0;
		for(Album album:this.albumes) {
			if(cont%4==0 && cont!=0) {
				y+=250;
				x=25;
				ybtn+=250;
				xbtn=50;
			}
			JLabel nuevoAlbum=new JLabel(album.getTitulo());
			nuevoAlbum.setFont(this.fuente);
			nuevoAlbum.setBackground(Color.BLUE);
			nuevoAlbum.setForeground(Color.WHITE);
			nuevoAlbum.setBounds(x, y, 200, 200);
			this.add(nuevoAlbum);
			JLabel nuevoArtista=new JLabel(album.getNombreArtista());
			nuevoArtista.setFont(this.fuente);
			nuevoArtista.setBackground(Color.BLUE);
			nuevoArtista.setForeground(Color.WHITE);
			nuevoArtista.setBounds(x, y+25, 200, 200);
			this.add(nuevoArtista);
			x+=200;
			Image nuevaImagen=new ImageIcon(album.getImg()).getImage();
			this.imagenes.add(nuevaImagen);
			cont++;
			JButton nuevoBoton=new JButton("Ver Album");
			nuevoBoton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Playlist<Cancion> playlist=null;
					try {
						playlist=coneccion.getCancionesAlbum(album.getId());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PanelLista pl=new PanelLista(playlist,fuente);
					ventana.setPanelActual(pl);
					
					
				}
				
			});
			nuevoBoton.setBounds(xbtn, ybtn, 100, 25);
			xbtn+=200;
			this.add(nuevoBoton);
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y=25;
		int x=25;
		int cont=0;
		for (Image imagen: this.imagenes) {
			if(cont%4==0 && cont!=0) {
				y+=250;
				x=25;
			}
			g.drawImage(imagen, x, y, 150, 150, this);
			x+=200;
			cont++;
		}
	}
}
