package bean;

import java.util.*;

import javax.persistence.*;

import dao.*;

@Entity
@Table (name="SolicitudCompra")
public class SolicitudCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSolicitudCompra;
	
	private Integer codigo; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSolicitudesArticulo")
	private List<SolicitudArticuloBean> solicitudesArticulos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSolicitudesCompra")
	private List<ItemSolicitudCompraBean> solicitudesCompra;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idRecepcionesCompra")
	private RecepcionCompraBean recepcionCompra;
	
	private String pendiente;
	
	private Date fechaCreacion;
	
	// Constructor

	public SolicitudCompraBean() {}

	public Integer getIdSolicitudCompra() {
		return idSolicitudCompra;
	}

	public void setIdSolicitudCompra(Integer idSolicitudCompra) {
		this.idSolicitudCompra = idSolicitudCompra;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPendiente() {
		return pendiente;
	}

	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public List<SolicitudArticuloBean> getSolicitudesArticulos() {
		return solicitudesArticulos;
	}

	public void setSolicitudesArticulos(List<SolicitudArticuloBean> solicitudesArticulos) {
		this.solicitudesArticulos = solicitudesArticulos;
	}

	public List<ItemSolicitudCompraBean> getSolicitudesCompra() {
		return solicitudesCompra;
	}

	public void setSolicitudesCompra(List<ItemSolicitudCompraBean> solicitudesCompra) {
		this.solicitudesCompra = solicitudesCompra;
	}

	public RecepcionCompraBean getRecepcionCompra() {
		return recepcionCompra;
	}

	public void setRecepcionCompra(RecepcionCompraBean recepcionCompra) {
		this.recepcionCompra = recepcionCompra;
	}
	
	public void mergeSolicitudCompra() {
		SolicitudCompraDao.getInstancia().merge(this);
	}

	public void persistSolicitudCompra() {
		SolicitudCompraDao.getInstancia().persist(this);
	}

	public void updateSolicitudCompra() {
		SolicitudCompraDao.getInstancia().update(this);
	}

	public void deleteSolicitudCompra() {
		SolicitudCompraDao.getInstancia().delete(this);
	}
		
		
}
