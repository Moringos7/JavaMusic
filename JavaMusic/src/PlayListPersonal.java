

public class PlayListPersonal extends Playlist{
	
	public void addAt(Cancion cancion,int pos) throws IndexOutOfBoundsException {
		if(pos < 0 || pos >= this.size) {
			throw new IndexOutOfBoundsException("No se puede colocar un valor en la posición "+pos+"en una lista de tamaño "+ this.size);
		}else {
			NodoP current = this.first,
				  temp = null,
				  nuevoN = new NodoP(cancion);
			for(int i = 0; i < pos;i++) {
				temp = current;
				current = current.getNext();
				
			}
			
			current.setPrevious(nuevoN);
			nuevoN.setPrevious(this.last);
			this.last = nuevoN;
			
		}
	}
}
