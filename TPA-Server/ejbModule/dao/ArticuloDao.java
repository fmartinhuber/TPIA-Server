package dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bean.*;

public class ArticuloDao extends HibernateDao{

	@PersistenceContext(unitName="MyPU")
	private static EntityManager em;
	
	private static ArticuloDao instancia = null;
	
	public static ArticuloDao getInstancia(){
		if(instancia == null){
			instancia = new ArticuloDao();
		} 
		return instancia;
	}
	
	
	public List<ArticuloBean> listarArticulos(){
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		@SuppressWarnings("unchecked")
//		List<ArticuloBean> articulos = (List<ArticuloBean>)s.createQuery("from ArticuloBean").list();
//		s.close();
//		return articulos;
		
		return null;
	}
	
	
	public int obtenerMaximoIdArticulo() {
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		int resultado = 1;
//		resultado = (int) s.createQuery("select max(a.id) from ArticuloBean a").uniqueResult();
//		s.clear();
//		return resultado+1;
		
		return 1;
	}	
	
	public ArticuloBean buscarArticuloPorCodigo(Integer codigo){
		
		//return (ArticuloBean)em.createQuery("select a from ArticuloBean a where a.codArticulo = :codigo").setParameter(codigo, codigo).getSingleResult();
		return (ArticuloBean)em.createQuery("select a from ArticuloBean a where a.codArticulo = 108").getSingleResult();
	}

	
}