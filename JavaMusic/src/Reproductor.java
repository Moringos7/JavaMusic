
  
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.*;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;



public class Reproductor extends Thread {
	
	final private String rutaGeneral = "music/";
    private boolean validFlag,
    				pause = false;
    protected Clip sound;
    private String rutaMusica;
    private Playlist<Cancion> playlist;
    private Queue<Cancion> cola;
    private LinkedList<String> Ids;
    private Cancion actualCancion;
   
    public Reproductor(Cancion song){
    	this.playlist = new Playlist<Cancion>();
    	this.cola = new LinkedList<Cancion>();
    	this.cola.add(song);
    	prepareSong(song);
    }
    public Reproductor(Playlist<Cancion> playlist) {
    	this.playlist = playlist;
    	this.cola = new LinkedList<Cancion>(); 
    	this.prepareSong(playlist.next());
    }
    
    private void prepareSong(Cancion cancion){
    	this.validFlag = true;
    	actualCancion = cancion;
    	this.setRutaMusica(cancion.getId());
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
    
    private Cancion getActualCancion(){
    	return actualCancion;
    }
        
    private void setRutaMusica(String musica)
    {
         this.rutaMusica = this.rutaGeneral + musica +".wav";
    }
    
  ///Metodo de hilo
    public void run() {
    	this.play();
    	while(!this.cola.isEmpty()) {
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
    	}
    }
    
    public void play(){
        this.sound.start();
    }
    public void pause() {
    	this.sound.stop();
    }
    public void nextSong() {
    	this.pause();
    	if(!cola.isEmpty()) {
    		this.prepareSong(this.cola.poll());
    	}else {
    		if(this.playlist.hasNext()) {
        		this.prepareSong(this.playlist.next());
        	}else {
        		//Verificar regresar al final
        	}
    	}
    	this.sound.start();
    	
    }
    public void previousSong() {
    	this.pause();
    	
		if(this.playlist.hasPrevious()) {
    		this.prepareSong(this.playlist.previous());
    	}else {
    		//Verificar el inicio
    	}
    	this.sound.start();
    }
    public void stopMusic() {
    	this.sound.stop();
    	this.sound.close();
    }

}