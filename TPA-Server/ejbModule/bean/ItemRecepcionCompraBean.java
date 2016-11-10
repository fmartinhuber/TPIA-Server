package bean;

import javax.persistence.*;

import dto.ItemRecepcionCompraDTO;

@Entity
@Table(name = "ItemRecepcionCompra")
public class ItemRecepcionCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemRecepcionCompra;
	
	@ManyToOne
	@JoinColumn(name = "idArticulo")
	private ArticuloBean articulo;
	
	private Integer cantidad;
	
	
	// Constructores

	public ItemRecepcionCompraBean() {}

	public ItemRecepcionCompraBean(Integer idItemRecepcionCompra, ArticuloBean articulo, Integer cantidad) {
		this.idItemRecepcionCompra = idItemRecepcionCompra;
		this.articulo = articulo;
		this.cantidad = cantidad;
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
	
	// Metodo de transformaciones

	public void aItemRecepcionCompraBean(ItemRecepcionCompraDTO itemRecepcionCompraDTO) {

		this.setCantidad(itemRecepcionCompraDTO.getCantidad());
		
		ArticuloBean articuloBean = new ArticuloBean();
		articuloBean.aArticuloBean(itemRecepcionCompraDTO.getArticulo());
		
	}
	
}