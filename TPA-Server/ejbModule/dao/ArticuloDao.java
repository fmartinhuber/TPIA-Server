package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import bean.ArticuloBean;

public class ArticuloDao extends HibernateDao{

	
	public static ArticuloDao instancia;
	
	private ArticuloDao(){}
	
	public static ArticuloDao getInstancia(){
		if(instancia == null)
			instancia = new ArticuloDao();
		return instancia;
	}
	
	
	public List<ArticuloBean> listarArticulos(){
//		EntityManager em = HibernateUtil.getSessionFactory();
//		List<ArticuloBean> articulos = (List<ArticuloBean>)em.createQuery("from Articulo")();
//		return articulos;
		return null;
	}
	
	
	public int obtenerMaximoIdArticulo() {
//		int resultado = 1;
//		resultado = (int) s.createQuery("select max(a.idArticulo) from Articulo a").uniqueResult();
//		s.clear();
//		return resultado+1;
		return 0;
	}	
	
	public ArticuloBean buscarArticuloPorCodigo(String codigo){
		
//		org.hibernate.Query query = s.createQuery("from ArticuloBean a where p.codigo = :codigoArticulo");
//		query.setParameter("codigoArticulo", codigo);
//		ArticuloBean articulo = (ArticuloBean) query.uniqueResult();
//		s.close();
//		return articulo;
		return null;
		
	}


	
}