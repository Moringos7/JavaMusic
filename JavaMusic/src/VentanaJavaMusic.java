
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
	}
}
