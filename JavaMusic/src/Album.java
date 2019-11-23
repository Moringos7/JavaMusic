
public class Album {
	private String Id,
				   Titulo,
				   Artista,
				   Img;
	
	public Album(String id, String titulo, String Artista, String img) {
		this.Id = id;
		this.Titulo = titulo;
		this.Artista = Artista;
		this.Img = img;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getNombreArtista() {
		return Artista;
	}

	public void setNombreArtista(String nombreArtista) {
		Artista = nombreArtista;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}
	
	@Override
	public String toString() {
		return "Album [Id=" + Id + ", Titulo=" + Titulo + ", Artista=" + Artista + ", Img=" + Img + "]";
	}
}
