package clasesPrincipales;

import java.lang.reflect.Field;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table()
public class Libro {

	enum formatoArchivo{
		
		Escaneado,
		Digital
	}
	
	
	private String Titulo;
	private String[] Autores; 
	private String Editorial;
	private int NumeroDeEdicion;
	private int AgnoDePublicacion;
	private String FormatoArchivo;
	private String Idioma;
	private String Resegna;
	private boolean esFiccion;
	private String Clasificacion;
	
	public Libro(String titulo, String[] autores, String editorial, 
			int numeroDeEdicion, int agnoDePublicacion,
			String formatoArchivo, String idioma, String resegna, 
			boolean esFiccion, String clasificacion) {
		Titulo = titulo;
		Autores = autores;
		Editorial = editorial;
		NumeroDeEdicion = numeroDeEdicion;
		AgnoDePublicacion = agnoDePublicacion;
		FormatoArchivo = formatoArchivo;
		Idioma = idioma;
		Resegna = resegna;
		this.esFiccion = esFiccion;
		Clasificacion = clasificacion;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String[] getAutores() {
		return Autores;
	}
	public void setAutores(String[] autores) {
		Autores = autores;
	}
	public String getEditorial() {
		return Editorial;
	}
	public void setEditorial(String editorial) {
		Editorial = editorial;
	}
	public int getNumeroDeEdicion() {
		return NumeroDeEdicion;
	}
	public void setNumeroDeEdicion(int numeroDeEdicion) {
		NumeroDeEdicion = numeroDeEdicion;
	}
	public int getAgnoDePublicacion() {
		return AgnoDePublicacion;
	}
	public void setAgnoDePublicacion(int agnoDePublicacion) {
		AgnoDePublicacion = agnoDePublicacion;
	}
	public String getFormatoArchivo() {
		return FormatoArchivo;
	}
	public void setFormatoArchivo(String Formatoarchivo) {
		
		for (formatoArchivo formato : formatoArchivo.values()){
			
			if(formato.toString().equalsIgnoreCase(Formatoarchivo)) {
				
				FormatoArchivo = Formatoarchivo;
				
			}
		}
		
		
	}
	public String getIdioma() {
		return Idioma;
	}
	public void setIdioma(String idioma) {
		Idioma = idioma;
	}
	public String getResegna() {
		return Resegna;
	}
	public void setResegna(String resegna) {
		Resegna = resegna;
	}
	public boolean isEsFiccion() {
		return esFiccion;
	}
	public void setEsFiccion(boolean esFiccion) {
		this.esFiccion = esFiccion;
	}
	public String getClasificacion() {
		return Clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		Clasificacion = clasificacion;
	}
	
	
	@Override
	public String toString() {
		
		Field[] c = this.getClass().getDeclaredFields();
		
		String informacion = "[ " + this.getClass().getName() + ": ";
		
		for(int i =0; i < c.length; i++) {
			
			informacion += c[i].getName();
			
			informacion += ": ";
			
			
			c[i].setAccessible(true);
			try {
				
				
				informacion += c[i].get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			informacion += "; ";
			
		}
		
		
		informacion += "]";
		
		String parte1 = informacion.substring(0, informacion.indexOf("Autores:")
												+ "Autores:".length());
		
		String parte2 = informacion.substring(informacion.indexOf("Editorial:"));
		
		parte1 += "{";
		
		
		for(int j =0; j< this.Autores.length;j++) {
			
			parte1 += this.Autores[j];
			
			parte1 += ", ";
			
		}
		
		parte1 += "}; ";
				
		parte1 += parte2;
		
		return parte1;
	}
	
	
	public static void main(String args[]) {
		
		String [] autores = {"Williams Pacheco", "Mark c. clapton"};
		
		Libro nuevoLibro = new Libro("WARHAMMER 40K", autores,
				"Editorial", 1, 1990, "Digital", "Aleman", "smnsksmakask", false, "Historia");
		
		System.out.println(nuevoLibro);
		
	}
	
	
	
	
	
	
}
