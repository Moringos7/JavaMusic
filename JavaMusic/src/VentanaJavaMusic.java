import java.awt.BorderLayout;

<<<<<<< HEAD
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
=======
public class VentanaJavaMusic {

	
	public static void main(String args[]) {
		Reproductor rep = new Reproductor("barbiegirl");
		rep.start();
		try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		rep.pause();
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		rep.play();
		try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		rep.stopMusic();
		rep.play();
>>>>>>> 5a8d39eb7290e7996433108f1689b99b23225a06
	}
}
