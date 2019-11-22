import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class VentanaJavaMusic extends JFrame {
	private JPanel panelGeneral;
	private JPanel panelActual;
	private JavaMusic app;
	private Font fuente;
	private JScrollPane scroll;
	private PanelOpciones po;
	private PanelReproduccion pr;
	
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
		this.panelGeneral=new JPanel();
		this.panelActual=new PanelInicio(this.fuente);
		this.panelGeneral.add(this.panelActual);
		this.pr=new PanelReproduccion(this.fuente);
		this.add(this.pr,BorderLayout.SOUTH);
		this.add(panelGeneral);
		this.po=new PanelOpciones(this.panelActual,this, this.fuente);
		this.add(this.po,BorderLayout.WEST);
		this.scroll=new JScrollPane(this.panelGeneral);
		this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(this.scroll);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	public JScrollPane getScroll() {
		return this.scroll;
	}
	public void setPanelActual(JPanel panelActual) {
		this.panelGeneral.remove(this.panelActual);
		this.panelGeneral.add(panelActual);
		this.panelActual=panelActual;
		this.po.setPanelActual(panelActual);
		this.revalidate();
	}
	public JPanel getPanelGeneral() {
		return this.panelGeneral;
	}
	public static void main(String[] args) {
		VentanaJavaMusic vjm= new VentanaJavaMusic();
	}
	public PanelReproduccion getPanelReproduccion() {
		return this.pr;
	}
}
