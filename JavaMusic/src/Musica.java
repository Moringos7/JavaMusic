
  
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.*;
import java.io.*;
import java.util.concurrent.TimeUnit;


public class Musica {
    public static final int ELEMENT_ID = 2;
    protected boolean validFlag;
    protected Clip sound;
    private String soundPath;


    public Musica(String soundPath) {
        this.setSoundPath(soundPath);
        this.validFlag = true;
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.soundPath));
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            this.sound = (Clip)AudioSystem.getLine(info);
            this.sound.open(audioInputStream);
        }
        catch(Exception e)
        {
            this.validFlag = false;
        }
        this.play();
    }

    public void setSoundPath(String soundPath)
    {
        this.soundPath =  soundPath +".wav";
    }
    public void play(){
        if(this.validFlag){
            this.sound.setFramePosition(0);
            this.sound.start();
        }
    }
    public void checkRestart(){
        if(!this.sound.isRunning()){
            this.play();
        }
    }
    public void stop(){
        if(this.validFlag){
            this.sound.stop();
            this.sound.close();
        }
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("fgdg");
            e.printStackTrace();
        }
        new Musica("1up");
    }