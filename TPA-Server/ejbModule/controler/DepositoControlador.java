package controler;

import java.util.ArrayList;
import java.util.List;

import bean.*;
import dao.*;
import dto.ArticuloDTO;
import interfaz.ArticuloEJBLocal;
import negocio.ArticuloEJB;

//Prueba Daro 1er Commit

/**
 * Desde este controlador se deberian de llamar a todos los servicios
 * implementados. lskjdaf
 * 
 * @author Martin
 *
 */
public class DepositoControlador implements IDepositoControlador {

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
	
	public void crearArticulo(ArticuloBean articulo){
		
		ArticuloBean newArticulo = new ArticuloBean();
				
		newArticulo.setCantidadDisponible(articulo.getCantidadDisponible());
		newArticulo.setIdDeposito(articulo.getIdDeposito());
		newArticulo.setCodigo(articulo.getCodigo());
		newArticulo.setDescripcion(articulo.getDescripcion());
		newArticulo.setEdadRecomendada(articulo.getEdadRecomendada());
		newArticulo.setFecha(articulo.getFecha());
		newArticulo.setFichaTecnica(articulo.getFichaTecnica());
		newArticulo.setFoto(articulo.getFoto());
		newArticulo.setMarca(articulo.getMarca());
		newArticulo.setMaterial(articulo.getMaterial());
		newArticulo.setNombre(articulo.getNombre());
		newArticulo.setOrigen(articulo.getOrigen());
		newArticulo.setPrecio(articulo.getPrecio());
		newArticulo.setTalle(articulo.getTalle());
		newArticulo.setColor(articulo.getColor());
		newArticulo.setTipo(articulo.getTipo());		
		
		newArticulo.persistArticulo();
		
	}
	
	public List<ArticuloBean> listarArticulos2(){
		
		List<ArticuloBean> salida = new ArrayList<ArticuloBean>();
		ArticuloBean aux;
		List<ArticuloBean> articulos = ArticuloDao.getInstancia().listarArticulos();
		
		for(ArticuloBean a : articulos){
			aux = new ArticuloBean();
			aux.setCantidadDisponible(a.getCantidadDisponible());
			aux.setCodigo(a.getCodigo());
			aux.setDescripcion(a.getDescripcion());
			aux.setIdDeposito(a.getIdDeposito());
			aux.setEdadRecomendada(a.getEdadRecomendada());
			aux.setFecha(a.getFecha());
			aux.setFichaTecnica(a.getFichaTecnica());
			aux.setFoto(a.getFoto());
			aux.setMarca(a.getMarca());
			aux.setMaterial(a.getMaterial());
			aux.setId(a.getId());
			aux.setNombre(a.getNombre());
			aux.setOrigen(a.getOrigen());
			aux.setPrecio(a.getPrecio());
			aux.setTalle(a.getTalle());
			aux.setColor(a.getColor());
			aux.setTipo(a.getTipo());
			
			salida.add(aux);
		}
		
		return salida;
		
	}
		
	
	public void modificarStockDelArticulo(ArticuloBean articulo){
		
		ArticuloBean newArticulo = ArticuloDao.getInstancia().buscarArticuloPorCodigo(articulo.getCodigo());
		
		if(newArticulo != null){
			newArticulo.setCantidadDisponible(articulo.getCantidadDisponible());
			newArticulo.updateArticulo();
		}			
	}

	@Override
	public void crearArticulo(ArticuloDTO articulo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarArticulo(ArticuloDTO articulo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ArticuloDTO> listarArticulos() {
		
		ArrayList<ArticuloDTO> salida = new ArrayList<ArticuloDTO>();
		ArticuloDTO aux;
		
		
		
		return salida;
		
	}
	

}
