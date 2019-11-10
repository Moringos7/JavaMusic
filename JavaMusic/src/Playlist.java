import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Playlist {
	
	private NodoP first,
				  last;
	private int size;

	public Playlist() {
		super();
		this.first = this.last = null;
		this.size = 0;
	}
	public Cancion First() throws NoSuchElementException{
		try {
			return this.first.getCancion();
		}catch ( NullPointerException ex){
			throw new NoSuchElementException("Exception");
		}
	}
	
	public Cancion Last() throws NoSuchElementException {
		return this.last.getCancion();
	}
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void addLast(Cancion cancion){
		NodoP nuevoN = new NodoP(cancion);
		this.last.setNext(nuevoN);
		nuevoN.setPrevious(this.last);
		this.last = nuevoN;
		this.size++;
	}
	
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
	
	
	public static void main (String arg[]) {
		
	}
	
	class NodoP{
		Cancion cancion;
		NodoP next,
			  previous;
			  
		public NodoP(Cancion cancion,NodoP previous, NodoP next) {
			super();
			this.cancion = cancion;
			this.next = next;
			this.previous = previous;
		}
		public NodoP(Cancion cancion) {
			this(cancion,null,null);
		}
		
		public Cancion getCancion() {
			return cancion;
		}
		public void setCancion(Cancion cancion) {
			this.cancion = cancion;
		}
		public NodoP getNext() {
			return next;
		}
		public void setNext(NodoP next) {
			this.next = next;
		}
		public NodoP getPrevious() {
			return previous;
		}
		public void setPrevious(NodoP previous) {
			this.previous = previous;
		}
		
		
	}
	
}
