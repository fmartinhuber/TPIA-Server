package bean;

import java.util.*;

import javax.persistence.*;

import dao.*;

@Entity
@Table (name="SolicitudArticulo")
public class SolicitudArticuloBean {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSolicitudArticulo;
	
	private Integer codigo; 
	private String estado; 
	private Date fechaEntrega;
	private Integer idModulo;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<ItemSolicitadoArticuloBean> itemsSolicitudArticulo;
	
	// Constructor

	public SolicitudArticuloBean() {}

	public Integer getIdSolicitudArticulo() {
		return idSolicitudArticulo;
	}

	public void setIdSolicitudArticulo(Integer idSolicitudArticulo) {
		this.idSolicitudArticulo = idSolicitudArticulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}
	
	public void mergeSolicitudArticulo() {
		SolicitudArticuloDao.getInstancia().merge(this);
	}

	public void persistSolicitudArticulo() {
		SolicitudArticuloDao.getInstancia().persist(this);
	}

	public void updateSolicitudArticulo() {
		SolicitudArticuloDao.getInstancia().update(this);
	}

	public void deleteSolicitudArticulo() {
		SolicitudArticuloDao.getInstancia().delete(this);
	}
		
}
