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

public class PanelArtistas extends JPanel{
	private Font fuente;
	private LinkedList<Image>imagenes;
	private LinkedList<Artista>artistas;
	private Connection coneccion;
	private VentanaJavaMusic ventana;
	public PanelArtistas(Font fuente, VentanaJavaMusic ventana) {
		super();
		this.setPreferredSize(new Dimension(1000,800));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.fuente=fuente.deriveFont(20f);
		this.coneccion=new Connection();
		this.imagenes=new LinkedList<>();
		this.ventana=ventana;
		try {
			this.artistas=coneccion.getArtistas();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		int xbtn=50;
		int ybtn=220;
		int y=90;
		int x=25;
		int cont=0;
		for(Artista artista:this.artistas) {
			if(cont%4==0 && cont!=0) {
				y+=250;
				x=25;
				ybtn+=250;
				xbtn=50;
			}
			JLabel nuevoArtista=new JLabel(artista.getNombre());
			nuevoArtista.setFont(this.fuente);
			nuevoArtista.setBackground(Color.BLUE);
			nuevoArtista.setForeground(Color.WHITE);
			nuevoArtista.setBounds(x, y, 200, 200);
			this.add(nuevoArtista);
			x+=200;
			Image nuevaImagen=new ImageIcon(artista.getImg()).getImage();
			this.imagenes.add(nuevaImagen);
			cont++;
			JButton nuevoBoton=new JButton("Ver Artista");
			nuevoBoton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
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
			nuevoBoton.setBounds(xbtn, ybtn, 100, 25);
			xbtn+=200;
			this.add(nuevoBoton);
		}
		
	}
	public void paintComponent(Graphics g) {
		int y=25;
		int x=25;
		int cont=0;
		super.paintComponent(g);
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
