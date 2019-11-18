import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Playlist<T> implements Iterable<T>{
	
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
		
		/*Iterator<Cancion> song = myPlaylist.iterator();
		while(song.hasNext()) {
			System.out.println(song.next());
		}*/
	}
	
	public class NodoP<Cancion>{
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
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			int pos = 0;
			NodoP current = first;
			@Override
			public boolean hasNext() {
				return pos<size;
			}

			@Override
			public T next() {
				if(this.hasNext()) {
					NodoP temp = current;
					current = current.next;
					pos++;
					return (T)temp.getCancion();
				}else {
					throw new  IllegalStateException("No más elementos");
				}
			}			
		};
	}




	
	
}
