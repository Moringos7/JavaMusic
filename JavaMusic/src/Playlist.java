import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Playlist<T> implements ListIterator<T>{
	
	protected NodoP first,
				  last;
	protected int size;
	protected int pos;
	protected String titulo;
	protected NodoP currentG;

	public Playlist() {
		super();
		this.pos = 0;
		this.first = this.last = null;
		this.size = 0;
		this.currentG = null;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public void addLast(Cancion cancion){
		NodoP nuevoN = new NodoP(cancion);
		if(this.size == 0) {
			this.first = nuevoN;
			this.last = nuevoN;
			this.currentG = null;
			this.pos = 0;
		}else {
			this.last.setNext(nuevoN);
			nuevoN.setPrevious(this.last);
			this.last = nuevoN;
		}
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
	
	public Playlist<Cancion> getRandom(){
		Playlist<Cancion> newList = new Playlist<Cancion>();
		Cancion[] newArr = new Cancion[this.size];
		//NodoP<Cancion> nodoTemp = this.currentG;
		//this.currentG = this.first;
		int i = 0;
		while(this.hasNext()) {
			Cancion cancion = (Cancion)this.next();
			System.out.println(cancion.getId());
			newArr[i] =  new Cancion(cancion.getId(),
									 cancion.getTitulo(),
									 cancion.getDuracion(),
									 cancion.getImg(),
									 cancion.getArtista());
			i++;
		}
		/*
		for(int j = 0; j < newArr.length;i++) {
			System.out.println(newArr[j].getId());
		}*/
		
		
		
		int j = 9;
		//while(this.size != newArr.length) {
		/*while(j != 0) {
			int x = (int)(Math.floor((Math.random()*(0-j)+j)));
			System.out.println(x);
			
		}*/
		return newList;
	}
	
	
	public static void main (String arg[]) {
		Playlist<Cancion> playlist = new Playlist<Cancion>();
		for (int i = 0; i < 10; i++) {
			Cancion C = new Cancion(""+i);
			playlist.addLast(C);
			//System.out.print((int)(Math.floor((Math.random()*(0-2)+2)))+",");
		}
		playlist.getRandom();
		/*Playlist<Cancion> play =  null;
		try {
			play = new Connection().getCancionesArtista("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			play.next();
			System.out.println(play.previous());
			System.out.println(play.pos);
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
	public boolean hasNext() {
		return pos < size;
	}
	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return pos > 0;
	}
	@Override
	public T next() {
		if(this.hasNext()) {
			if(currentG == null) {
				currentG = first;
			}else {
				currentG = currentG.next;
			}
			pos++;
			return (T)currentG.getCancion();
		}else {
			throw new  IllegalStateException("No más elementosN");
		}
	}
	@Override
	public T previous() {
		if(this.hasPrevious()) {
			currentG = currentG.getPrevious();
			pos--;
			return (T)currentG.getCancion();
		}else {
			throw new IllegalStateException("No más elementosP");
		}
	}
	
	
	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void set(T e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void add(T e) {
		// TODO Auto-generated method stub
		
	}
	
	




	
	
}
