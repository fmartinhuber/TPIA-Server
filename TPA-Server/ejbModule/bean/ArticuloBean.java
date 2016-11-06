package bean;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import dao.ArticuloDao;

@Entity
@Table(name = "Articulo")
public class ArticuloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = true)
	private String idDeposito; 	
	@Column(nullable = true)
	private Integer codArticulo;
	@Column(nullable = true)
	private String nombre;
	@Column(nullable = true)
	private String descripcion;
	@Column(nullable = true)
	private String marca;
	@Column(nullable = true)
	private Float precio;
	@Column(nullable = true)
	private String foto;
	@Column(nullable = true)
	private String origen;	
	@Column(nullable = true)
	private String tipo;
	@Column(nullable = true)
	private Date fecha;	
	@Column(nullable = true)
	private String edadRecomendada;
	@Column(nullable = true)
	private String fichaTecnica;
	@Column(nullable = true)
	private String color;
	@Column(nullable = true)
	private String talle;
	@Column(nullable = true)
	private String material;
	@Column(nullable = true)
	private Integer cantidadDisponible;	
		
	public ArticuloBean(){}

	public ArticuloBean(Integer id, String idDeposito, Integer codArticulo, String nombre, String descripcion, String marca, String origen,
			Float precio, String tipo, Date fecha, String foto, String edadRecomendada, String fichaTecnica,
			String talle, String material, Integer cantidadDisponible, String color) {
		super();
		this.id = id;
		this.idDeposito = idDeposito;
		this.codArticulo = codArticulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.origen = origen;
		this.precio = precio;
		this.tipo = tipo;
		this.fecha = fecha;
		this.foto = foto;
		this.edadRecomendada = edadRecomendada;
		this.fichaTecnica = fichaTecnica;
		this.talle = talle;
		this.material = material;
		this.cantidadDisponible = cantidadDisponible;
		this.color = color;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(String idDeposito) {
		this.idDeposito = idDeposito;
	}

	public Integer getCodigo() {
		return codArticulo;
	}

	public void setCodigo(Integer codArticulo) {
		this.codArticulo = codArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public String getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	};
	
	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	public void mergeArticulo() {
		ArticuloDao.getInstancia().merge(this);
	}

	public void persistArticulo() {
		ArticuloDao.getInstancia().persist(this);
	}

	public void updateArticulo() {
		ArticuloDao.getInstancia().update(this);
	}

	public void deleteArticulo() {
		ArticuloDao.getInstancia().delete(this);
	}
	
	
}
