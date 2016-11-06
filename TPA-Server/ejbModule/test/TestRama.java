package test;

import java.util.*;

import bean.*;
import controler.*;
import dao.*;
import dto.*;
import interfaz.ArticuloEJBLocal;
import negocio.*;

public class TestRama {

	public static void main(String[] args) {
		
//		List<ArticuloDTO> articulosDTO = new ArrayList<ArticuloDTO>();
//						
//		ArticuloEJBLocal articuloEJB = new ArticuloEJB();
//		articulosDTO = articuloEJB.listarArticulos();
//		
//		for(ArticuloDTO a : articulosDTO){
//			System.out.println("Codigo: " +a.getCodArticulo());
//		}
		
		
		ArticuloEJBLocal articuloEJB2 = new ArticuloEJB();
		ArticuloDTO newArticulo = new ArticuloDTO();
		
		newArticulo.setCodArticulo(666);
		
		articuloEJB2.persist(newArticulo);
		
//		List<ArticuloBean> articulosBean = new ArrayList<ArticuloBean>();
//		ArticuloEJBLocal articuloEJB = new ArticuloEJB();
//		articulosBean = articuloEJB.listarArticulos2();
		
//		ArrayList<ArticuloBean> articulos = (ArrayList<ArticuloBean>) DepositoControlador.getInstancia().listarArticulos();
//		
//		for(ArticuloBean a : articulos){
//			System.out.println("Codigo: " +a.getCodigo());
//		}
//		
//		System.out.println();
//		System.out.println();
//		
//		ArticuloBean newArticulo = new ArticuloBean();
//		newArticulo.setCodigo(666);
//		newArticulo.setDescripcion("Descripcion new");
//		
//		DepositoControlador.getInstancia().crearArticulo(newArticulo);
//
//		System.out.println();
//		System.out.println();
		
		
//		ArticuloBean newArticulo = new ArticuloBean();
//		newArticulo.setCodigo(888);
//		newArticulo.setCantidadDisponible(15);
//		
//		DepositoControlador.getInstancia().modificarStockDelArticulo(newArticulo);
//		System.out.println("Se modificó el artículo");
		
		

	}

}
