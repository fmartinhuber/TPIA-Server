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
public class EntregaArticuloControlador implements IEntregaArticuloControladorLocal, IEntregaArticuloControladorRemote{

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

	


	//Esto se tiene que borrar
	//OBTENER SOLICITUDARTICULO POR CODIGO
	public SolicitudArticuloDTO obtenerSolicitudArticuloPorCodigo(String solicitudABuscar) {
		//Obtenemos las Soliciudes de Articulo en estado Pendiente Y por codigo
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.estado = :estped and sab.codigo = :codped");
		q.setParameter("estped", "Pendiente");
		q.setParameter("codped", solicitudABuscar);
		SolicitudArticuloBean salidaBean = new SolicitudArticuloBean();
		salidaBean = (SolicitudArticuloBean) q.getSingleResult();
		
		return salidaBean.aSolicitudArticuloDTO();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
