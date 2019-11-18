import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class PanelOpciones extends JPanel{
	private JButton btnInicio,
					btnAlbumes,
					btnArtistas,
					btnPlaylists;
					
	private JPanel panelActual;
	private VentanaJavaMusic ventana;
	private Font fuente;
	public PanelOpciones(JPanel panelActual, VentanaJavaMusic ventana, Font fuente) {
		super();
		this.panelActual=panelActual;
		this.ventana=ventana;
		this.setPreferredSize(new Dimension(150,650));
		this.btnInicio=new JButton("Inicio");
		this.btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelInicio pi=new PanelInicio(fuente);
				ventana.setPanelActual(pi);
				setPanelActual(pi);
			}
		});
		this.btnAlbumes=new JButton("Albumes");
		this.btnAlbumes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAlbumes pal=new PanelAlbumes(fuente);
				ventana.setPanelActual(pal);
				setPanelActual(pal);
			}
		});
		this.btnArtistas=new JButton("Artistas");
		this.btnArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelArtistas par=new PanelArtistas(fuente);
				ventana.setPanelActual(par);
				setPanelActual(par);
			}
		});
		this.btnPlaylists=new JButton("Playlists");
		this.btnPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPlaylists pp=new PanelPlaylists(fuente);
				ventana.setPanelActual(pp);
				setPanelActual(pp);
			}
		});
		this.add(this.btnInicio);
		this.add(this.btnAlbumes);
		this.add(this.btnArtistas);
		this.add(this.btnPlaylists);
	}
	public void setPanelActual(JPanel panelActual) {
		this.panelActual=panelActual;
	}
	public void paintComponent(Graphics g) {
		
	}
}
