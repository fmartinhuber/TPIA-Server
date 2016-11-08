package other;

import java.util.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bean.*;

public class CargarArticulos {

	private static CargarArticulos instancia;
	
	public static CargarArticulos getInstancia(){
		if(instancia==null)
			instancia = new CargarArticulos();
		return instancia;
	}
	
	public void cargaDeDatos(){
				
		// Seteo de Fechas
		
		Calendar cal01 = GregorianCalendar.getInstance(); 	cal01.add(Calendar.DAY_OF_YEAR, -1);	Date day01 = cal01.getTime();	cal01.add(Calendar.MONTH, 1); 	Date day06 = cal01.getTime();
		Calendar cal02 = GregorianCalendar.getInstance();	cal02.add(Calendar.DAY_OF_YEAR, -5);	Date day02 = cal02.getTime();	cal02.add(Calendar.MONTH, 1); 	Date day07 = cal02.getTime();
		Calendar cal03 = GregorianCalendar.getInstance();	cal03.add(Calendar.DAY_OF_YEAR, -13);	Date day03 = cal03.getTime();	cal03.add(Calendar.MONTH, 1); 	Date day08 = cal03.getTime();
		Calendar cal04 = GregorianCalendar.getInstance();	cal04.add(Calendar.DAY_OF_YEAR, -27);	Date day04 = cal04.getTime();	cal04.add(Calendar.MONTH, 1); 	Date day09 = cal04.getTime();
		Calendar cal05 = GregorianCalendar.getInstance();	cal05.add(Calendar.DAY_OF_YEAR, -31);	Date day05 = cal05.getTime();	cal05.add(Calendar.MONTH, 1); 	Date day10 = cal05.getTime();
		
		// Alta de Articulos
		
		// Electrodomestico: ficha tecnica
		// Muebles: material
		// Niños: edad 
		// Moda: color y talle		
		
		// Alta de electrodomésticos
		
		ArticuloBean articulo01 = new ArticuloBean();
		articulo01.setCantidadDisponible(1000);
		articulo01.setIdDeposito("G12");
		articulo01.setCodigo(101);
		articulo01.setDescripcion("Descripcion 01");
		articulo01.setFecha(day01);
		articulo01.setFichaTecnica("Ficha tecnica 01");
		articulo01.setFoto("Foto 01");
		articulo01.setMarca("Marca 01");
		articulo01.setNombre("Nombre 01");
		articulo01.setOrigen("Origen 01");
		articulo01.setPrecio(1000);
		articulo01.setTipo("Electro");
		
		ArticuloBean articulo02 = new ArticuloBean();
		articulo02.setCantidadDisponible(2000);
		articulo02.setIdDeposito("G12");
		articulo02.setCodigo(102);
		articulo02.setDescripcion("Descripcion 02");
		articulo02.setFecha(day02);
		articulo02.setFichaTecnica("Ficha tecnica 02");
		articulo02.setFoto("Foto 02");
		articulo02.setMarca("Marca 02");
		articulo02.setNombre("Nombre 02");
		articulo02.setOrigen("Origen 02");
		articulo02.setPrecio(2000);
		articulo02.setTipo("Electro");
		
		articulo01.persistArticulo();
		articulo02.persistArticulo();
		
		// Alta de Muebles
		
		ArticuloBean articulo03 = new ArticuloBean();
		articulo03.setCantidadDisponible(3000);
		articulo03.setIdDeposito("G12");
		articulo03.setCodigo(103);
		articulo03.setDescripcion("Descripcion 03");
		articulo03.setFecha(day03);
		articulo03.setMaterial("Material 03");
		articulo03.setFoto("Foto 03");
		articulo03.setMarca("Marca 03");
		articulo03.setNombre("Nombre 03");
		articulo03.setOrigen("Origen 03");
		articulo03.setPrecio(3000);
		articulo03.setTipo("Mueble");
		
		ArticuloBean articulo04 = new ArticuloBean();
		articulo04.setCantidadDisponible(4000);
		articulo04.setIdDeposito("G12");
		articulo04.setCodigo(104);
		articulo04.setDescripcion("Descripcion 04");
		articulo04.setFecha(day04);
		articulo04.setMaterial("Material 04");
		articulo04.setFoto("Foto 04");
		articulo04.setMarca("Marca 04");
		articulo04.setNombre("Nombre 04");
		articulo04.setOrigen("Origen 04");
		articulo04.setPrecio(4000);
		articulo04.setTipo("Mueble");
		
		articulo03.persistArticulo();
		articulo04.persistArticulo();
		
		// Alta de Infantil
		
		ArticuloBean articulo05 = new ArticuloBean();
		articulo05.setCantidadDisponible(5000);
		articulo05.setIdDeposito("G12");
		articulo05.setCodigo(105);
		articulo05.setDescripcion("Descripcion 05");
		articulo05.setFecha(day05);
		articulo05.setEdadRecomendada("De 1 año a 2 años");
		articulo05.setFoto("Foto 05");
		articulo05.setMarca("Marca 05");
		articulo05.setNombre("Nombre 05");
		articulo05.setOrigen("Origen 05");
		articulo05.setPrecio(5000);
		articulo05.setTipo("Infantil");
		
		ArticuloBean articulo06 = new ArticuloBean();
		articulo06.setCantidadDisponible(6000);
		articulo06.setIdDeposito("G12");
		articulo06.setCodigo(106);
		articulo06.setDescripcion("Descripcion 06");
		articulo06.setFecha(day06);
		articulo06.setEdadRecomendada("De 6 meses a 18 meses");
		articulo06.setFoto("Foto 06");
		articulo06.setMarca("Marca 06");
		articulo06.setNombre("Nombre 06");
		articulo06.setOrigen("Origen 06");
		articulo06.setPrecio(6000);
		articulo06.setTipo("Infantil");
		
		articulo05.persistArticulo();
		articulo06.persistArticulo();
		
		// Alta de Moda
		
		ArticuloBean articulo07 = new ArticuloBean();
		articulo07.setCantidadDisponible(7000);
		articulo07.setIdDeposito("G12");
		articulo07.setCodigo(107);
		articulo07.setDescripcion("Descripcion 07");
		articulo07.setFecha(day07);
		articulo07.setColor("Color 07");
		articulo07.setTalle("Talle 07");
		articulo07.setFoto("Foto 07");
		articulo07.setMarca("Marca 07");
		articulo07.setNombre("Nombre 07");
		articulo07.setOrigen("Origen 07");
		articulo07.setPrecio(7000);
		articulo07.setTipo("Moda");
		
		ArticuloBean articulo08 = new ArticuloBean();
		articulo08.setCantidadDisponible(8000);
		articulo08.setIdDeposito("G12");
		articulo08.setCodigo(108);
		articulo08.setDescripcion("Descripcion 08");
		articulo08.setFecha(day08);
		articulo08.setColor("Color 08");
		articulo08.setTalle("Talle 08");
		articulo08.setFoto("Foto 08");
		articulo08.setMarca("Marca 08");
		articulo08.setNombre("Nombre 08");
		articulo08.setOrigen("Origen 08");
		articulo08.setPrecio(8000);
		articulo08.setTipo("Moda");
		
		articulo07.persistArticulo();
		articulo08.persistArticulo();
		
		
		// Recepcion Compra
		
		RecepcionCompraBean recepcionCompra01 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra02 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra03 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra04 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra05 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra06 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra07 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra08 = new RecepcionCompraBean();
		RecepcionCompraBean recepcionCompra09 = new RecepcionCompraBean();
		
		recepcionCompra01.setCodigo(100);
		recepcionCompra02.setCodigo(200);
		recepcionCompra03.setCodigo(300);
		recepcionCompra04.setCodigo(400);
		recepcionCompra05.setCodigo(500);
		recepcionCompra06.setCodigo(600);
		recepcionCompra07.setCodigo(700);
		recepcionCompra08.setCodigo(800);
		recepcionCompra09.setCodigo(900);
		
		recepcionCompra01.persistRecepcionCompra();
		recepcionCompra02.persistRecepcionCompra();
		recepcionCompra03.persistRecepcionCompra();
		recepcionCompra04.persistRecepcionCompra();
		recepcionCompra05.persistRecepcionCompra();
		recepcionCompra06.persistRecepcionCompra();
		recepcionCompra07.persistRecepcionCompra();
		recepcionCompra08.persistRecepcionCompra();
		recepcionCompra09.persistRecepcionCompra();
		
		// ItemRecepcionCompra
		
		ItemRecepcionCompra itemRecepcionCompra01 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra02 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra03 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra04 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra05 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra06 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra07 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra08 = new ItemRecepcionCompra();
		ItemRecepcionCompra itemRecepcionCompra09 = new ItemRecepcionCompra();
		
		itemRecepcionCompra01.setArticulo(articulo01);
		itemRecepcionCompra01.setCantidad(10);
		
		itemRecepcionCompra02.setArticulo(articulo02);
		itemRecepcionCompra02.setCantidad(20);
		
		itemRecepcionCompra03.setArticulo(articulo01);
		itemRecepcionCompra03.setCantidad(30);
		
		itemRecepcionCompra04.setArticulo(articulo04);
		itemRecepcionCompra04.setCantidad(40);
		
		itemRecepcionCompra05.setArticulo(articulo01);
		itemRecepcionCompra05.setCantidad(50);
		
		itemRecepcionCompra06.setArticulo(articulo05);
		itemRecepcionCompra06.setCantidad(60);
		
		itemRecepcionCompra07.setArticulo(articulo03);
		itemRecepcionCompra07.setCantidad(70);
		
		itemRecepcionCompra08.setArticulo(articulo08);
		itemRecepcionCompra08.setCantidad(80);
		
		itemRecepcionCompra09.setArticulo(articulo01);
		itemRecepcionCompra09.setCantidad(90);
				
		itemRecepcionCompra01.persistItemRecepcionCompra();
		itemRecepcionCompra02.persistItemRecepcionCompra();
		itemRecepcionCompra03.persistItemRecepcionCompra();
		itemRecepcionCompra04.persistItemRecepcionCompra();
		itemRecepcionCompra05.persistItemRecepcionCompra();
		itemRecepcionCompra06.persistItemRecepcionCompra();
		itemRecepcionCompra07.persistItemRecepcionCompra();
		itemRecepcionCompra08.persistItemRecepcionCompra();
		itemRecepcionCompra09.persistItemRecepcionCompra();
		
		// Crear Solicitud de Compra
		
		SolicitudCompraBean solicitudCompra01 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra02 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra03 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra04 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra05 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra06 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra07 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra08 = new SolicitudCompraBean();
		SolicitudCompraBean solicitudCompra09 = new SolicitudCompraBean();
		
		solicitudCompra01.setCodigo(10);
		solicitudCompra01.setFechaCreacion(day10);
		solicitudCompra01.setPendiente("Pendiente");
		solicitudCompra01.setRecepcionCompra(recepcionCompra01);
		
		solicitudCompra02.setCodigo(20);
		solicitudCompra02.setFechaCreacion(day10);
		solicitudCompra02.setPendiente("Pendiente");
		solicitudCompra02.setRecepcionCompra(recepcionCompra02);
		
		solicitudCompra03.setCodigo(30);
		solicitudCompra03.setFechaCreacion(day10);
		solicitudCompra03.setPendiente("Pendiente");
		solicitudCompra03.setRecepcionCompra(recepcionCompra01);
		
		solicitudCompra04.setCodigo(40);
		solicitudCompra04.setFechaCreacion(day10);
		solicitudCompra04.setPendiente("Pendiente");
		solicitudCompra04.setRecepcionCompra(recepcionCompra04);
		
		solicitudCompra05.setCodigo(50);
		solicitudCompra05.setFechaCreacion(day10);
		solicitudCompra05.setPendiente("Cancelado");
		solicitudCompra05.setRecepcionCompra(recepcionCompra01);
		
		solicitudCompra06.setCodigo(60);
		solicitudCompra06.setFechaCreacion(day10);
		solicitudCompra06.setPendiente("Pendiente");
		solicitudCompra06.setRecepcionCompra(recepcionCompra05);
		
		solicitudCompra07.setCodigo(70);
		solicitudCompra07.setFechaCreacion(day10);
		solicitudCompra07.setPendiente("Pendiente");
		solicitudCompra07.setRecepcionCompra(recepcionCompra01);
	
		solicitudCompra08.setCodigo(80);
		solicitudCompra08.setFechaCreacion(day10);
		solicitudCompra08.setPendiente("Cancelado");
		solicitudCompra08.setRecepcionCompra(recepcionCompra08);
		
		solicitudCompra09.setCodigo(90);
		solicitudCompra09.setFechaCreacion(day10);
		solicitudCompra09.setPendiente("Pendiente");
		solicitudCompra09.setRecepcionCompra(recepcionCompra09);
		
		solicitudCompra01.persistSolicitudCompra();
		solicitudCompra02.persistSolicitudCompra();
		solicitudCompra03.persistSolicitudCompra();
		solicitudCompra04.persistSolicitudCompra();
		solicitudCompra05.persistSolicitudCompra();
		solicitudCompra06.persistSolicitudCompra();
		solicitudCompra07.persistSolicitudCompra();
		solicitudCompra08.persistSolicitudCompra();
		solicitudCompra09.persistSolicitudCompra();
		
		// Crear Item Solicitud Compra
		
		
		
		
	}
	
}
