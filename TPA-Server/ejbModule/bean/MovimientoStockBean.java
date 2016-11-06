package bean;

import javax.persistence.*;

import dao.*;

@Entity
@Table(name = "DetalleMovimientoStock")
public class MovimientoStockBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMovimientoStock;
	@ManyToOne
	@JoinColumn(name = "idArticulo")
	
	private ArticuloBean articulo;
	private String tipoMovimiento; 
	private Integer cantidad;
	
	// Constructor
	
	public MovimientoStockBean(ArticuloBean articulo, String tipoMovimiento, Integer cantidad) {
		super();
		this.articulo = articulo;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidad = cantidad;
	}

	public MovimientoStockBean() {
		super();
	}	

	public Integer getIdMovimientoStock() {
		return idMovimientoStock;
	}

	public void setIdMovimientoStock(Integer idMovimientoStock) {
		this.idMovimientoStock = idMovimientoStock;
	}

	public ArticuloBean getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloBean articulo) {
		this.articulo = articulo;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public void mergeDetalleMovimientoStock() {
		DetalleMovimientoStockDao.getInstancia().merge(this);
	}

	public void persistDetalleMovimientoStock() {
		DetalleMovimientoStockDao.getInstancia().persist(this);
	}

	public void updateDetalleMovimientoStock() {
		DetalleMovimientoStockDao.getInstancia().update(this);
	}

	public void deleteDetalleMovimientoStock() {
		DetalleMovimientoStockDao.getInstancia().delete(this);
	}
	
}
