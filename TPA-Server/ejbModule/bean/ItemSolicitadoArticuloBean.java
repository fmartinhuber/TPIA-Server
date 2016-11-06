package bean;

import javax.persistence.*;

import dao.*;

//Daro: Este Bean relaciona el articulo con la cantidad solicitada

@Entity
@Table (name="ItemSolicitadoArticulo")
public class ItemSolicitadoArticuloBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemSolicitadoArticulo;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="idArticulo")
	private ArticuloBean articulo;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="idSolicitudArticulo")
	private SolicitudArticuloBean solicitudArticulo;
	
	private Integer cantidad;
		
	// Constructor
	
	public ItemSolicitadoArticuloBean(ArticuloBean articulo, SolicitudArticuloBean solicitudArticulo, Integer cantidad) {
		super();
		this.articulo = articulo;
		this.solicitudArticulo = solicitudArticulo;
		this.cantidad = cantidad;
	}

	public ItemSolicitadoArticuloBean() {
		super();
	}
	
	public Integer getIdItemSolicitadoArticulo() {
		return idItemSolicitadoArticulo;
	}

	public void setIdItemSolicitadoArticulo(Integer idItemSolicitadoArticulo) {
		this.idItemSolicitadoArticulo = idItemSolicitadoArticulo;
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
	
	public void mergeItemSolicitadoArticulo() {
		ItemSolicitadoArticuloDao.getInstancia().merge(this);
	}

	public void persistItemSolicitadoArticulo() {
		ItemSolicitadoArticuloDao.getInstancia().persist(this);
	}

	public void updateItemSolicitadoArticulo() {
		ItemSolicitadoArticuloDao.getInstancia().update(this);
	}

	public void deleteItemSolicitadoArticulo() {
		ItemSolicitadoArticuloDao.getInstancia().delete(this);
	}
	
}
