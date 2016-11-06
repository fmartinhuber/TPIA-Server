package test;

import java.util.ArrayList;

import bean.*;
import controler.*;
import dao.*;
import dto.*;

public class TestRama {

	public static void main(String[] args) {
		
		ArrayList<ArticuloDTO> articulos = new ArrayList<ArticuloDTO>();
		articulos = (ArrayList<ArticuloDTO>) DepositoControlador.getInstancia().listarArticulos();
		
		for(ArticuloDTO a : articulos){
		System.out.println("Codigo: " +a.getCodArticulo());
		}
		
		
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
