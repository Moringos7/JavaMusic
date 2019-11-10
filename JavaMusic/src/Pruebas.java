import java.util.LinkedList;

public class Pruebas {
	public static void main(String args[]) {
		LinkedList<Cancion> canciones = new LinkedList<Cancion>();
		canciones.add(new Cancion("barbiegirl"));
		canciones.add(new Cancion("bad"));
		canciones.add(new Cancion("hells bellls"));
		
		Reproductor rep = new Reproductor(canciones);
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
	}
}
