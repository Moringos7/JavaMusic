import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Pruebas {
	public static void main(String args[]) {
		LinkedList<Cancion> canciones = new LinkedList<Cancion>();
		Connection conect = new Connection();
		Reproductor reproductor = null;
		try {
			reproductor = new Reproductor(conect.getCancionesArtista("1"));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			reproductor.play();
		}
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		reproductor.pause();
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		reproductor.play();
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		reproductor.nextSong();
		try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		reproductor.nextSong();
		try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		/*Iterator<Cancion> song = canciones.iterator();
		while(song.hasNext()) {
			System.out.println(song.next());
		}*/
		
		
	}
}
