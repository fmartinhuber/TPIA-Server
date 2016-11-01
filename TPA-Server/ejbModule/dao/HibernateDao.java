package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HibernateDao{
	protected static HibernateDao instancia = null;

	@PersistenceContext(unitName="MyPU")
	private EntityManager manager;
	
	public static HibernateDao getInstancia(){
		if(instancia == null){
			instancia = new HibernateDao();
		} 
		return instancia;
	}
	
	protected HibernateDao()  {
		
	}

	
	public void persist(Object obj) {
		manager.persist(obj);
	}
	
	public void merge(Object obj) {
		manager.merge(obj);
	}
	
	public void delete(Object obj) {
		manager.remove(obj);
	}
	
	@SuppressWarnings("rawtypes")
	public void persistList(List lista){
		for(Object e : lista){
			manager.persist(e);
		}
	}
	
	public void update(Object obj) {
		manager.merge(obj);
	}
	
	
}