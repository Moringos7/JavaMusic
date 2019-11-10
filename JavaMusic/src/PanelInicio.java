import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;//Borrar si no funciona
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;//Borrar si no funciona
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; //Borrar si no funciona
import java.io.IOException;//Borrar si no funciona
import javax.swing.JButton;
import javax.swing.JLabel;//Borrar si no funciona
import javax.swing.JPanel;
import javax.swing.JTextField;
public class PanelInicio extends JPanel {
	private JTextField tfbuscador;
	private JButton btnBuscar;
	private Font bienvenida;
	private JLabel labelBienvenida;
	public PanelInicio() {
		super();
		this.setPreferredSize(new Dimension(1000,650));
		this.tfbuscador=new JTextField(10);
		this.btnBuscar=new JButton("Buscar");
		this.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.add(this.tfbuscador);
		this.add(this.btnBuscar);
		/*try {
			this.bienvenida=Font.createFont(Font.TRUETYPE_FONT, new File("Computerfont.ttf")).deriveFont(60f);
			GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(bienvenida);
		}catch(IOException ex) {
			
		}catch (FontFormatException ex) {
			
		}
		this.labelBienvenida=new JLabel("Bienvenido a JavaMusic");
		this.labelBienvenida.setBackground(Color.BLUE);
		this.labelBienvenida.setForeground(Color.WHITE);
		this.labelBienvenida.setFont(bienvenida);
		this.add(labelBienvenida);*/
		
	}
	public void paintComponent(Graphics g) {
		this.tfbuscador.setLocation(300, 100);
		this.btnBuscar.setLocation(400, 100);
		this.setBackground(Color.BLACK);
	}
}
