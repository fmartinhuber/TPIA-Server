package negocio;

import interfaz.ArticuloEJBLocal;
import interfaz.ArticuloEJBRemote;

import java.util.*;

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

	@PersistenceContext
	private EntityManager em;
	
	// Constructor
    
    public ArticuloEJB() {}
    
    // Metodos a implementar

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticuloDTO> listarArticulos() {

		Query q = em.createQuery("Select a FROM ArticuloBean a");
		List<ArticuloDTO> salida = new ArrayList<ArticuloDTO>();
		List<ArticuloBean> articulos = new ArrayList<ArticuloBean>();
		articulos = q.getResultList();
		
		for(ArticuloBean a : articulos){
			salida.add(a.aArticuloDTO());
		}		
		return salida;					
	}
	
	@SuppressWarnings("unchecked")
	public List<ArticuloBean> listarArticulos2() {
		return em.createQuery("SELECT a FROM ArticuloBean a").getResultList();
	}

	@Override
	public void persist(ArticuloDTO articulo) {		
		em.persist(articulo);
	}

	@Override
	public void remove(ArticuloDTO articulo) {
		em.remove(articulo);
	}

	@Override
	public void update(ArticuloDTO articulo) {
		em.merge(articulo);
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
