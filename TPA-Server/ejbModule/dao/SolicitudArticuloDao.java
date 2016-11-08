package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.ArticuloBean;
import bean.SolicitudArticuloBean;
//import hbt.HibernateUtil;

public class SolicitudArticuloDao extends HibernateDao {

//	@PersistenceContext(unitName="MyPU")
//	private EntityManager em;
	
	
	public static List <SolicitudArticuloBean> obtenerArticulosPendientes(){
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		return s.createQuery("Select from SolicitudArticuloBean s where s.isPendiente=true").list();
		
//		Query q = em.createQuery("from SolicitudArticuloBean where estado = pendiente");
//		List<ArticuloBean> salida = new ArrayList<ArticuloBean>();
//		salida = q.getResultList();
		return null;
	}
}
