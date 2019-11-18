
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException; 
import java.net.URL;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Connection {

	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String GET_URL = "http://localhost/JavaMusic/";

	
	public static void main(String[] args) throws MalformedURLException{ 
		Connection conect = new Connection();
		/*LinkedList<Artista>Artistas = null;
		try {
			Artistas = conect.getArtistas();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			for(Artista artista : Artistas) {
				System.out.println(artista);
			}
		}*/
		
		/*LinkedList<Album>Albumes = null;
		try {
			Albumes = conect.getAlbumes();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			for(Album album : Albumes) {
				System.out.println(album);
			}
		}*/
		
		
		LinkedList<Genero>Generos = null;
		try {
			Generos = conect.getGeneros();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			for(Genero genero : Generos) {
				System.out.println(genero);
			}
		}
		
	}
	
	//Obtiene Los Artistas de la Base de Datos
	public LinkedList<Artista> getArtistas() throws IOException{
		LinkedList<Artista> Artistas = new LinkedList<Artista>();
		URL obj = new URL(GET_URL + "Artistas.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;	
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(inputLine,"|");
				Artistas.add(new Artista(tokens.nextToken(),tokens.nextToken(),tokens.nextToken()));
			}
			in.close();
		}
		return Artistas;
	}
	
	//Obtiene Los Albumes de la Base de Datos
	public LinkedList<Album> getAlbumes() throws IOException{
		LinkedList<Album> Albumes = new LinkedList<Album>();
		URL obj = new URL(GET_URL + "Albumes.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;	
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(inputLine,"|");
				Albumes.add(new Album(tokens.nextToken(),tokens.nextToken(),tokens.nextToken(),tokens.nextToken()));
			}
			in.close();
		}
		return Albumes;
	}
	
	//Obtiene Los Generos de la Base de Datos
	public LinkedList<Genero> getGeneros() throws IOException{
		LinkedList<Genero> Generos = new LinkedList<Genero>();
		URL obj = new URL(GET_URL + "Generos.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { 
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;	
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(inputLine,"|");
				Generos.add(new Genero(tokens.nextToken(),tokens.nextToken(),tokens.nextToken()));
			}
			in.close();
		}
		return Generos;
	}
	
	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL + "Artistas.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;	
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine + "\n");
				//Creacion de objeto
			}
			in.close();
		} else {
			
		}
	}
}
