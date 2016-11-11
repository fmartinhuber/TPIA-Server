package controler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.SolicitudArticuloBean;
import dto.ArticuloDTO;
import dto.SolicitudArticuloDTO;

//CONTROLADOR DE DARO

@Stateless
@LocalBean
public class EntregaArticuloControlador implements IEntregaArticuloControladorLocal, IEntregaArticuloControladorRemote{

	@PersistenceContext(unitName="MyPU")
	private EntityManager em;
	
	
	
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

	
	
	@Override
	public List<ArticuloDTO> obtenerArticulosDeSolicitud(String solicitudABuscar) {
		//Obtenemos los Articulos de la SolicitudArticulo seleccionada
		Query q = em.createQuery("from SolicitudArticuloBean sab where sab.codigo = :cod");
		q.setParameter("cod", solicitudABuscar);
		List<SolicitudArticuloBean> salidaBean = new ArrayList<SolicitudArticuloBean>();
		salidaBean = q.getResultList();
		
		
		return null;
	}

}
