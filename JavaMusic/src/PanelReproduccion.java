import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class PanelReproduccion extends JPanel{
	private Playlist<Cancion> playlist;
	private Cancion cancionActual;
	private JButton btnPlay,
					btnAnterior,
					btnSiguiente,
					btnMeGusta;
	private Reproductor reproductor;
	private JLabel labelTitulo,
				   labelArtista;
	private Font fuente;
	private Image imagen;
	private boolean mover;
	private int xb;
	private JProgressBar p;
	private boolean reproduciendo;
	private Timer timer;
	public PanelReproduccion(Font fuente) {
		super();
		this.setPreferredSize(new Dimension(850,100));
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		this.fuente=fuente.deriveFont(17f);
		this.labelTitulo=new JLabel();
		this.labelTitulo.setFont(this.fuente);
		this.labelTitulo.setBackground(Color.BLUE);
		this.labelTitulo.setForeground(Color.WHITE);
		this.labelTitulo.setBounds(100, 20, 190, 50);
		this.add(this.labelTitulo);
		this.labelArtista=new JLabel();
		this.labelArtista.setFont(this.fuente);
		this.labelArtista.setBackground(Color.BLUE);
		this.labelArtista.setForeground(Color.WHITE);
		this.labelArtista.setBounds(100, 40, 190, 50);
		this.add(this.labelArtista);
		this.xb=0;
		this.mover=false;
		this.p=new JProgressBar(0,1000);
		this.p.setBounds(300, 60, 500, 20);
		this.add(this.p);
		this.timer= new Timer(0,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mover) {
					xb++;
					p.setValue(xb);
				}
			}
			
		});
		this.btnAnterior=new JButton();
		this.btnAnterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reproductor.previousSong();
				setCancionActual(reproductor.getActualCancion());
			}
			
		});
		this.btnSiguiente=new JButton();
		this.btnSiguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reproductor.nextSong();
				setCancionActual(reproductor.getActualCancion());
			}
			
		});
		this.btnPlay=new JButton();
		this.btnPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnPlay.getText().equals("Pausa")) {
					reproductor.pause();
					btnPlay.setText("Play");
					mover=false;
				}else {
					reproductor.play();
					btnPlay.setText("Pausa");
					mover=true;
				}
			}
			
		});
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imagen, 20, 20, 60, 60, this);
	}
	public void setCancionActual(Cancion cancion) {
		this.cancionActual=cancion;
		this.mover=true;
		this.imagen=new ImageIcon(cancionActual.getImg()).getImage();
		this.btnMeGusta=new JButton("Me Gusta");
		this.btnMeGusta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnMeGusta.getText().equals("Me Gusta")) {
					btnMeGusta.setText("Ya No Me Gusta");
				}else {
					btnMeGusta.setText("Me Gusta");
				}
			}
		});
		this.btnMeGusta.setBounds(300, 20, 100, 25);
		this.add(btnMeGusta);
		this.btnPlay.setText("Pausa");
		this.btnPlay.setBounds(420, 20, 100, 25);
		this.add(this.btnPlay);
		this.btnAnterior.setText("Anterior");;
		this.btnAnterior.setBounds(540, 20, 100, 25);
		this.add(this.btnAnterior);
		this.btnSiguiente.setText("Siguiente");
		this.btnSiguiente.setBounds(660, 20, 100, 25);
		this.add(this.btnSiguiente);
		this.labelTitulo.setText(cancion.getTitulo());
		this.labelArtista.setText(cancion.getArtista());
		this.timer.setDelay(this.cancionActual.getDuracion());
		if(this.timer.isRunning()) {
			this.timer.stop();
		}
		this.xb=0;
		this.timer.start();
		if(this.playlist.isEmpty()) {
			this.btnAnterior.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		}
		else if(this.cancionActual.equals(this.playlist.First())) {
			this.btnAnterior.setEnabled(false);
			this.btnSiguiente.setEnabled(true);
		}
		else if(this.cancionActual.equals(this.playlist.Last())) {
			this.btnSiguiente.setEnabled(false);
			this.btnAnterior.setEnabled(true);
		}else {
			this.btnAnterior.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}
		this.repaint();
	}
	public void setReproductor(Reproductor reproductor) {
		if(this.reproduciendo) {
			this.reproductor.stopMusic();
		}
		this.reproductor=reproductor;
		this.reproductor.play();
		if(this.timer.isRunning()) {
			this.timer.stop();
		}
		this.xb=0;
		this.timer.start();
		this.reproduciendo=true;
		
	}
	
	public void setPlaylist(Playlist<Cancion> playlist) {
		this.playlist=playlist;
		this.playlist.pos=0;
		this.playlist.currentG=this.playlist.first;
	}
}
