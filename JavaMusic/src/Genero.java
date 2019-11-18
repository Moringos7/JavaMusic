
public class Genero {
	private String Id,
				   Nombre,
				   Img;

	public Genero(String id, String nombre, String img) {
		Id = id;
		Nombre = nombre;
		Img = img;
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

	@Override
	public String toString() {
		return "Genero [Id=" + Id + ", Nombre=" + Nombre + ", Img=" + Img + "]";
	}
	
}
