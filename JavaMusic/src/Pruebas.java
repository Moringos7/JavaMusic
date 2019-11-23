import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Pruebas {
	public static void main(String args[]) {
		Playlist<Cancion> canciones = new Playlist<Cancion>();
		Connection conect = new Connection();
		Reproductor reproductor = null;
		canciones.addLast(new Cancion("1"));
		canciones.addLast(new Cancion("2"));
		canciones.addLast(new Cancion("3"));
		reproductor = new Reproductor(canciones);
		reproductor.start();
		reproductor.play();
		
		try {
            Thread.sleep(3000);//Cancion 1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		reproductor.nextSong();
		try {
            Thread.sleep(3000);//Cancion 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		reproductor.previousSong();
		
		try {
            Thread.sleep(3000);//Cancion 1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		reproductor.nextSong();
		try {
            Thread.sleep(3000);//Cancion 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		reproductor.nextSong();
		
		try {
            Thread.sleep(3000);//Cancion 3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		reproductor.closeThread();
	}
}
