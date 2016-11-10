package bean;

import java.util.*;

import javax.persistence.*;

import dto.ItemSolicitudCompraDTO;
import dto.SolicitudArticuloDTO;
import dto.SolicitudCompraDTO;

@Entity
@Table (name="SolicitudCompra")
public class SolicitudCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSolicitudCompra;
	
	private Integer codigo; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSolicitudesCompra")
	private List<ItemSolicitudCompraBean> itemsSolicitudesCompra;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSolicitudesCompra")
	private List<SolicitudArticuloBean> solicitudesArticulos;
	
	private String pendiente;
	
	private Date fechaCreacion;
	
	

	public SolicitudCompraBean() {
		
	}	
	
	public SolicitudCompraBean(Integer idSolicitudCompra, Integer codigo,
			List<ItemSolicitudCompraBean> itemsSolicitudesCompra, List<SolicitudArticuloBean> solicitudesArticulos,
			String pendiente, Date fechaCreacion) {
		this.idSolicitudCompra = idSolicitudCompra;
		this.codigo = codigo;
		this.itemsSolicitudesCompra = itemsSolicitudesCompra;
		this.solicitudesArticulos = solicitudesArticulos;
		this.pendiente = pendiente;
		this.fechaCreacion = fechaCreacion;
	}



	public Integer getIdSolicitudCompra() {
		return idSolicitudCompra;
	}

	public void setIdSolicitudCompra(Integer idSolicitudCompra) {
		this.idSolicitudCompra = idSolicitudCompra;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPendiente() {
		return pendiente;
	}

	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public List<SolicitudArticuloBean> getSolicitudesArticulos() {
		return solicitudesArticulos;
	}

	public void setSolicitudesArticulos(List<SolicitudArticuloBean> solicitudesArticulos) {
		this.solicitudesArticulos = solicitudesArticulos;
	}

	public List<ItemSolicitudCompraBean> getItemsSolicitudesCompra() {
		return itemsSolicitudesCompra;
	}

	public void setItemsSolicitudesCompra(List<ItemSolicitudCompraBean> solicitudesCompra) {
		this.itemsSolicitudesCompra = solicitudesCompra;
	}

//	public RecepcionCompraBean getRecepcionCompra() {
//		return recepcionCompra;
//	}
//
//	public void setRecepcionCompra(RecepcionCompraBean recepcionCompra) {
//		this.recepcionCompra = recepcionCompra;
//	}
	
	// M�todos de transformaciones
	
	public void aSolicitudCompraBean(SolicitudCompraDTO solicitudCompraDTO){
		
		this.setCodigo(solicitudCompraDTO.getCodigo());
		this.setFechaCreacion(solicitudCompraDTO.getFechaCreacion());
		this.setPendiente(solicitudCompraDTO.getPendiente());

		List<ItemSolicitudCompraBean> listaItemsSolicitudesCompra = new ArrayList<ItemSolicitudCompraBean>();
		for(int i=0; i<solicitudCompraDTO.getItemsSolicitudesCompra().size(); i++){
			
			ItemSolicitudCompraBean itemSolicitudCompraBean = new ItemSolicitudCompraBean();
			ItemSolicitudCompraDTO itemSolicitudCompraDTO = solicitudCompraDTO.getItemsSolicitudesCompra().get(i);
			itemSolicitudCompraBean.aItemSolicitudCompraBean(itemSolicitudCompraDTO);
			listaItemsSolicitudesCompra.add(itemSolicitudCompraBean);
		}
		this.setItemsSolicitudesCompra(listaItemsSolicitudesCompra);
		
		List<SolicitudArticuloBean> listaSolicitudesArticulo = new ArrayList<SolicitudArticuloBean>();
		for(int i=0; i<solicitudCompraDTO.getSolicitudesArticulos().size(); i++){
			
			SolicitudArticuloBean solicitudArticuloBean = new SolicitudArticuloBean();
			SolicitudArticuloDTO solicitudArticuloDTO = solicitudCompraDTO.getSolicitudesArticulos().get(i);
			solicitudArticuloBean.aSolicitudArticuloBean(solicitudArticuloDTO);
			listaSolicitudesArticulo.add(solicitudArticuloBean);
		}
		this.setSolicitudesArticulos(listaSolicitudesArticulo);
		
	}
	
}
