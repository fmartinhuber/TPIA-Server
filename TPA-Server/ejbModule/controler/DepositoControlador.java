package controler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.ArticuloBean;
import bean.ItemRecepcionCompraBean;
import bean.RecepcionCompraBean;
import bean.SolicitudArticuloBean;
import bean.SolicitudCompraBean;
import dto.ArticuloDTO;
import dto.ItemSolicitudCompraDTO;
import dto.RecepcionCompraDTO;
import dto.SolicitudArticuloDTO;
import dto.SolicitudCompraDTO;
import util.Utils;


/**
 * Desde este controlador se deberian de llamar a todos los servicios
 * implementados.
 * 
 * @author Martin
 *
 */
@Stateless
@LocalBean
public class DepositoControlador implements IDepositoControladorLocal, IDepositoControladorRemote{

	@PersistenceContext(unitName="MyPU")
	private EntityManager em;
	
	public static DepositoControlador instancia;

	public static DepositoControlador getInstancia() {
		if (instancia == null)
			return new DepositoControlador();
		return instancia;
	}

	public DepositoControlador() {

	}

	public List <SolicitudArticuloDTO> obtenerSolicitudArticuloPendiente() {
		
		Query q = em.createQuery("Select s from SolicitudArticuloBean S where s.estado =:estado").setParameter("estado", "pendiente");
		@SuppressWarnings("unchecked")
		List<SolicitudArticuloBean> salida = q.getResultList();
		return Utils.solicitudArticuloBeanToDTO(salida);
		
	}
	
	public void crearArticulo(ArticuloDTO articulo){
		
		ArticuloBean newArticulo = new ArticuloBean();
		newArticulo.aArticuloBean(articulo);
		em.persist(newArticulo);
		
	}
	
		
	
	public void modificarStockDelArticulo(ArticuloDTO articulo){
		
		ArticuloBean newArticulo = new ArticuloBean();
		newArticulo.setCodigo(buscarArticuloPorCodigo(articulo.getCodArticulo()));
		newArticulo.aArticuloBean(articulo);
		em.merge(newArticulo);
		
	}


	@Override
	public void modificarArticulo(ArticuloDTO articulo) {
		
		ArticuloBean newArticulo = new ArticuloBean();
		newArticulo.aArticuloBean(articulo);
		em.merge(newArticulo);
		
	}


	@Override
	public void crearSolicitudCompra(SolicitudCompraDTO compraDTO){
		//Aca pasar DTO->Bean
		SolicitudCompraBean solicitudCompraBean = new SolicitudCompraBean();
		em.persist(solicitudCompraBean);
	}


	@Override
	public void recepcionCompra(RecepcionCompraDTO compraDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SolicitudArticuloDTO> solicitudesPendientes() {
		//Aca hacer DTO->Bean
		
		return null;
	}

	@Override

	public void crearRecepcionCompra(SolicitudCompraDTO solCompraDTO) {
		
		//Convertimos la solicitud de compra DTO a Recepción de compra BEAN

		RecepcionCompraBean recepCompra = new RecepcionCompraBean();		
		recepCompra.setCodigo(solCompraDTO.getCodigo());										// Seteamos el codigo de la recepción de compra
		List<ItemRecepcionCompraBean> itemsRecepCompra = new ArrayList<ItemRecepcionCompraBean>(); 		// Creamos la lista de Items de recepción de compra
		
		for (ItemSolicitudCompraDTO itSolDTO : solCompraDTO.getItemsSolicitudesCompra()) {		// Recorremos los items de la solicitud de compra a convertir en items recepcion
			
			// Obtenemos el articulo de la db por el codigo
			ArticuloBean art; 
			art = (ArticuloBean) em.createQuery("select a from ArticuloBean a where a.codArticulo = :codArticulo")
			.setParameter("codArticulo", itSolDTO.getArticulo().getCodArticulo())
			.getSingleResult();
			
			// Creamos el Items de la recepción de compra y seteamos articulo y cantidad
			ItemRecepcionCompraBean itRecepCompra = new ItemRecepcionCompraBean();
			itRecepCompra.setArticulo(art);
			itRecepCompra.setCantidad(itSolDTO.getCantidad());
			
			// Agregamos el item creado al array
			itemsRecepCompra.add(itRecepCompra);
			
			//Actualiza Stock
			Integer newStock = art.getCantidadDisponible() + itRecepCompra.getCantidad();
			art.setCantidadDisponible(newStock);
			em.merge(art);			
		}
		
		recepCompra.setItemsRecepcionesCompra(itemsRecepCompra);			// Seteamos la lista de items de recepción al bean de recepcion de compra
		em.persist(recepCompra);									// persistimos la recepción de compra
		
	}

	@Override
	public void crearSolicitudArticulo(SolicitudArticuloDTO solicitudArticuloDTO) {
		// TODO Auto-generated method stub
		
	}
	
	public Integer buscarArticuloPorCodigo(Integer codArticulo) {
		
		return (Integer) em.createQuery("SELECT a FROM ArticuloBean a where a.codArticulo= :codArticulo").setParameter("codArticulo", codArticulo).getSingleResult();		
	}

	public ArticuloDTO buscarArticuloPorNombre(String nombre) {
		
		return (ArticuloDTO) em.createQuery("SELECT a FROM ArticuloBean a where a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();			
	}	
	
	@SuppressWarnings("unchecked")
	public List<ArticuloDTO> listarArticulos() {
		// TODO Auto-generated method stub
		
		Query q = em.createQuery("from ArticuloBean");
		@SuppressWarnings("unused")
		List<ArticuloBean> salida = new ArrayList<ArticuloBean>();
		salida = q.getResultList();
		//return salida.stream().map(articuloBean -> new ArticuloDTO(a).collect(Collectors.<ArticuloDTO>toList()));
		return null;
	}



}
