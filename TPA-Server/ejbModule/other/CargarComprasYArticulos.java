package other;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import bean.SolicitudCompraBean;

public class CargarComprasYArticulos {

	
	private static CargarComprasYArticulos instancia;
	
	public static CargarComprasYArticulos getInstancia(){
		if(instancia==null)
			instancia = new CargarComprasYArticulos();
		return instancia;
	}
	
	public void cargaDatos(){
		
		// Seteo de Fechas
		
		Calendar cal01 = GregorianCalendar.getInstance(); 	cal01.add(Calendar.DAY_OF_YEAR, -1);	Date day01 = cal01.getTime();	cal01.add(Calendar.MONTH, 1); 	Date day06 = cal01.getTime();
		Calendar cal02 = GregorianCalendar.getInstance();	cal02.add(Calendar.DAY_OF_YEAR, -5);	Date day02 = cal02.getTime();	cal02.add(Calendar.MONTH, 1); 	Date day07 = cal02.getTime();
		Calendar cal03 = GregorianCalendar.getInstance();	cal03.add(Calendar.DAY_OF_YEAR, -13);	Date day03 = cal03.getTime();	cal03.add(Calendar.MONTH, 1); 	Date day08 = cal03.getTime();
		Calendar cal04 = GregorianCalendar.getInstance();	cal04.add(Calendar.DAY_OF_YEAR, -27);	Date day04 = cal04.getTime();	cal04.add(Calendar.MONTH, 1); 	Date day09 = cal04.getTime();
		Calendar cal05 = GregorianCalendar.getInstance();	cal05.add(Calendar.DAY_OF_YEAR, -31);	Date day05 = cal05.getTime();	cal05.add(Calendar.MONTH, 1); 	Date day10 = cal05.getTime();
		
		// Solicitud Compra
		
		SolicitudCompraBean solicitudCompra01 = new SolicitudCompraBean();
		solicitudCompra01.setCodigo(100);
		solicitudCompra01.setFechaCreacion(day10);
		solicitudCompra01.setPendiente("Pendiente");
		
		solicitudCompra01.persistSolicitudCompra();
		
		
	}
	
}
