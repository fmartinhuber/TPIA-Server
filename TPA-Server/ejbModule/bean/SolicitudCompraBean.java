package bean;

import java.util.*;

import javax.persistence.*;

@Entity
@Table (name="SolicitudCompra")
public class SolicitudCompraBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSolicitudCompra;
	private String codigo; //Este atributo identifica univocamente al objeto, el id lo manejamos para nuestra base
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idSolicitudArticulo")
	private List<SolicitudArticuloBean> solicitudesArticulos;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="ItemSolicitudCompra")
	private List<ItemSolicitudCompraBean> solicitudesCompra;
	private Boolean pendiente; // (Recien enviada a fabrica = FALSE - Devuelta por fabrica = TRUE)
	
	
	
	public SolicitudCompraBean(String codigo, List<SolicitudArticuloBean> solicitudesArticulos,
			List<ItemSolicitudCompraBean> solicitudesCompra, Boolean pendiente) {
		super();
		this.codigo = codigo;
		this.solicitudesArticulos = solicitudesArticulos;
		this.solicitudesCompra = solicitudesCompra;
		this.pendiente = pendiente;
	}

	public SolicitudCompraBean() {
		super();
	}

	
	
	public Integer getIdSolicitudCompra() {
		return idSolicitudCompra;
	}

	public void setIdSolicitudCompra(Integer idSolicitudCompra) {
		this.idSolicitudCompra = idSolicitudCompra;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Boolean getPendiente() {
		return pendiente;
	}

	public void setPendiente(Boolean pendiente) {
		this.pendiente = pendiente;
	}
	
}
