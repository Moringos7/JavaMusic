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
	public PanelInicio(Font fuente, VentanaJavaMusic ventana) {
		super();
		this.setPreferredSize(new Dimension(1000,650));
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.tfbuscador=new JTextField(10);
		this.btnBuscar=new JButton("Buscar");
		this.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfbuscador.getText().equals("")) {
					Busqueda busqueda= new Busqueda();
					busqueda.Busqueda(tfbuscador.getText());
					ventana.setPanelActual(new PanelResultado(fuente,busqueda));
				}
			}
		});
		
		this.bienvenida=fuente;
	
		this.labelBienvenida=new JLabel("Bienvenido a JavaMusic");
		this.labelBienvenida.setFont(bienvenida);
		this.labelBienvenida.setBackground(Color.BLUE);
		this.labelBienvenida.setForeground(Color.WHITE);
		this.tfbuscador.setBounds(200, 20, 200, 30);
		this.btnBuscar.setBounds(410, 20, 100, 30);
		this.labelBienvenida.setBounds(75, 50,800,200);
		this.add(this.tfbuscador);
		this.add(this.btnBuscar);
		this.add(labelBienvenida);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}	
