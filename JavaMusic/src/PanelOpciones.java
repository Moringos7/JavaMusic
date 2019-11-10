import java.awt.Dimension;
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
	public PanelOpciones(JPanel panelGeneral) {
		super();
		this.panelGeneral=panelGeneral;
		this.setPreferredSize(new Dimension(150,650));
		this.btnInicio=new JButton("Inicio");
		this.btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
