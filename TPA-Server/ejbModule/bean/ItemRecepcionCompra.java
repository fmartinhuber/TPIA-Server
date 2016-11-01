package bean;

import javax.persistence.*;

import bean.ArticuloBean;

@Entity
@Table(name = "ItemRecepcionCompra")
public class ItemRecepcionCompra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemRecepcionCompra;
	@ManyToOne
	@JoinColumn(name = "idArticulo")
	private ArticuloBean articulo;
	private Integer cantidad;
	
	public ItemRecepcionCompra(ArticuloBean articulo, Integer cantidad) {
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public ItemRecepcionCompra() {
		
	}

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
	
}