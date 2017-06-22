package proyecto.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.model.UploadedFile;


@Entity
@Table(name="tb_publicacion")
public class Publicacion{

	
	@Id
	@GeneratedValue
	private Long idpub;
	private String dirpub;
	private String titpub;
	private String contpub;
	@Temporal(TemporalType.DATE)
	private Date fechpub;
	private String estpub;
	private Long puntpub;
	
	@Lob
	private byte[] img;
	
	//mas prueba
	/*private UploadedFile imagensubida;

	
	public UploadedFile getImagensubida() {
		return imagensubida;
	}
	public void setImagensubida(UploadedFile imagensubida) {
		this.imagensubida = imagensubida;
	}*/
	
	

	//fks
	//private Seccion idsec = new Seccion();
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}

	//private Usuario idusu = new Usuario();
	
	/*@OneToMany
	@JoinColumn(name="idcom")
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	*/
	
	public Long getIdpub() {
		return idpub;
	}
	public void setIdpub(Long idpub) {
		this.idpub = idpub;
	}
	public String getDirpub() {
		return dirpub;
	}
	public void setDirpub(String dirpub) {
		this.dirpub = dirpub;
	}
	public String getTitpub() {
		return titpub;
	}
	public void setTitpub(String titpub) {
		this.titpub = titpub;
	}
	public String getContpub() {
		return contpub;
	}
	public void setContpub(String contpub) {
		this.contpub = contpub;
	}
	public Date getFechpub() {
		return fechpub;
	}
	public void setFechpub(Date fechpub) {
		this.fechpub = fechpub;
	}
	public String getEstpub() {
		return estpub;
	}
	public void setEstpub(String estpub) {
		this.estpub = estpub;
	}
	/*public Seccion getIdsec() {
		return idsec;
	}
	public void setIdsec(Seccion idsec) {
		this.idsec = idsec;
	}
	public Usuario getIdusu() {
		return idusu;
	}
	public void setIdusu(Usuario idusu) {
		this.idusu = idusu;
	}*/
	public Long getPuntpub() {
		return puntpub;
	}
	public void setPuntpub(Long puntpub) {
		this.puntpub = puntpub;
	}
/*	public List<Comentario> getComments() {
		return comentarios;
	}
	public void setComments(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
*/



	
	

}
