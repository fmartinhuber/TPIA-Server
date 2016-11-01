package bean;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ELE")
public class ElectrodomesticoBean extends ArticuloBean {

	private String fichaTecnica;
	
	public ElectrodomesticoBean(){}

	public ElectrodomesticoBean(String nombre, String codigo, String descripcion, String marca, float precio,
			String foto, String origen, String tipo, Integer stockActual, Integer stockSolicitado, String fichaTecnica) {
		super(nombre, codigo, descripcion, marca, precio, foto, origen, tipo, stockActual, stockSolicitado);
		this.fichaTecnica = fichaTecnica;
	}

	public String getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	};
	
	
	
}
