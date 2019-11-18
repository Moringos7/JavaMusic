import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Playlist<NodoP> implements Iterable<NodoP>{
	
	protected NodoP first,
				  last;
	protected int size;

	public Playlist() {
		super();
		this.first = this.last = null;
		this.size = 0;
	}
	public Cancion First() throws NoSuchElementException{
		try {
			return (Cancion) this.first.getCancion();
		}catch ( NullPointerException ex){
			throw new NoSuchElementException("Exception");
		}
	}
	
	public Cancion Last() throws NoSuchElementException {
		return (Cancion) this.last.getCancion();
	}
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	//Añadir en la ultima posición
	public void add(Cancion cancion){
		NodoP nuevoN = new NodoP(cancion);
		if(size == 0) {
			this.first = nuevoN;
		}else {
			this.last.setNext(nuevoN);
			nuevoN.setPrevious(this.last);
		}
		this.last = nuevoN;
		this.size++;
	}
	
	public Cancion getCancion(String Id) {
		NodoP current = this.first;
		while(!((Cancion) current.getCancion()).getId().equals(Id)) {
			current = current.getNext();
			if(current.equals(null)) {
				break;
			}
		}
		return (Cancion) current.getCancion();
	}
	
	public static void main (String arg[]) {
		Playlist myPlaylist = new Playlist();
		for(int i = 0; i<10;i++) {
			myPlaylist.add(new Cancion(""+i));
		}
		System.out.println(myPlaylist.getCancion("3"));
		
	}
	
	
	
	
	class NodoP<Cancion>{
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

	@Override
	public Iterator<NodoP> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<NodoP>();
	}




	
	
}
