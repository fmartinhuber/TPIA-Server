package controler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.*;
import dto.*;

//CONTROLADOR DE DARO

@Stateless
@LocalBean
public class EntregaArticuloControlador implements IEntregaArticuloControladorLocal{

	@PersistenceContext(unitName="MyPU")
	private EntityManager em;
			
	//LISTAR SOLICITUDES PENDIENTES
	@SuppressWarnings("unchecked")
	public List<SolicitudArticuloDTO> listarSolicitudesPendientes() {
		
		//Obtenemos las Soliciudes de Articulo en estado Pendiente
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.estado = :estped");
		q.setParameter("estped", "Pendiente");
		List<SolicitudArticuloBean> salidaBean = new ArrayList<SolicitudArticuloBean>();
		salidaBean = q.getResultList();
		
		//Pasamos las SolicitudesBean a SolicitudesDTO
		List<SolicitudArticuloDTO> salidaDto = new ArrayList<SolicitudArticuloDTO>();
		for (SolicitudArticuloBean s : salidaBean){
			SolicitudArticuloDTO solArtDto = new SolicitudArticuloDTO();
			solArtDto = s.aSolicitudArticuloDTO();
			salidaDto.add(solArtDto);
		}
		
		//Devolvemos las solicitudesDTO pendientes obtenidas
		return salidaDto;
	}
	
	
	
	//OBTENER ITEMARTICULO DE SOLICITUDARTICULO
	public List<ItemSolicitudArticuloDTO> obtenerItemDeSolicitud(String solicitudABuscar) {
		//Obtenemos la SolicitudesArticulo seleccionada
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.codigo = :cod");
		q.setParameter("cod", solicitudABuscar);
		SolicitudArticuloBean salidaBean = new SolicitudArticuloBean();
		salidaBean = (SolicitudArticuloBean) q.getSingleResult();
		
		//Obtenemos los ItemSolicitudArticulos de esta SolicitudArticulo, lo pasamos a DTO y hacemos lista
		List <ItemSolicitudArticuloDTO> listaItmSolArtDto = new ArrayList<ItemSolicitudArticuloDTO>();
		for (int i=0; i<salidaBean.getItemsSolicitudArticulo().size(); i++){
			ItemSolicitudArticuloDTO miItmSolArtDto = new ItemSolicitudArticuloDTO();
			miItmSolArtDto = salidaBean.getItemsSolicitudArticulo().get(i).aItemSolicitudArticuloDTO();
			listaItmSolArtDto.add(miItmSolArtDto);
		}
		
		//Devolvemos la lista de ArticulosDto
		return listaItmSolArtDto;
	}

	


	//ACTUALIZAR ARTICULO DE SOLICITUDARTICULO
	public void actualizarSolicitudArticulo(String solicitudABuscar, String articuloBuscado, Integer nuevaCant) {
		//Obtenemos la SolicitudArticulo que se encuentra cargada en la base
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.estado = :estped and sab.codigo = :codped");
		q.setParameter("estped", "Pendiente");
		q.setParameter("codped", solicitudABuscar);
		SolicitudArticuloBean miSolArtBeanBASE = new SolicitudArticuloBean();
		miSolArtBeanBASE = (SolicitudArticuloBean) q.getSingleResult();
		
		//Buscamos el Item del la SolicitudBASE y actualizamos el stock con el recibido por parametro
		for (ItemSolicitudArticuloBean ib : miSolArtBeanBASE.getItemsSolicitudArticulo()){
			//Si coinciden codigo articulo actualizo la cantidad del item
			if (ib.getArticulo().getCodigo().equalsIgnoreCase(articuloBuscado)){
				ib.setCantidad(nuevaCant);
			}
		}
		
		//Actualizo la Solicitud
		em.merge(miSolArtBeanBASE);
	}


	

