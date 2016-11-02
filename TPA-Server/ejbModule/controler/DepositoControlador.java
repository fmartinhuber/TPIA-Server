package controler;

import java.util.ArrayList;
import java.util.List;

import bean.*;
import dao.*;
import dto.ArticuloDTO;
import dto.MuebleDTO;

//Prueba Daro 1er Commit

/**
 * Desde este controlador se deberian de llamar a todos los servicios
 * implementados. lskjdaf
 * 
 * @author Martin
 *
 */
public class DepositoControlador implements IDepositoControlador{

	public static DepositoControlador instancia;

	public static DepositoControlador getInstancia() {
		if (instancia == null)
			return new DepositoControlador();
		return instancia;
	}

	public DepositoControlador() {

	}

	public List<SolicitudArticuloBean> obtenerArticuloSolicitadoPendiente() {
		return SolicitudArticuloDao.getInstancia().obtenerArticulosPendientes();
	}

	public ArrayList<MuebleDTO> listarMuebles() {

		ArrayList<MuebleBean> muebles = new ArrayList<>();
		MuebleBean aux;
		List<MuebleBean> consulta = MuebleDao.getInstancia().listarMuebles();

		for (MuebleBean m : consulta) {
			aux = new MuebleBean();
			aux.setCodigo(m.getCodigo());
			aux.setDescripcion(m.getDescripcion());
			aux.setFoto(m.getFoto());
			aux.setIdArticulo(m.getIdArticulo());
			aux.setMarca(m.getMarca());
			aux.setMaterial(m.getMaterial());
			aux.setNombre(m.getNombre());
			aux.setOrigen(m.getOrigen());
			aux.setPrecio(m.getPrecio());
			aux.setStockActual(m.getStockActual());
			aux.setStockSolicitado(m.getStockSolicitado());
			aux.setTipo(m.getTipo());

			muebles.add(aux);

		}
		return null;
	}

	public void crearArticulo(ArticuloDTO articulo) {

		ArticuloBean newArticulo = new ArticuloBean();

		newArticulo.setCodigo(articulo.getCodigo());
		newArticulo.setDescripcion(articulo.getDescripcion());
		newArticulo.setFoto(articulo.getFoto());
		newArticulo.setIdArticulo(articulo.getIdArticulo());
		newArticulo.setMarca(articulo.getMarca());
		newArticulo.setNombre(articulo.getNombre());
		newArticulo.setOrigen(articulo.getOrigen());
		newArticulo.setPrecio(articulo.getPrecio());
		newArticulo.setStockActual(articulo.getStockActual());
		newArticulo.setStockSolicitado(articulo.getStockSolicitado());
		newArticulo.setTipo(articulo.getCodigo());

//		newArticulo.persistArticulo(newArticulo);
		ArticuloDao.getInstancia().persist(newArticulo);
	}

	public void modificarArticulo(ArticuloDTO articulo) {

		ArticuloBean newArticulo = ArticuloDao.getInstancia().buscarArticuloPorCodigo(articulo.getCodigo());

		newArticulo.setDescripcion(articulo.getDescripcion());
		newArticulo.setFoto(articulo.getFoto());
		newArticulo.setMarca(articulo.getMarca());
		newArticulo.setNombre(articulo.getNombre());
		newArticulo.setOrigen(articulo.getOrigen());
		newArticulo.setPrecio(articulo.getPrecio());
		newArticulo.setStockActual(articulo.getStockActual());
		newArticulo.setStockSolicitado(articulo.getStockSolicitado());
		newArticulo.setTipo(articulo.getTipo());

//		newArticulo.updateArticulo(newArticulo);
		ArticuloDao.getInstancia().persist(newArticulo);
	}
	
	public void modificarStockDelArticulo(ArticuloDTO articulo){
		
		ArticuloBean newArticulo = ArticuloDao.getInstancia().buscarArticuloPorCodigo(articulo.getCodigo());
		
		newArticulo.setStockActual(articulo.getStockActual());
		newArticulo.setStockSolicitado(articulo.getStockSolicitado());
		
//		newArticulo.updateArticulo(newArticulo);
		ArticuloDao.getInstancia().persist(newArticulo);
	}

}
