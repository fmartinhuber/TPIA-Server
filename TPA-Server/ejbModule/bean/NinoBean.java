package bean;

import javax.persistence.*;

@Entity
@DiscriminatorValue("NIN")
public class NinoBean extends ArticuloBean {

	private Integer edadRecomendada;

	public NinoBean() {
	}

	public NinoBean(String nombre, String codigo, String descripcion, String marca, float precio, String foto,
			String origen, String tipo, Integer stockActual, Integer stockSolicitado, Integer edadRecomendada) {
		super(nombre, codigo, descripcion, marca, precio, foto, origen, tipo, stockActual, stockSolicitado);
		this.edadRecomendada = edadRecomendada;
	}
}