	//DECREMENTAR EL STOCK POR LA CANTIDAD PEDIDA POR LA SOLICITUD
	public void decrementarStock(String solicitudABuscar) {
		//Obtenemos la SolicitudArticulo que se encuentra cargada en la base
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.estado = :estped and sab.codigo = :codped");
		q.setParameter("estped", "Pendiente");
		q.setParameter("codped", solicitudABuscar);
		SolicitudArticuloBean miSolArtBeanBASE = new SolicitudArticuloBean();
		miSolArtBeanBASE = (SolicitudArticuloBean) q.getSingleResult();
		
		//Actualizo el stock
		for(ItemSolicitudArticuloBean ib : miSolArtBeanBASE.getItemsSolicitudArticulo()){
			int cantEnviada = ib.getCantidad();
			int stockActual = ib.getArticulo().getCantidadDisponible();
			//Decremento el stock del articulo por la cantidad enviada
			ib.getArticulo().setCantidadDisponible(stockActual-cantEnviada);
		}
		
		//Actualizo la Solicitud
		em.merge(miSolArtBeanBASE);
	}



	
	//ACTUALIZAR ESTADO SOLICITUD A "ENTREGADA"
	public void actualizarEstadoSolicitud(String solicitudABuscar) {
		//Obtenemos la SolicitudArticulo que se encuentra cargada en la base
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.estado = :estped and sab.codigo = :codped");
		q.setParameter("estped", "Pendiente");
		q.setParameter("codped", solicitudABuscar);
		SolicitudArticuloBean miSolArtBeanBASE = new SolicitudArticuloBean();
		miSolArtBeanBASE = (SolicitudArticuloBean) q.getSingleResult();
		
		//Actualizo el estado de la Solicitud
		miSolArtBeanBASE.setEstado("Entregada");
		
		//Actualizo la Solicitud
		em.merge(miSolArtBeanBASE);
	}



	//ENVIAR JSON A DESPACHO
	public SolicitudArticuloDTO enviarJSON(String solicitudABuscar) {
		//Obtenemos la SolicitudArticulo que se encuentra cargada en la base
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.estado = :estped and sab.codigo = :codped");
		q.setParameter("estped", "Pendiente");
		q.setParameter("codped", solicitudABuscar);
		SolicitudArticuloBean miSolArtBeanBASE = new SolicitudArticuloBean();
		miSolArtBeanBASE = (SolicitudArticuloBean) q.getSingleResult();
		
		//Devolvemos la Solicitud Articulo Dto
		SolicitudArticuloDTO miSolArtDto = new SolicitudArticuloDTO();
		return miSolArtBeanBASE.aSolicitudArticuloDTO();	
	}

	
	/* ---------------- Aqui empieza Solicitud de Compra -----------------------------------*/
	
	// GENERA SOLICITUD DE COMPRA
	public void generarSolicitudCompra(List<String> elementos){
		
		// Solicitud de Compra que se presistira
		SolicitudCompraBean solCompra = new SolicitudCompraBean();
		List<SolicitudArticuloBean> solicitudesArticulos = new ArrayList<>();
		List<ItemSolicitudCompraBean> itemsSolicitudCompra = new ArrayList<>();
		
		String codSolArticulo = "";												// Utilizado para detectar una nueva solicitud
		for (String elem : elementos) {
			String delims = ";";
			String[] codigos = elem.split(delims);
			
			// Si el codigo no coincide con el anterior busca la solicitud de articulo
			if(codSolArticulo != codigos[0]){			
				// Buscar solicitud de articulo por codigo y la agregamos al array de solicitudes
				SolicitudArticuloBean solArticulos = this.getSolicitudArticuloByCodigo(codigos[0]);
				solicitudesArticulos.add(solArticulos);
			}
			
			// Buscamos articulo en función del codigo enviado
			ArticuloBean art; 
			art = (ArticuloBean) em.createQuery("select a from ArticuloBean a where a.codArticulo = :codArticulo")
			.setParameter("codArticulo", codigos[1])
			.getSingleResult();
			
			// Creamos el itemSolicitud de compra y lo agregamos al array de itemsSolicitude de Compra
			ItemSolicitudCompraBean itemSolicitudCompra = new ItemSolicitudCompraBean();
			itemSolicitudCompra.setArticulo(art);
			itemSolicitudCompra.setCantidad(Integer.parseInt(codigos[2]));
			itemsSolicitudCompra.add(itemSolicitudCompra);
			
		}
		// Agregamos los array de solicitudes de articulos y los items de articulos
		solCompra.setItemsSolicitudesCompra(itemsSolicitudCompra);
		solCompra.setSolicitudesArticulos(solicitudesArticulos);
		
		// Pesistimos la solicitu de compra
		em.persist(solCompra);
		
	}

	// Levanta la solicitud de Articulos a partir de un codigo
	private SolicitudArticuloBean getSolicitudArticuloByCodigo(String codigo){
		SolicitudArticuloBean solicitud;
		solicitud = (SolicitudArticuloBean) em.createQuery("select a from ArticuloBean a where a.codArticulo = :codArticulo")
				.setParameter("codArticulo", codigo).getSingleResult();
		return solicitud;
	}
	
	// Prueba commit
}
