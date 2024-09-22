package ClasesDB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesPrincipales.Archivo;

public class ManejadorArchivo implements ArchivoJPA {
	
	SessionFactory nuevaFabrica;
	
	public ManejadorArchivo() {
		
		nuevaFabrica = BaseDB.getInstance().getSession();
		
	}

	@Override
	public boolean eliminarArchivo(Archivo objeto) {
		// TODO Auto-generated method stub
		
		Session nuevaConexion = nuevaFabrica.openSession();
		
		try {
			
			
			
		}catch (Exception e){
			
			
			
		}
		
		
		return false;
	}

	@Override
	public Archivo añadirArchivo(Archivo objeto) {
		// TODO Auto-generated method stub
		Session nuevaConexion = nuevaFabrica.openSession();
		
		try {
			
			nuevaConexion.beginTransaction();
			
			nuevaConexion.save(objeto);
			
			nuevaConexion.getTransaction().commit();
			
			nuevaConexion.close();
			
			return objeto;
			
		}catch(Exception e) {
			
			
			System.out.println(e);
			
			return null;
		}
			}

	@Override
	public boolean modificarArchivo(Archivo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Archivo getArchivo(Integer Indice) {
		// TODO Auto-generated method stub
		
		Session nuevaSesion = nuevaFabrica.openSession();
		
		try {
			
			Archivo archivoActual = (Archivo) nuevaSesion.get(Archivo.class.getName(),Indice);
			
			return archivoActual;
			
		}catch(Exception e) {
			
			System.out.println(e);
			
			return null;
			
		}
	
		
		
	}
	
	
	
	
	
	
}
