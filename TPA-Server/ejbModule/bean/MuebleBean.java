package bean;

import javax.persistence.*;

import dao.MuebleDao;

@Entity
@DiscriminatorValue("MUE")
public class MuebleBean extends ArticuloBean{

	private String material;
	
	public MuebleBean(){}

	public MuebleBean(String nombre, String codigo, String descripcion, String marca, float precio, String foto,
			String origen, String tipo, Integer stockActual, Integer stockSolicitado, String material) {
		super(nombre, codigo, descripcion, marca, precio, foto, origen, tipo, stockActual, stockSolicitado);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	};
	
	
	
	public void mergeMueble(){
		MuebleDao.getInstancia().merge(this);
	}
	
	public void persistMueble(){
		MuebleDao.getInstancia().persist(this);
	}
	
	public void updateMueble(){
		MuebleDao.getInstancia().update(this);
	}
	
	public void deleteMueble(){
		MuebleDao.getInstancia().delete(this);
	}
	
}

