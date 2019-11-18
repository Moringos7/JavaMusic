import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelLista extends JPanel{
	private Playlist playlistActual;
	private JButton btnRandom,
					btnOrden,
					btnOpciones;
	private JComboBox ordenador;
	private Image imagen;
	private Font fuente;
	
	public PanelLista(String id, Font fuente) {
		super();
		this.setPreferredSize(new Dimension(1000,650));
		this.setLayout(null);
		this.imagen=new ImageIcon("DeathOfABachelor.jpg").getImage();
		this.btnRandom=new JButton("Aleatorio");
		this.btnOrden=new JButton("Reproducir");
		this.btnOpciones=new JButton("Opciones");
		this.ordenador=new JComboBox<>();
		this.ordenador.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.playlistActual=playlistActual;
		this.setBackground(Color.BLACK);
		this.fuente=fuente.deriveFont(30f);
		this.btnOrden.setBounds(325, 150, 100, 25);
		this.btnRandom.setBounds(450,150,100,25);
		this.btnOpciones.setBounds(575, 150, 100, 25);
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
