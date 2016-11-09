package bean;

import java.util.List;

import javax.persistence.*;

import dao.*;

@Entity
@Table (name="RecepcionCompra")
public class RecepcionCompraBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idRecepcionCompra;
	
	private Integer codigo;
		
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idItemRecepcionCompra")
	private List<ItemRecepcionCompra> recepcionesCompra;
	
	

	public RecepcionCompraBean() {}
	
	
	
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

	public List<ItemRecepcionCompra> getRecepcionesCompra() {
		return recepcionesCompra;
	}

	public void setRecepcionesCompra(List<ItemRecepcionCompra> recepcionesCompra) {
		this.recepcionesCompra = recepcionesCompra;
	}
	
	
}
