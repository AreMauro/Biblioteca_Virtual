package Servicios;

import ClasesDB.ManejadorArchivo;
import clasesPrincipales.Archivo;

public class ServicioArchivo {
	
	ManejadorArchivo nuevoManejador;

	public ServicioArchivo() {
		
		this.nuevoManejador = new ManejadorArchivo();
	}
	
	public int guardarArchivo(Archivo nuevoArchivo) {
		
		return nuevoManejador.añadirArchivo(nuevoArchivo).getIndice();
	}
	
	public Archivo getArchivo(int clave) {
		
		
		return nuevoManejador.getArchivo(clave);
		
	}
	
	
	public static void main(String[] args) {
		
		ServicioArchivo nuevoServicioArchivo = new ServicioArchivo();
		
		Archivo nuevoArchivo = new Archivo("PDF", 23.23, "WWW.LINK.PRUEBA.COM.mx");
		
		System.out.println(nuevoServicioArchivo.getArchivo(2).getLink());
		
	}
	
	
}
