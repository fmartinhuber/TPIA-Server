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

	@Override
	public List<ArticuloDTO> listarArticulos() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from ArticuloBean");
		List<ArticuloBean> salida = new ArrayList<ArticuloBean>();
		salida = q.getResultList();
		return salida.stream().map(a -> new ArticuloDTO(a.getId(),a.getNombre(),a.getCodigo(),a.getColor())).collect(Collectors.<ArticuloDTO>toList());
	}

	@Override
	public ArticuloDTO buscarArticuloPorCodigo(Integer codArticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticuloDTO buscarArticuloPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
