import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
public class PanelOpciones extends JPanel{
	private JButton btnInicio,
					btnAlbumes,
					btnArtistas,
					btnPlaylists;
	private JPanel panelGeneral;
	private VentanaJavaMusic ventana;
	private Font fuente;
	public PanelOpciones(JPanel panelGeneral, VentanaJavaMusic ventana, Font fuente) {
		super();
		this.panelGeneral=panelGeneral;
		this.ventana=ventana;
		this.setPreferredSize(new Dimension(150,650));
		this.btnInicio=new JButton("Inicio");
		this.btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.getContentPane().remove(panelGeneral);
				ventana.getContentPane().add(new PanelInicio(fuente));
				ventana.validate();
			}
		});
		this.btnAlbumes=new JButton("Albumes");
		this.btnAlbumes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.btnArtistas=new JButton("Artistas");
		this.btnArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.btnPlaylists=new JButton("Playlists");
		this.btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(this.btnInicio);
		this.add(this.btnAlbumes);
		this.add(this.btnArtistas);
		this.add(this.btnPlaylists);
	}
	public void paintComponent(Graphics g) {
		
	}
}
