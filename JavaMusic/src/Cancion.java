import java.util.LinkedList;

public class Cancion {

	private int duracion;
	private String id,
				   titulo,
				   artista,
				   img;
	public Cancion(String id) {
		this.id = id;
	}
	
	public Cancion(String id, int duracion, String  artista, String titulo, String genero, String uRL,String img) {
		super();
		this.id = id;
		this.duracion = duracion;
		this.artista = artista;
		this.titulo = titulo;
		this.img = img;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
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

	@Override
	public String toString() {
		return "Cancion [duracion=" + duracion + ", id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", img="
				+ img + "]";
	}
	
	
}
