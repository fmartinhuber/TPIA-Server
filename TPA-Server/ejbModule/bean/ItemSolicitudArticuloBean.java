package bean;

import javax.persistence.*;

import dto.ArticuloDTO;
import dto.ItemSolicitudArticuloDTO;

//Daro: Este Bean relaciona el articulo con la cantidad solicitada

@Entity
@Table (name="ItemSolicitudArticulo")
public class ItemSolicitudArticuloBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemSolicitudArticulo;
	
	@ManyToOne
	@JoinColumn(name="idArticulo")
	private ArticuloBean articulo;
	
	private Integer cantidad;
	
	
		


	public ItemSolicitudArticuloBean() {

	}
	
	public ItemSolicitudArticuloBean(ArticuloBean articulo, Integer cantidad) {
		this.articulo = articulo;
		this.cantidad = cantidad;
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

	// Metodo de transformaciones
	
	public void aItemSolicitudArticuloBean(ItemSolicitudArticuloDTO itemSolicitudArticuloDTO) {

		this.setCantidad(itemSolicitudArticuloDTO.getCantidad());
		
		ArticuloBean articuloBean = new ArticuloBean();
		articuloBean.aArticuloBean(itemSolicitudArticuloDTO.getArticulo());
		this.setArticulo(articuloBean);
	}

	public ItemSolicitudArticuloDTO aItemSolicitudArticuloDTO() {

		ItemSolicitudArticuloDTO itemSolicitudArticuloDTO = new ItemSolicitudArticuloDTO();
		
		itemSolicitudArticuloDTO.setCantidad(this.getCantidad());
		
		ArticuloDTO articuloDTO = new ArticuloDTO();
		articuloDTO = this.getArticulo().aArticuloDTO();
		itemSolicitudArticuloDTO.setArticulo(articuloDTO);
		
		return itemSolicitudArticuloDTO;
	}


}
