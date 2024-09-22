package ClasesDB;

public interface metodosGenerales <E, D> {
	
	public boolean eliminarArchivo(E objeto);
	
	public E añadirArchivo(E objeto);
	
	public boolean modificarArchivo(E objeto);
	
	public E getArchivo(D primaryKey);
	
}
