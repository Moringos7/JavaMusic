import java.util.LinkedList;

public class Cancion {
<<<<<<< HEAD
	private String titulo,
			       id,
			       genero,
			       URL;
	private Artista artista;
	private int duracion;

	public Cancion() {
	}
=======
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
	
	public Cancion(int id, int duracion, LinkedList<String> artista, String titulo, String genero, String uRL,String img) {
		super();
		this.id = id;
		this.duracion = duracion;
		this.artista = artista;
		this.titulo = titulo;
		this.genero = genero;
		URL = uRL;
		this.img = img;
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
	
>>>>>>> c1c6ab7b859303baba5158243bd72f63643a60ad
}
