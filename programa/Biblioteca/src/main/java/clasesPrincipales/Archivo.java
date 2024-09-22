package clasesPrincipales;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "biblioteca.archivo")
public class Archivo {
	
	enum extensiones{
		
		EPUB,
		PDF,
		MOBI,
		EPUB2,
		DOC,
		TXT,
		AZW,
		FB2,
		CBR,
		LIT,
		DJVU,
		IBOOKS,
		RTF
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id" )
	private int indice;
	
	@Column(name = "extension_archivo")
	private String extension_del_archivo;
	
	@Column(name = "tamano_archivo")
	private Double tamagno_del_archivo; //EN MEGABYTES	
	
	@Column(name = "link")
	private String Link;
	
	public Archivo(String extension_del_archivo, Double tamagno_del_archivo, String link) {
		
		for(extensiones extension : extensiones.values()) {
			
			if(Objects.equals(extension.toString().toLowerCase(), extension_del_archivo.toLowerCase())) {
				this.extension_del_archivo = extension_del_archivo;
			}
		}
		
		if(this.extension_del_archivo == null) {
			
			throw new IllegalArgumentException("La extension del archivo no es valida");
		}
		
		
		
		this.tamagno_del_archivo = tamagno_del_archivo;
		Link = link;
	}

	
	public Archivo() {
		
		
	}
	
	public int getIndice() {
		return indice;
	}


	public void setIndice(int indice) {
		this.indice = indice;
	}


	public String getExtension_del_archivo() {
		return extension_del_archivo;
	}

	public void setExtension_del_archivo(String extension_del_archivo) {
		
		for(extensiones extension : extensiones.values()) {
			
			if(Objects.equals(extension.toString(), extension_del_archivo)) {
				this.extension_del_archivo = extension_del_archivo;
			}
		}
		
		if(this.extension_del_archivo == null) {
			
			throw new IllegalArgumentException("La extension del archivo no es valida");
		}
		
		}


	public Double getTamagno_del_archivo() {
		return tamagno_del_archivo;
	}

	public void setTamagno_del_archivo(Double tamagno_del_archivo) {
		this.tamagno_del_archivo = tamagno_del_archivo;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

	@Override
	public String toString() {
		return "Archivo [extension_del_archivo=" + extension_del_archivo + ", tamagno_del_archivo="
				+ tamagno_del_archivo + ", Link=" + Link + "]";
	}
	
	public static void main(String[] args) {
		
		Archivo nuevoArchivo = new Archivo("epub", 22.3, "www.algo.example.com.mx");
		
		System.out.println(nuevoArchivo);
		
	}
	
	
}
