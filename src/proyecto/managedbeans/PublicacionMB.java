package proyecto.managedbeans;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import proyecto.beans.Publicacion;
import proyecto.beans.Usuario;
import proyecto.servicios.PublicacionService;



@ManagedBean
@SessionScoped
public class PublicacionMB {
	

	private Publicacion publicacion = new Publicacion();
	
	List<Publicacion> publicaciones = new ArrayList<Publicacion>();

	
	@ManagedProperty(value = "#{publicacionService}")
	private PublicacionService publicacionService;
	
	
	private UploadedFile file;
	
	//prueba
	
	
	

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public PublicacionService getPublicacionService() {
		return publicacionService;
	}

	public void setPublicacionService(PublicacionService publicacionService) {
		this.publicacionService = publicacionService;
	}

	
	//prueba imagen
	
	
	

public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

//public String guardar(){
//
//	try{
//		
//	if(imagensubida != null){
//	Date date = new Date();
//	publicacion.setDirpub("a");
//	publicacion.setTitpub("lol");
//	publicacion.setContpub("xd");
//	publicacion.setFechpub(date);
//	publicacion.setEstpub("ya");
//	publicacion.setPuntpub(1L);
//	/*publicacion.setIdsec(null);
//	publicacion.setIdpub(null);*/
//	publicacion.setImg(imagensubida.getContents());
//
//	
//	
//	
//	
//	publicacionService.getPublicacionRepository().save(publicacion);
//	
//	FacesMessage message = new FacesMessage("Exito" + imagensubida.getFileName() + " fue subido");
//	FacesContext.getCurrentInstance().addMessage(null, message);		
//	return "login";
//	
//	}
//	}catch(Exception e){
//		FacesMessage message = new FacesMessage("Error de conexion");
//		FacesContext.getCurrentInstance().addMessage(null, message);		
//		return null;
//		
//	}
//	return null;
//
//
//	
//}


public void handleFileUpload(FileUploadEvent event)throws IOException{
	  //get uploaded file from the event
	   file = event.getFile();
	  //create an InputStream from the uploaded file
	  InputStream inputStr = null;
	  try 
	 {
	    inputStr = file.getInputstream();
	    } catch (IOException e) {
	        //log error
	    }

	  ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    String directory = externalContext.getInitParameter("upload");
	    String filename = FilenameUtils.getName(file.getFileName());
	    File destFile = new File(directory, filename);

	//use org.apache.commons.io.FileUtils to copy the File
	    try {
	        FileUtils.copyInputStreamToFile(inputStr, destFile); 
	    } catch (IOException e) {
	        //log error
	    }
	    FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
	}


	


	
}
