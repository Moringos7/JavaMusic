
  
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;


public class Reproductor extends Thread {
	
	final private String rutaGeneral = "music/";
    private boolean validFlag,
    				pause = false;
    protected Clip sound;
    private String rutaMusica;
    private LinkedList<Cancion> playlist;
    private Queue<Cancion> cola;
   
    
    public Reproductor(Cancion song){
    	this.playlist = new LinkedList<Cancion>();
    	this.cola = new LinkedList<Cancion>();
    	this.cola.add(song);
    	prepareSong(song.getTitulo());
    }
    public Reproductor(LinkedList<Cancion> playlist) {
    	this.playlist = playlist;
    	this.cola = new LinkedList<Cancion>();
    	prepareSong(playlist.get(0).getTitulo());
    }
    
    private void prepareSong(String dato){
    	this.validFlag = true;
    	this.setRutaMusica(dato);
        this.validFlag = true;
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.rutaMusica));
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            this.sound = (Clip)AudioSystem.getLine(info);
            this.sound.open(audioInputStream);
            this.sound.setFramePosition(0);
        }
        catch(Exception e)
        {
        	this.validFlag = false;
        	System.out.println(e);
        }
    }
    
    /*public Reproductor(String musica) {
        this.setRutaMusica(musica);
        this.validFlag = true;
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.rutaMusica));
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            this.sound = (Clip)AudioSystem.getLine(info);
            this.sound.open(audioInputStream);
            this.sound.setFramePosition(0);
        }
        catch(Exception e)
        {
        	this.validFlag = false;
        	System.out.println(e);
        }
    }*/
    
    private void setRutaMusica(String musica)
    {
         this.rutaMusica = this.rutaGeneral + musica +".wav";
    }
    
  ///Metodo de hilo
    public void run() {
    	this.play();
    	while(this.sound.isOpen()) {
    		if(pause) {
    			pause();
    		}
    		try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    	}
    	if(!this.cola.isEmpty()) {
    		prepareSong(cola.poll().getTitulo());
    	}
    }
    public void play(){
        this.sound.start();
    }
    public void pause() {
    	this.sound.stop();
    }
    public void stopMusic() {
    	this.sound.stop();
    	this.sound.close();
    }

}