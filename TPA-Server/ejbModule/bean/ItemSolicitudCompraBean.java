package bean;

import javax.persistence.*;

import dao.*;

@Entity
@Table(name = "ItemSolicitudCompra")
public class ItemSolicitudCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemSolicitudCompra;
	
	@OneToOne
	@JoinColumn(name = "idArticulo")
	private ArticuloBean articulo;

//	@ManyToOne (cascade=CascadeType.ALL)
//	@JoinColumn(name="idSolicitudCompra")
//	private SolicitudCompraBean solicitudCompra;
	
	private Integer cantidad;

	
	
	public ItemSolicitudCompraBean() {}

	
	
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
