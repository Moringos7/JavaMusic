import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class VentanaJavaMusic extends JFrame {
	private JPanel panelGeneral;
	private JavaMusic app;
	private PanelOpciones po;
	private Font fuente;
	
	public VentanaJavaMusic() {
		super("JavaMusic");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,650);
		try {
			this.fuente=Font.createFont(Font.TRUETYPE_FONT, new File("CircularStd-Black.otf")).deriveFont(60f);
			GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fuente);
		}catch(IOException ex) {
			ex.printStackTrace();
		}catch (FontFormatException ex) {
			ex.printStackTrace();
		}
		this.panelGeneral=new PanelLista(null,this.fuente);

		this.add(panelGeneral);
		this.add(new PanelOpciones(this.panelGeneral,this, this.fuente),BorderLayout.WEST);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		VentanaJavaMusic vjm= new VentanaJavaMusic();
	}
}
