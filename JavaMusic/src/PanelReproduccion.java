import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelReproduccion extends JPanel{
	private Album albumActual;
	private Cancion cancionActual;
	private JButton btnPlay,
					btnAnterior,
					btnSiguiente;
	
	public PanelReproduccion(Album albumActual,Cancion cancionActual) {
		this.albumActual=albumActual;
		this.cancionActual=cancionActual;
	}
}
