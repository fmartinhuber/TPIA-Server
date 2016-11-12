package bean;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import dto.ItemSolicitudArticuloDTO;
import dto.SolicitudArticuloDTO;

@Entity
@Table (name="SolicitudArticulo")
public class SolicitudArticuloBean {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSolicitudArticulo;
	
	private String codigo; 
	private String estado;	//Pendiente o Entregada
	private Date fechaEntrega;
	private String idDespacho;
	
	@OneToMany (cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="idSolicitudArticulo")
	private List<ItemSolicitudArticuloBean> itemsSolicitudArticulo;
	
	// Constructores

	public SolicitudArticuloBean() {}
	
	public SolicitudArticuloBean(String codigo, String estado, Date fechaEntrega,
			String idDespacho, List<ItemSolicitudArticuloBean> itemsSolicitudArticulo) {		
		this.codigo = codigo;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
		this.idDespacho = idDespacho;
		this.itemsSolicitudArticulo = itemsSolicitudArticulo;
	}



	public Integer getIdSolicitudArticulo() {
		return idSolicitudArticulo;
	}

	public void setIdSolicitudArticulo(Integer idSolicitudArticulo) {
		this.idSolicitudArticulo = idSolicitudArticulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getIdDespacho() {
		return idDespacho;
	}

	public void setIdDespacho(String idDespacho) {
		this.idDespacho = idDespacho;
	}

	public List<ItemSolicitudArticuloBean> getItemsSolicitudArticulo() {
		return itemsSolicitudArticulo;
	}

	public void setItemsSolicitudArticulo(List<ItemSolicitudArticuloBean> itemsSolicitudArticulo) {
		this.itemsSolicitudArticulo = itemsSolicitudArticulo;
	}
	
	// Metodo de transformaciones

	public void aSolicitudArticuloBean(SolicitudArticuloDTO solicitudArticuloDTO) {

		this.setCodigo(solicitudArticuloDTO.getCodigo());
		this.setEstado(solicitudArticuloDTO.getEstado());
		this.setFechaEntrega(solicitudArticuloDTO.getFechaEntrega());
		this.setIdDespacho(solicitudArticuloDTO.getIdDespacho());

		List<ItemSolicitudArticuloBean> listaSolicitudesArticulo = new ArrayList<ItemSolicitudArticuloBean>();
		for(int i=0; i<solicitudArticuloDTO.getItemsSolicitudArticulo().size(); i++){
			
			ItemSolicitudArticuloBean itemSolicitudArticuloBean = new ItemSolicitudArticuloBean();
			ItemSolicitudArticuloDTO itemSolicitudArticuloDTO = solicitudArticuloDTO.getItemsSolicitudArticulo().get(i);
			itemSolicitudArticuloBean.aItemSolicitudArticuloBean(itemSolicitudArticuloDTO);
			listaSolicitudesArticulo.add(itemSolicitudArticuloBean);
		}
		this.setItemsSolicitudArticulo(listaSolicitudesArticulo);
	}
	
	public SolicitudArticuloDTO aSolicitudArticuloDTO(){
		
		SolicitudArticuloDTO solicitudArticuloDTO = new SolicitudArticuloDTO();
		
		solicitudArticuloDTO.setCodigo(this.getCodigo());
		solicitudArticuloDTO.setEstado(this.getEstado());
		solicitudArticuloDTO.setFechaEntrega(this.getFechaEntrega());
		solicitudArticuloDTO.setIdModulo(this.getIdDespacho());
		
		List<ItemSolicitudArticuloDTO> listaItemsSolicitudArticulo = new ArrayList<ItemSolicitudArticuloDTO>();
		for(int i=0; i<this.getItemsSolicitudArticulo().size(); i++){
			
			ItemSolicitudArticuloDTO itemSolicitudArticuloDTO = new ItemSolicitudArticuloDTO();
			itemSolicitudArticuloDTO = this.getItemsSolicitudArticulo().get(i).aItemSolicitudArticuloDTO();
			listaItemsSolicitudArticulo.add(itemSolicitudArticuloDTO);
		}
		solicitudArticuloDTO.setItemsSolicitudArticulo(listaItemsSolicitudArticulo);
		
		return solicitudArticuloDTO;
		
	}
	
}
