import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class VentanaJavaMusic extends JFrame {
	private JPanel panelGeneral;
	private JavaMusic app;
	private PanelOpciones po;
	
	public VentanaJavaMusic() {
		super("JavaMusic");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,650);
		this.panelGeneral=new PanelInicio();
		this.po=new PanelOpciones();
		this.add(po, BorderLayout.WEST);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		VentanaJavaMusic vjm= new VentanaJavaMusic();
	}
}
