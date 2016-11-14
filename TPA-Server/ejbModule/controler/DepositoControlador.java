package controler;

import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.*;
import dto.*;
import util.Utils;

@Stateless
@LocalBean
public class DepositoControlador implements IDepositoControladorLocal, IDepositoControladorRemote{

	@PersistenceContext(unitName="MyPU")
	private EntityManager em;
	
	public static DepositoControlador instancia;

	// Singleton
	
	public static DepositoControlador getInstancia() {
		if (instancia == null)
			return new DepositoControlador();
		return instancia;
	}

	// Constructor
	
	public DepositoControlador() {}

	// Métodos a implementar
	
	@Override
	public List <SolicitudArticuloDTO> listarSolicitudArticuloPendiente() {
		
		Query q = em.createQuery("Select s from SolicitudArticuloBean S where s.estado =:estado").setParameter("estado", "pendiente");
		@SuppressWarnings("unchecked")
		List<SolicitudArticuloBean> salida = q.getResultList();
		return Utils.solicitudArticuloBeanToDTO(salida);
		
	}
	
	@Override
	public void crearArticulo(ArticuloDTO articuloDTO){
		
		ArticuloBean newArticulo = new ArticuloBean();
		newArticulo.aArticuloBean(articuloDTO);
		em.persist(newArticulo);
		
		
	}
	
		
	@Override
	public void modificarStockDelArticulo(ArticuloDTO articuloDTO){
								
		Query q = em.createQuery("from ArticuloBean a where a.codArticulo = :codArticulo");
		q.setParameter("codArticulo", articuloDTO.getCodArticulo());
		ArticuloBean newArticuloBean = new ArticuloBean();
		newArticuloBean = (ArticuloBean) q.getSingleResult();
		newArticuloBean.aArticuloBean(articuloDTO);
		em.merge(newArticuloBean);
	}


	@Override
	public void modificarArticulo(ArticuloDTO articuloDTO) {
		
		ArticuloBean newArticulo = new ArticuloBean();
		newArticulo.aArticuloBean(articuloDTO);
		em.merge(newArticulo);
	}


	@Override
	public void crearSolicitudCompra(SolicitudCompraDTO compraDTO){

		SolicitudCompraBean newSolicitudCompraBean = new SolicitudCompraBean();
		newSolicitudCompraBean.aSolicitudCompraBean(compraDTO);
		em.persist(newSolicitudCompraBean);
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

	
	//Daro: Seteo el estado en Finalizado de una Solicitud de Compra. Probar esto por favor
	public void actualizarEstadoSolicitudCompra(SolicitudCompraDTO solCompraDTO) {
		Query q = em.createQuery("from SolicitudCompraBean scb where scb.codigo = :cod");
		q.setParameter("cod", solCompraDTO.getCodigo());
		SolicitudCompraBean salidaBean = new SolicitudCompraBean();
		salidaBean = (SolicitudCompraBean) q.getResultList();

		salidaBean.setPendiente("Finalizado");
		em.merge(salidaBean);
	}
	
	
	//Daro: Seteo el estado en Finalizado de una Solicitud de Compra. Probar esto por favor
	public void actualizarEstadoSolicitudCompra(SolicitudCompraDTO solCompraDTO) {
		Query q = em.createQuery("from SolicitudCompraBean scb where scb.codigo = :cod");
		q.setParameter("cod", solCompraDTO.getCodigo());
		SolicitudCompraBean salidaBean = new SolicitudCompraBean();
		salidaBean = (SolicitudCompraBean) q.getResultList();

		salidaBean.setPendiente("Finalizado");
		em.merge(salidaBean);
	}
	
	
	@Override
	public void crearSolicitudArticulo(SolicitudArticuloDTO solicitudArticuloDTO) {
			
		SolicitudArticuloBean newSolicitudArticuloBean = new SolicitudArticuloBean();
		newSolicitudArticuloBean.aSolicitudArticuloBean(solicitudArticuloDTO);
		em.persist(newSolicitudArticuloBean);		
	}

	public ArticuloDTO obtenerArticuloPorCodigo(String codArticulo) {
		
		try{
			Query q = em.createQuery("from ArticuloBean a where a.codArticulo = :codArt");
			q.setParameter("codArt", codArticulo);
			ArticuloBean newArticuloBean = new ArticuloBean();
			newArticuloBean = (ArticuloBean) q.getSingleResult();
			ArticuloDTO articuloDTO = new ArticuloDTO();
			articuloDTO = newArticuloBean.aArticuloDTO();
				
			return articuloDTO;
		}catch (NoResultException e){
			System.out.println("ERROR NO EXISTE EL PRODUCTO: " + e.getMessage());
			System.out.println("ERROR NO EXISTE EL PRODUCTO");
		}
		return null;
	}

	

}
