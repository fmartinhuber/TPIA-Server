package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.SolicitudArticuloBean;

public class SolicitudArticuloDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static SolicitudArticuloDao instancia = null;
	private static SessionFactory sf = null;

	public static SolicitudArticuloDao getInstancia(){
		if(instancia == null){
			instancia = new SolicitudArticuloDao();
		} 
		return instancia;
	}
	
	public List <SolicitudArticuloBean> obtenerArticulosPendientes(){
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		return s.createQuery("Select from SolicitudArticuloBean s where s.isPendiente=true").list();
		return null;
	}
}
