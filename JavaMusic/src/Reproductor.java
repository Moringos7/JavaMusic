
  
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
    private boolean reproduciendo,
    				isOn;
   
    public Reproductor(Cancion song){
    	this.playlist = new Playlist<Cancion>();
    	this.cola = new LinkedList<Cancion>();
    	this.cola.add(song);
    	prepareSong(song);
    	this.isOn = true;
    }
    public Reproductor(Playlist<Cancion> playlist) {
    	this.playlist = playlist;
    	this.cola = new LinkedList<Cancion>(); 
    	this.prepareSong(playlist.next());
    	this.isOn = true;
    	
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
    
    public Cancion getActualCancion(){
    	return actualCancion;
    }
        
    private void setRutaMusica(String musica)
    {
         this.rutaMusica = this.rutaGeneral + musica +".wav";
    }
    
  ///Metodo de hilo
    public void run() {
    	this.sound.start();
    	while(isOn){
    		if(this.sound.isActive()) {
				while(this.sound.getFrameLength() != this.sound.getFramePosition()){
		    		try {
		                Thread.sleep(200);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		    		//System.out.println(this.sound.getFrameLength() +"|||"+ this.sound.getFramePosition());
		    	}
				//System.out.println("Desactivado");
				this.nextSong();
    		}
    		//System.out.println("No Song");
    		try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    	}
    }
    public void closeThread() {
    	this.sound.setFramePosition(this.sound.getFrameLength());
    	this.isOn = false;
    }
    public void play(){
    	this.sound.start();
    }
    public void pause() {
    	this.sound.stop();
    }
    public void nextSong() {
    	this.stopMusic();
    	if(!cola.isEmpty()) {
    		this.prepareSong(this.cola.poll());
    	}else {
    		if(this.playlist.hasNext()) {
        		this.prepareSong(this.playlist.next());
        	}else {
        		//Verificar regresar al final
        	}
    	}
    	this.play();
    }
    public void previousSong() {
    	this.stopMusic();
    	
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