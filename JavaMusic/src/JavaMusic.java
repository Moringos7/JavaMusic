import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class JavaMusic {
	private Playlist listaFavoritos;
	private Playlist listaNegados;
	private Reproductor reproductor;
	private Hashtable<String,Artista>artistas;
	private Hashtable<String,Album>albumes;
	private Hashtable<String, Genero>generos;
	
	public JavaMusic() {
		try {
			BufferedReader bf=new BufferedReader(new FileReader("playlist.txt"));
			while(bf.readLine()!=null) {
				String linea;
				while(!(linea=bf.readLine()).equals("-")) {
					//this.listaFavoritos.canciones.add(linea);
				}
			}
		}catch(FileNotFoundException ex) {
			System.out.println("No se encontro el archivo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
