package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.SolicitudArticuloBean;
//import hbt.HibernateUtil;

public class SolicitudArticuloDao extends HibernateDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static SolicitudArticuloDao instancia = null;
	private static SessionFactory sf = null;

	public static SolicitudArticuloDao getInstancia(){
		if(instancia == null){
	//		sf = HibernateUtil.getSessionFactory();
			instancia = new SolicitudArticuloDao();
		} 
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List <SolicitudArticuloBean> obtenerArticulosPendientes(){
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		return s.createQuery("Select from SolicitudArticuloBean s where s.isPendiente=true").list();
		
		return null;
	}
}
