package bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import dto.ItemRecepcionCompraDTO;
import dto.RecepcionCompraDTO;
import dto.SolicitudCompraDTO;

@Entity
@Table (name="RecepcionCompra")
public class RecepcionCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idRecepcionCompra;
	
	private String codigo;
		
	@OneToMany (cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="idRecepcionCompra")
	private List<ItemRecepcionCompraBean> itemsRecepcionesCompra;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idRecepcionCompra")
	private List<SolicitudCompraBean> solicitudesCompra;

	// Constructores
	
	public RecepcionCompraBean() {}
	
	public RecepcionCompraBean(Integer idRecepcionCompra, String codigo,
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
	
	// Metodos de transformaciones
	
	public void aRecepcionCompraBean(RecepcionCompraDTO recepcionCompraDTO){
		
		this.setCodigo(recepcionCompraDTO.getCodigo());

		List<ItemRecepcionCompraBean> listaRecepcionesCompra = new ArrayList<ItemRecepcionCompraBean>();
		for(int i=0; i<recepcionCompraDTO.getRecepcionesCompra().size(); i++){
			
			ItemRecepcionCompraBean itemRecepcionCompraBean = new ItemRecepcionCompraBean();
			ItemRecepcionCompraDTO itemRecepcionCompraDTO = recepcionCompraDTO.getRecepcionesCompra().get(i);
			itemRecepcionCompraBean.aItemRecepcionCompraBean(itemRecepcionCompraDTO);
			listaRecepcionesCompra.add(itemRecepcionCompraBean);
		}
		this.setItemsRecepcionesCompra(listaRecepcionesCompra);
		
		List<SolicitudCompraBean> listaSolicitudCompraBean = new ArrayList<SolicitudCompraBean>();
		for(int i=0; i<recepcionCompraDTO.getSolicitudesCompra().size(); i++){
			
			SolicitudCompraBean solicitudCompraBean = new SolicitudCompraBean();
			SolicitudCompraDTO solicitudCompraDTO = recepcionCompraDTO.getSolicitudesCompra().get(i);
			solicitudCompraBean.aSolicitudCompraBean(solicitudCompraDTO);
			listaSolicitudCompraBean.add(solicitudCompraBean);
		}
		this.setSolicitudesCompra(listaSolicitudCompraBean);
	}
	
	public RecepcionCompraDTO aRecepcionCompraDTO(){
		
		RecepcionCompraDTO recepcionCompraDTO = new RecepcionCompraDTO();
		
		recepcionCompraDTO.setCodigo(this.getCodigo());
		
		List<SolicitudCompraDTO> listaSolicitudesCompraDTO = new ArrayList<SolicitudCompraDTO>();
		for(int i=0; i<this.getSolicitudesCompra().size(); i++){
			
			SolicitudCompraDTO solicitudCompraDTO = new SolicitudCompraDTO();
			solicitudCompraDTO = this.getSolicitudesCompra().get(i).aSolicitudCompraDTO();
			listaSolicitudesCompraDTO.add(solicitudCompraDTO);
		}
		
		List<ItemRecepcionCompraDTO> listaItemsRecepcionCompraDTO = new ArrayList<ItemRecepcionCompraDTO>();
		for(int i=0; i<this.getItemsRecepcionesCompra().size(); i++){
			
			ItemRecepcionCompraDTO itemRecepcionCompraDTO = new ItemRecepcionCompraDTO();
			itemRecepcionCompraDTO = this.getItemsRecepcionesCompra().get(i).aItemRecepcionCompraDTO();
			listaItemsRecepcionCompraDTO.add(itemRecepcionCompraDTO);
		}
		
		recepcionCompraDTO.setRecepcionesCompra(listaItemsRecepcionCompraDTO);
		recepcionCompraDTO.setSolicitudesCompra(listaSolicitudesCompraDTO);
		return recepcionCompraDTO;
		
	}
	
}
