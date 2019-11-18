
public class Artista {
	private String Id,
				   Nombre,
				   Img;
	public Artista(String Id,String Nombre, String Img) {
		this.Id = Id;
		this.Nombre = Nombre;
		this.Img = Img;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}
	
}
