package bean;

import javax.persistence.*;

import dao.ArticuloDao;

/*	
 *	Daro: Todos los atributos de ArticuloBean fueron tomados del pdf de articulos en Web Campus
	Rama: hay 4 tipos de articulo, se separará con el identificador "Tipo"
	 
*/


@Entity
@Table(name = "Articulo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class ArticuloBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idArticulo;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String codigo;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private String marca;
	@Column(nullable = false)
	private float precio;
	@Column(nullable = false)
	private String foto;
	@Column(nullable = false)
	private String origen;

	@Transient
	@Column(insertable = false, updatable = false)
	private String tipo;
	
	@Column(nullable = false)
	private static String grupo;

	// protected String fichaTecnica;
	@Column(nullable = true)
	private Integer stockActual; // Atributo particular que manejamos por ser
									// Deposito
	@Column(nullable = true)
	private Integer stockSolicitado; /*
										 * Este atributo es necesario para
										 * posteriormente calcular la cantidad
										 * de Articulos a pedir. Es el stock que
										 * se desea tener en el deposito. Se
										 * carga al momento del alta y queda
										 * fijo
										 */

	public ArticuloBean(String nombre, String codigo, String descripcion, String marca, float precio, String foto,
			String origen, String tipo, Integer stockActual, Integer stockSolicitado) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.foto = foto;
		this.origen = origen;
		this.tipo = tipo;
		// this.fichaTecnica = fichaTecnica;
		this.stockActual = stockActual;
		this.stockSolicitado = stockSolicitado;
	}

	public ArticuloBean() {

	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// public String getFichaTecnica() {
	// return fichaTecnica;
	// }
	//
	// public void setFichaTecnica(String fichaTecnica) {
	// this.fichaTecnica = fichaTecnica;
	// }

	public Integer getStockActual() {
		return stockActual;
	}

	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}

	public Integer getStockSolicitado() {
		return stockSolicitado;
	}

	public void setStockSolicitado(Integer stockSolicitado) {
		this.stockSolicitado = stockSolicitado;
	}


}
