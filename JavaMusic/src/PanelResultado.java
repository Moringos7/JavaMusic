import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelResultado extends JPanel{
	private Font fuente;
	private Reproductor reproductor;
	
	public PanelResultado(Font fuente) {
		super();
		this.setPreferredSize(new Dimension(1000,1500));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.fuente=fuente;
		JLabel resultado=new JLabel("Resultados");
		resultado.setFont(this.fuente);
		resultado.setBackground(Color.BLUE);
		resultado.setForeground(Color.WHITE);
		resultado.setBounds(150, 50, 200, 200);
		this.add(resultado);
		if(true) { //Ahorita vemos que pedoooo
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
			for( ) { //Ahorita vemos que pedooooo pt.2
				JLabel tituloCancion= new JLabel("Canciones");
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
				btnReproducir.setBounds(500, y+90, 100, 30);
				this.add(btnReproducir);
			}
			JLabel canciones= new JLabel("Artistas");
			canciones.setFont(this.fuente);
			canciones.setBackground(Color.BLUE);
			canciones.setForeground(Color.WHITE);
			canciones.setBounds(150, 50, 200, 200);
			this.add(canciones);
			for() { //Ahorita vemos que pedooooo pt.2
				JLabel canciones= new JLabel("Artistas");
				canciones.setFont(this.fuente);
				canciones.setBackground(Color.BLUE);
				canciones.setForeground(Color.WHITE);
				canciones.setBounds(150, 150, 200, 200);
				this.add(canciones);
				JButton btnReproducir= new JButton("Ver Artista");
				btnReproducir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
					}
					
				});
				btnReproducir.setBounds(500, y+90, 100, 30);
				this.add(btnReproducir);
			}
			JLabel canciones= new JLabel("Albumes");
			canciones.setFont(this.fuente);
			canciones.setBackground(Color.BLUE);
			canciones.setForeground(Color.WHITE);
			canciones.setBounds(150, 50, 200, 200);
			this.add(canciones);
			for() {
				Label canciones= new JLabel("Canciones");
				canciones.setFont(this.fuente);
				canciones.setBackground(Color.BLUE);
				canciones.setForeground(Color.WHITE);
				canciones.setBounds(150, 50, 200, 200);
				this.add(canciones);
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
	public void painrtComponent(Graphics g) {
		super.paintComponent(g);
		if() {
			for() { //Ahorita vemos que pedooooo pt.3
				Image imagen=new ImageIcon("").getImage;
				g.drawImage(imagen, 100, 100, 100, 1000, this);
				x+=300;
			}
			for() { //Ahorita vemos que pedooooo pt.3
				Image imagen=new ImageIcon("").getImage;
				g.drawImage(imagen, 250, 100, 100, 1000, this);
				x+=400;
			}
			Image imagen=new ImageIcon("").getImage;
			g.drawImage(imagen, 250, 100, 100, 1000, this);
			x+=400;
		}
	}
}
