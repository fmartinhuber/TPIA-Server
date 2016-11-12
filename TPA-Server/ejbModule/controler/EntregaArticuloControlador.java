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
	
	
	
	//OBTENER ARTICULOS DE SOLICITUD
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
