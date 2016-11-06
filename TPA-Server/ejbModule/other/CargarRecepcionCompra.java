package other;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import bean.ItemRecepcionCompra;
import bean.RecepcionCompraBean;

public class CargarRecepcionCompra {

	private static CargarRecepcionCompra instancia;
	
	public static CargarRecepcionCompra getInstancia(){
		if(instancia==null)
			instancia = new CargarRecepcionCompra();
		return instancia;
	}
	
	public void cargaDeDatos(){
		
		// Seteo de Fechas
		
		Calendar cal01 = GregorianCalendar.getInstance(); 	cal01.add(Calendar.DAY_OF_YEAR, -1);	Date day01 = cal01.getTime();	cal01.add(Calendar.MONTH, 1); 	Date day06 = cal01.getTime();			Calendar cal02 = GregorianCalendar.getInstance();	cal02.add(Calendar.DAY_OF_YEAR, -5);	Date day02 = cal02.getTime();	cal02.add(Calendar.MONTH, 1); 	Date day07 = cal02.getTime();
		Calendar cal03 = GregorianCalendar.getInstance();	cal03.add(Calendar.DAY_OF_YEAR, -13);	Date day03 = cal03.getTime();	cal03.add(Calendar.MONTH, 1); 	Date day08 = cal03.getTime();
		Calendar cal04 = GregorianCalendar.getInstance();	cal04.add(Calendar.DAY_OF_YEAR, -27);	Date day04 = cal04.getTime();	cal04.add(Calendar.MONTH, 1); 	Date day09 = cal04.getTime();
		Calendar cal05 = GregorianCalendar.getInstance();	cal05.add(Calendar.DAY_OF_YEAR, -31);	Date day05 = cal05.getTime();	cal05.add(Calendar.MONTH, 1); 	Date day10 = cal05.getTime();
				
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
		
//		itemRecepcionCompra01.setArticulo(1);
		
		
	}
	
	
}
