package bean;

import javax.persistence.*;

@Entity
@Table(name = "ItemRecepcionCompra")
public class ItemRecepcionCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemRecepcionCompra;
	
	@OneToOne
	@JoinColumn(name = "idArticulo")
	private ArticuloBean articulo;
	
//	@ManyToOne (cascade=CascadeType.ALL)
//	@JoinColumn(name="idRecepcionCompra")
//	private RecepcionCompraBean recepcionCompra;
	
	private Integer cantidad;
	
	
	

	public ItemRecepcionCompraBean() {}

	
	
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