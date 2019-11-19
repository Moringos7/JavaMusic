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
	private Playlist<Cancion> playlistActual;
	private JButton btnRandom,
					btnOrden,
					btnOpciones;
	private JComboBox ordenador;
	private Image imagen;
	private Font fuente;
	private Reproductor reproductor;
	private PanelReproduccion pr;
	private JLabel labelTitulo;
	private LinkedList<JLabel>canciones;
	
	public PanelLista(Playlist<Cancion> playlist, Font fuente) {
		super();
		this.setPreferredSize(new Dimension(1000,650));
		this.setLayout(null);
		this.playlistActual=playlist;
		this.canciones=new LinkedList<>();
		this.reproductor=new Reproductor(this.playlistActual);
		this.imagen=new ImageIcon(playlist.First().getImg()).getImage();
		this.btnRandom=new JButton("Aleatorio");
		this.btnRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		this.btnOrden=new JButton("Reproducir");
		this.btnOrden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reproductor.play();
				pr=new PanelReproduccion(playlist.First(),fuente);
				
			}
			
		});
		this.btnOpciones=new JButton("Opciones");
		this.btnOpciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.ordenador=new JComboBox<>();
		this.ordenador.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.setBackground(Color.BLACK);
		this.fuente=fuente.deriveFont(30f);
		this.btnOrden.setBounds(325, 150, 100, 25);
		this.btnRandom.setBounds(450,150,100,25);
		this.btnOpciones.setBounds(575, 150, 100, 25);
		this.labelTitulo=new JLabel(this.playlistActual.getTitulo());
		this.labelTitulo.setFont(this.fuente);
		this.labelTitulo.setBackground(Color.BLUE);
		this.labelTitulo.setForeground(Color.WHITE);
		this.add(this.btnOrden);
		this.add(this.btnRandom);
		this.add(btnOpciones);
	}
	public void paintComponent(Graphics g) {
		String[] lista= {"Victorious", "Don't Threaten Me with a Good Time","Hallelujah","Emperor's New Clothes", "Death of a Bachelor"};
		int y=275;
		super.paintComponent(g);
		g.drawImage(this.imagen, 100, 25, 200, 200, this);
		g.setColor(Color.WHITE);
		g.setFont(fuente);
		g.drawString("Death of a Bachelor", 325, 130);
		this.fuente=this.fuente.deriveFont(20f);
		Font fuenteAlternativa=this.fuente.deriveFont(15f);
		for(int i=0; i<lista.length;i++) {
			g.setFont(fuente);
			g.drawString(lista[i],100, y);
			g.setFont(fuenteAlternativa);
			g.drawString("Panic! at The Disco-Death of a Bachelor", 100, y+20);
			y+=60;
		}
		
	}
}
