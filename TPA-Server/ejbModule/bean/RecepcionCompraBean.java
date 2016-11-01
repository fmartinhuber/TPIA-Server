package bean;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="RecepcionCompra")
public class RecepcionCompraBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idRecepcionCompra;
	private String codigo; //Este atributo identifica univocamente al objeto, el id lo manejamos para nuestra base
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="idSolicitudCompra")
	private SolicitudCompraBean solicitudCompra;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idItemRecepcionCompra")
	private List<ItemRecepcionCompra> recepcionesCompra;
	
	
	
	public RecepcionCompraBean(String codigo, SolicitudCompraBean solicitudCompra,
			List<ItemRecepcionCompra> recepcionesCompra) {
		super();
		this.codigo = codigo;
		this.solicitudCompra = solicitudCompra;
		this.recepcionesCompra = recepcionesCompra;
	}

	public RecepcionCompraBean() {
		super();
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

	public SolicitudCompraBean getSolicitudCompra() {
		return solicitudCompra;
	}

	public void setSolicitudCompra(SolicitudCompraBean solicitudCompra) {
		this.solicitudCompra = solicitudCompra;
	}

	public List<ItemRecepcionCompra> getRecepcionesCompra() {
		return recepcionesCompra;
	}

	public void setRecepcionesCompra(List<ItemRecepcionCompra> recepcionesCompra) {
		this.recepcionesCompra = recepcionesCompra;
	}

}
