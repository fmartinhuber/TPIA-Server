package bean;

import javax.persistence.*;

import dao.*;

@Entity
@Table(name = "ItemSolicitudCompra")
public class ItemSolicitudCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemSolicitudCompra;
	
	@ManyToOne
	@JoinColumn(name = "idArticulo")
	private ArticuloBean articulo;
	
	private Integer cantidad;

	
	
	public ItemSolicitudCompraBean() {
		
	}
		
	public ItemSolicitudCompraBean(Integer idItemSolicitudCompra, ArticuloBean articulo, Integer cantidad) {
		this.idItemSolicitudCompra = idItemSolicitudCompra;
		this.articulo = articulo;
		this.cantidad = cantidad;
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
