package negocio;

import interfaz.ArticuloEJBLocal;
import interfaz.ArticuloEJBRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.ArticuloBean;
import dto.ArticuloDTO;

/**
 * Session Bean implementation class ArticuloEJB
 */
@Stateless
@LocalBean
public class ArticuloEJB implements ArticuloEJBRemote, ArticuloEJBLocal {

	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ArticuloEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addArticulo(ArticuloDTO art) {
		// TODO Auto-generated method stub
		
		// Transformar DTO a BEAN 
		ArticuloBean artb = new ArticuloBean();
		em.persist(artb);
	}

	@Override
	public List<ArticuloDTO> listarArticulos() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from ArticuloBean");
		List<ArticuloBean> salida = new ArrayList<ArticuloBean>();
		salida = q.getResultList();
		System.out.println(salida.get(0));
		return null;
	}

}
