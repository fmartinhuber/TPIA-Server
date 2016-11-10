package bean;

import java.util.*;

import javax.persistence.*;

import dao.*;

@Entity
@Table (name="SolicitudArticulo")
public class SolicitudArticuloBean {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSolicitudArticulo;
	
	private Integer codigo; 
	private String estado; 
	private Date fechaEntrega;
	private Integer idModulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSolicitudArticulo")
	private List<ItemSolicitudArticuloBean> itemsSolicitudArticulo;
	
	

	public SolicitudArticuloBean() {
		
	}
	
	public SolicitudArticuloBean(Integer idSolicitudArticulo, Integer codigo, String estado, Date fechaEntrega,
			Integer idModulo, List<ItemSolicitudArticuloBean> itemsSolicitudArticulo) {
		this.idSolicitudArticulo = idSolicitudArticulo;
		this.codigo = codigo;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
		this.idModulo = idModulo;
		this.itemsSolicitudArticulo = itemsSolicitudArticulo;
	}



	public Integer getIdSolicitudArticulo() {
		return idSolicitudArticulo;
	}

	public void setIdSolicitudArticulo(Integer idSolicitudArticulo) {
		this.idSolicitudArticulo = idSolicitudArticulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public List<ItemSolicitudArticuloBean> getItemsSolicitudArticulo() {
		return itemsSolicitudArticulo;
	}

	public void setItemsSolicitudArticulo(List<ItemSolicitudArticuloBean> itemsSolicitudArticulo) {
		this.itemsSolicitudArticulo = itemsSolicitudArticulo;
	}
	
}
