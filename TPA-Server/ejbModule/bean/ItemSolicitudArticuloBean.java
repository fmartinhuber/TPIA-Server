package bean;

import javax.persistence.*;

import dao.*;

//Daro: Este Bean relaciona el articulo con la cantidad solicitada

@Entity
@Table (name="ItemSolicitudArticulo")
public class ItemSolicitudArticuloBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemSolicitudArticulo;
	
	@OneToOne
	@JoinColumn(name="idArticulo")
	private ArticuloBean articulo;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="idSolicitudArticulo")
	private SolicitudArticuloBean solicitud;
	
	private Integer cantidad;
	
	

		
	public ItemSolicitudArticuloBean(ArticuloBean articulo, Integer cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public ItemSolicitudArticuloBean() {
		super();
	}
	
	
	
	public Integer getIdItemSolicitudArticulo() {
		return idItemSolicitudArticulo;
	}

	public void setIdItemSolicitudArticulo(Integer idItemSolicitadoArticulo) {
		this.idItemSolicitudArticulo = idItemSolicitadoArticulo;
	}

	public ArticuloBean getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloBean articulo) {
		this.articulo = articulo;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public SolicitudArticuloBean getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudArticuloBean solicitud) {
		this.solicitud = solicitud;
	}
}
