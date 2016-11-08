package dao;

import java.util.*;

import org.hibernate.Session;

import bean.*;

public class ArticuloDao extends HibernateDao{

	
	
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
	
	public static ArticuloBean buscarArticuloPorCodigo(int codigo){
		
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		org.hibernate.Query query = s.createQuery("select a from ArticuloBean a where a.codArticulo = :codigoArticulo");
//		query.setParameter("codigoArticulo", codigo);
//		ArticuloBean articulo = (ArticuloBean) query.uniqueResult();
//		s.close();
//		return articulo;	
		
		return null;
	}
	
	public ArticuloBean buscarArticuloPorCodigo2(ArticuloBean articulo){
		
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		
//		ArticuloBean salida = (ArticuloBean) s.createQuery("from ArticuloBean a where a.codigo = " +articulo.getCodigo()).uniqueResult();
//		
//		return salida;
		
		return null;
	}

	
//	public ArticuloBean2 obtenerArticuloPorID(long id){
//		
//		return (ArticuloBean2)em.createQuery("SELECT a FROM ArticuloBean2 a " + "WHERE a.codigo = :id").setParameter("id", id).getSingleResult();
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<ArticuloBean2> listarArticulosPorFechas(Date start, Date end) {
//		return em.createQuery(
//			     "SELECT a FROM ArticuloBean2 a "
//			      + "WHERE a.fecha between :start and :end"
//			      + " =:start").setParameter("start", start).setParameter("end", end).getResultList();
//	}
//	
//	public ArticuloBean2 obtenerArticuloPorNombre(String nombre) {
//		return (ArticuloBean2) em.createQuery(
//			      "SELECT a FROM ArticuloBean2 a WHERE a.nombre =:nombre").setParameter("nombre", nombre).setMaxResults(1).getSingleResult();
//	}
//
//		
//	@SuppressWarnings("unchecked")
//	public List<ArticuloBean2> listarArticulos() {
//		return em.createQuery("SELECT a FROM ArticuloBean2 a").getResultList();
//	}
//
//	@Override
//	public void persist(ArticuloBean2 articulo) {
//		em.persist(articulo);
//	}
//
//	@Override
//	public void remove(ArticuloBean2 articulo) {
//		em.remove(articulo);
//	}
//
//	@Override
//	public void update(ArticuloBean2 articulo) {
//		em.merge(articulo);		
//	}
	

	
}