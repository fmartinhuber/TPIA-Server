package controler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.org.apache.bcel.internal.generic.IRETURN;

import bean.*;
import dao.*;
import dto.ArticuloDTO;
import dto.ItemSolicitudArticuloDTO;
import dto.ItemSolicitudCompraDTO;
import dto.RecepcionCompraDTO;
import dto.SolicitudArticuloDTO;
import dto.SolicitudCompraDTO;

//Prueba Daro 1er Commit

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

	public List<SolicitudArticuloBean> obtenerArticuloSolicitadoPendiente() {
		return SolicitudArticuloDao.obtenerArticulosPendientes();
	}
	
	public void crearArticulo(ArticuloDTO articulo){
		
		ArticuloBean newArticulo = new ArticuloBean();
		newArticulo.aArticuloBean(articulo);
		
		em.persist(newArticulo);
		
	}
	
		
	
	public void modificarStockDelArticulo(ArticuloBean articulo){
		
		ArticuloBean newArticulo = ArticuloDao.buscarArticuloPorCodigo(articulo.getCodigo());
		
		if(newArticulo != null){
			newArticulo.setCantidadDisponible(articulo.getCantidadDisponible());
			newArticulo.updateArticulo();
		}			
	}


	@Override
	public void modificarArticulo(ArticuloDTO articulo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void crearSolicitudCompra(SolicitudCompraDTO compraDTO){
		//Aca pasar DTO->Bean
		SolicitudCompraBean solicitudCompraBean = new SolicitudCompraBean();
		em.persist(solicitudCompraBean);
	}

	@Override
	public ArticuloDTO obtenerArticulosPendientes() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from SolicitudArticuloBean where estado = pendiente");
		List<SolicitudArticuloBean> salida = q.getResultList();
		return null;
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
		//actualizar Articulo
		RecepcionCompraBean recepCompra = new RecepcionCompraBean();
		
		//Convertimos la solicitud de compra DTO a Recepción de compra BEAN
		
		recepCompra.setCodigo(solCompraDTO.getCodigo());
		
		for (ItemSolicitudCompraDTO itSolDTO : solCompraDTO.getItemsSolicitudesCompra()) {
			//buscamos el itemsSolicitud de Compra para gravarlo como ItemsRecepcionCompra
			
			//Buscamos el articulo
			ArticuloBean art; 
			art = (ArticuloBean) em.createQuery("select a from ArticuloBean a where a.codArticulo = :codArticulo")
			.setParameter("codArticulo", itSolDTO.getArticulo().getCodArticulo())
			.getSingleResult();
			
			//Creamos el Items de la recepción de compra
			
			ItemRecepcionCompra itRecepCompra = new ItemRecepcionCompra();
			itRecepCompra.setArticulo(art);
			itRecepCompra.setCantidad(itSolDTO.getCantidad());
			
			
			
		}
		
	}

	@Override
	public void crearSolicitudArticulo(SolicitudArticuloDTO solicitudArticuloDTO) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArticuloDTO buscarArticuloPorCodigo(Integer codArticulo) {
		
		return (ArticuloDTO) em.createQuery("SELECT a FROM ArticuloBean a where a.codArticulo= :codArticulo").setParameter("codArticulo", codArticulo).getSingleResult();		
	}

	@Override
	public ArticuloDTO buscarArticuloPorNombre(String nombre) {
		
		return (ArticuloDTO) em.createQuery("SELECT a FROM ArticuloBean a where a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();			
	}	
	
	@Override
	public List<ArticuloDTO> listarArticulos() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from ArticuloBean");
		List<ArticuloBean> salida = new ArrayList<ArticuloBean>();
		salida = q.getResultList();
		//return salida.stream().map(articuloBean -> new ArticuloDTO(a).collect(Collectors.<ArticuloDTO>toList()));
		return null;
	}


}
