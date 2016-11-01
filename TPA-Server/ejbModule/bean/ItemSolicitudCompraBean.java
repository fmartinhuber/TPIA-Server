package bean;

import javax.persistence.*;

import bean.ArticuloBean;

@Entity
@Table(name = "ItemSolicitudCompra")
public class ItemSolicitudCompraBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ItemSolicitudCompra;
	@ManyToOne
	@JoinColumn(name = "idArticulo")
	private ArticuloBean articulo;
	private Integer cantidad;
	
	
	
	public ItemSolicitudCompraBean(ArticuloBean articulo, Integer cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public ItemSolicitudCompraBean() {
		super();
	}

	
	
	public Integer getItemSolicitudCompra() {
		return ItemSolicitudCompra;
	}

	public void setItemSolicitudCompra(Integer itemSolicitudCompra) {
		ItemSolicitudCompra = itemSolicitudCompra;
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
	
}
