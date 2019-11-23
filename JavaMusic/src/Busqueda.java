import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Busqueda {
	private LinkedList<Cancion> canciones;
	private LinkedList<Artista> artistas;
	private LinkedList<Album> albumes;
	private String param;
	public Busqueda () {
		this.canciones = new LinkedList<Cancion>();
		this.artistas = new LinkedList<Artista>();
		this.albumes = new LinkedList<Album>();
	}
	public LinkedList<Cancion> getCanciones() {
		return canciones;
	}
	public LinkedList<Artista> getArtistas() {
		return artistas;
	}
	public LinkedList<Album> getAlbumes() {
		return albumes;
	}

	public void Busqueda(String param) {
		this.param = param;
		Connection conect = new Connection();
		LinkedList<String> data = conect.getSearchResult(param);
		Cancion cancion;
		Artista artista;
		Album album;
		StringTokenizer tokens;
		int seccion = 0;

		for(int i=0;i<data.size();i++) {
			String Result = data.get(i);
			if(Result.equals("---")) {
				seccion++;
			}else {
				switch(seccion) {
				case 0:
					//Cancion
					tokens = new StringTokenizer(Result,"|");
					this.canciones.add(new Cancion(tokens.nextToken(),
							tokens.nextToken(),
							Integer.parseInt(tokens.nextToken()),
							tokens.nextToken(),
							tokens.nextToken()));
					break;
				case 1:
					//Artista
					tokens = new StringTokenizer(Result,"|");
					this.artistas.add(new Artista(tokens.nextToken(),
							tokens.nextToken(),
							tokens.nextToken()));
					break;
				case 2:
					//Album
					tokens = new StringTokenizer(Result,"|");
					this.albumes.add(new Album(tokens.nextToken(),
							tokens.nextToken(),
							tokens.nextToken(),
							tokens.nextToken()));
					break;
				}
			}	
		}
	}
	public static void main(String[] args) {
		Busqueda search = new Busqueda();
		search.Busqueda("a");
		for(Cancion cancion : search.canciones) {
			System.out.println(cancion);
		}
		for(Artista artista : search.artistas) {
			System.out.println(artista);
		}
		for(Album album : search.albumes) {
			System.out.println(album);
		}
	}
}
