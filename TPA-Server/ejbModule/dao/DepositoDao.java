package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import hbt.HibernateUtil;

public class DepositoDao extends HibernateDao{

	private static DepositoDao instancia = null;
	private static SessionFactory sf = null;

	public static DepositoDao getInstancia(){
		if(instancia == null){
//			sf = HibernateUtil.getSessionFactory();
			instancia = new DepositoDao();
		} 
		return instancia;
	}
	

	
	
	public void prueba(){
		Session session = sf.openSession();
		session.beginTransaction();
		System.out.println("Metodo de prueba utilizado. Por favor no borrar. Sirve para cargar las tablas en la BD");
	}
	
}
