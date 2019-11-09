import java.util.LinkedList;

public class Cancion {
	private int id,
				duracion;
	private LinkedList<String> artista;
	private String titulo,
				   genero,
				   URL,
				   img;
	public Cancion(String titulo) {
		this.titulo = titulo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public LinkedList<String> getArtista() {
		return artista;
	}
	public void setArtista(LinkedList<String> artista) {
		this.artista = artista;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
