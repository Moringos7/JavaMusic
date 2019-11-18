
  
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
    private Iterator<Cancion> songs;
    private Queue<Cancion> cola;
    private LinkedList<String> ID;
   
    
    public Reproductor(Cancion song){
    	this.playlist = new Playlist<Cancion>();
    	this.cola = new LinkedList<Cancion>();
    	this.cola.add(song);
    	prepareSong(song.getTitulo());
    }
    public Reproductor(Playlist<Cancion> playlist) {
    	this.playlist = playlist;
    	this.cola = new LinkedList<Cancion>();
    	this.songs = playlist.iterator(); 
    	this.prepareSong(songs.next().getId());
    }
    
    private void prepareSong(String id){
    	this.validFlag = true;
    	this.setRutaMusica(id);
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
    		if(!this.cola.isEmpty()) {
        		prepareSong(cola.poll().getTitulo());
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
    		this.prepareSong(this.cola.poll().getId());
    	}else {
    		if(this.songs.hasNext()) {
        		this.prepareSong(this.songs.next().getId());
        	}else {
        		this.songs = playlist.iterator();
        		this.prepareSong(songs.next().getId());
        	}
    	}
    	this.sound.start();
    	
    }
    public void previousSong() {
    	
    }
    public void stopMusic() {
    	this.sound.stop();
    	this.sound.close();
    }

}