package dao;


import java.util.List;

import org.hibernate.Session;

import bean.*;

public class MuebleDao extends HibernateDao{

	public static MuebleDao instancia;
	
	private MuebleDao(){}
	
	public static MuebleDao getInstancia(){
		if(instancia == null)
			instancia = new MuebleDao();
		return instancia;
	}
	
	
	public List<MuebleBean> listarMuebles(){
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		@SuppressWarnings("unchecked")
//		List<MuebleBean> muebles = (List<MuebleBean>)s.createQuery("from ArticuloBean").list();
//		s.close();
//		return muebles;
		return null;
	}
	
	
	public int obtenerMaximoIdArticulo() {
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		int resultado = 1;
//		resultado = (int) s.createQuery("select max(a.idArticulo) from Articulo a").uniqueResult();
//		s.clear();
//		return resultado+1;
		return 0;
	}
	
}
