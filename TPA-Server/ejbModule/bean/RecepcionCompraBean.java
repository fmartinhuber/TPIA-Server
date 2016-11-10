package bean;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="RecepcionCompra")
public class RecepcionCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idRecepcionCompra;
	
	private Integer codigo;
		
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idRecepcionCompra")
	private List<ItemRecepcionCompraBean> itemsRecepcionesCompra;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idRecepcionCompra")
	private List<SolicitudCompraBean> solicitudesCompra;

	

	public RecepcionCompraBean() {
		
	}
	
	public RecepcionCompraBean(Integer idRecepcionCompra, Integer codigo,
			List<ItemRecepcionCompraBean> itemsRecepcionesCompra, List<SolicitudCompraBean> solicitudesCompra) {
		this.idRecepcionCompra = idRecepcionCompra;
		this.codigo = codigo;
		this.itemsRecepcionesCompra = itemsRecepcionesCompra;
		this.solicitudesCompra = solicitudesCompra;
	}



	public Integer getIdRecepcionCompra() {
		return idRecepcionCompra;
	}

	public void setIdRecepcionCompra(Integer idRecepcionCompra) {
		this.idRecepcionCompra = idRecepcionCompra;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public List<ItemRecepcionCompraBean> getItemsRecepcionesCompra() {
		return itemsRecepcionesCompra;
	}



	public void setItemsRecepcionesCompra(List<ItemRecepcionCompraBean> itemsRecepcionesCompra) {
		this.itemsRecepcionesCompra = itemsRecepcionesCompra;
	}



	public List<SolicitudCompraBean> getSolicitudesCompra() {
		return solicitudesCompra;
	}



	public void setSolicitudesCompra(List<SolicitudCompraBean> solicitudesCompra) {
		this.solicitudesCompra = solicitudesCompra;
	}
	
	
}
