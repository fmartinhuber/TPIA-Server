package bean;

import javax.persistence.*;

import dao.*;


@Entity
@Table(name = "ItemRecepcionCompra")
public class ItemRecepcionCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemRecepcionCompra;
	
	@ManyToOne
	@JoinColumn(name = "idArticulo")
	private ArticuloBean articulo;
	
//	@ManyToOne (cascade=CascadeType.ALL)
//	@JoinColumn(name="idRecepcionCompra")
//	private RecepcionCompraBean recepcionCompra;
	
	private Integer cantidad;
	
	// Constructor

	public ItemRecepcionCompra() {}

	public Integer getIdItemRecepcionCompra() {
		return idItemRecepcionCompra;
	}

	public void setIdItemRecepcionCompra(Integer idItemRecepcionCompra) {
		this.idItemRecepcionCompra = idItemRecepcionCompra;
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
	
	public void mergeItemRecepcionCompra() {
		ItemRecepcionCompraDao.getInstancia().merge(this);
	}

	public void persistItemRecepcionCompra() {
		ItemRecepcionCompraDao.getInstancia().persist(this);
	}

	public void updateItemRecepcionCompra() {
		ItemRecepcionCompraDao.getInstancia().update(this);
	}

	public void deleteItemRecepcionCompra() {
		ItemRecepcionCompraDao.getInstancia().delete(this);
	}
	
}