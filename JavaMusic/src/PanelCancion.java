import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCancion extends JPanel {
	private Album albumActual;
	private Cancion cancionActual;
	private Image imagen;
	private Font fuente;
	private JButton btnAgregarPlaylist,
					btnAgregarCola,
					btnAlbum,
					btnArtista;
	private JLabel labelCancion,
				   labelArtista;
	
	public PanelCancion(Album albumActual, Cancion cancionActual, Font fuente) {
		super();
		this.setPreferredSize(new Dimension(1000,650));
		this.setLayout(null);
		this.albumActual=albumActual;
		this.cancionActual=cancionActual;
		this.fuente=fuente;
		this.imagen=new ImageIcon("DeathOfABachelor.jpg").getImage();
		this.labelCancion=new JLabel("Victorious");
		this.labelCancion.setBackground(Color.BLUE);
		this.labelCancion.setForeground(Color.WHITE);
		this.labelCancion.setAlignmentX(0.5f);
		this.labelCancion.setBounds((int)this.labelCancion.getAlignmentX(), 250, 200, 200);
		//this.add(labelCancion);
		this.setBackground(Color.BLACK);
		this.btnAgregarPlaylist=new JButton ("Agregar a Playlist");
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imagen, 300, 25, 200, 200, this);
		
		
	}
}
