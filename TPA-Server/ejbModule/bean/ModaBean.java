package bean;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MOD")
public class ModaBean extends ArticuloBean {

	private String color;
	private String talle;
	
	public ModaBean(){}

	public ModaBean(String nombre, String codigo, String descripcion, String marca, float precio, String foto,
			String origen, String tipo, Integer stockActual, Integer stockSolicitado, String color,
			String talle) {
		super(nombre, codigo, descripcion, marca, precio, foto, origen, tipo, stockActual, stockSolicitado);
		this.color = color;
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	};
	
	
	
	
}
