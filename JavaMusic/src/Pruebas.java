import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Pruebas {
	public static void main(String args[]) {
		Playlist<Cancion> canciones = new Playlist<Cancion>();
		Connection conect = new Connection();
		Reproductor reproductor = null;
		canciones.addLast(new Cancion("997"));
		canciones.addLast(new Cancion("998"));
		canciones.addLast(new Cancion("999"));
		reproductor = new Reproductor(canciones);
		reproductor.start();
		reproductor.play();
		
		try {
            Thread.sleep(10000);//Cancion 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		reproductor.previousSong();
	}
}
