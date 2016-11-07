package negocio;

import interfaz.ArticuloEJBLocal;
import interfaz.ArticuloEJBRemote;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bean.ArticuloBean;
import dto.ArticuloDTO;

/**
 * Session Bean implementation class ArticuloEJB
 */
@Stateless
@LocalBean
public class ArticuloEJB implements ArticuloEJBRemote, ArticuloEJBLocal {

	@PersistenceContext(unitName="MyPU")
	private EntityManager em;
	
	// Constructor
    
    public ArticuloEJB() {}
    
    // Metodos a implementar

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticuloDTO> listarArticulos() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from ArticuloBean");
		List<ArticuloBean> salida = new ArrayList<ArticuloBean>();
		salida = q.getResultList();
		//return salida.stream().map(a -> new ArticuloDTO(a.getNombre(),a.getCodigo()).collect(Collectors.<ArticuloDTO>toList()));
		return null;
	}


	@Override
	public ArticuloDTO buscarArticuloPorCodigo(Integer codArticulo) {
		
		return (ArticuloDTO) em.createQuery("SELECT a FROM ArticuloBean a where a.codArticulo= :codArticulo").setParameter("codArticulo", codArticulo).getSingleResult();		
	}

	@Override
	public ArticuloDTO buscarArticuloPorNombre(String nombre) {
		
		return (ArticuloDTO) em.createQuery("SELECT a FROM ArticuloBean a where a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();			
	}		

}
