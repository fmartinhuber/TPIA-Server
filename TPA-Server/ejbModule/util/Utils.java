package util;

import java.util.List;
import java.util.stream.Collectors;

import bean.ArticuloBean;
import bean.ItemSolicitudArticuloBean;
import bean.ItemSolicitudCompraBean;
import bean.SolicitudArticuloBean;
import dto.ItemSolicitudArticuloDTO;
import dto.ItemSolicitudCompraDTO;
import dto.SolicitudArticuloDTO;

/**
 * Bienvenidos a Java 1.8
 * 
 * Para los que lleguen aca y no sepan que hacer...
 * 1. Stream es una coleccion (en este caso una list)
 * 2. Mapeo 1 a 1 todo lo de la lista convitiendolo
 * 3. Por ultimo el collect solo crea la coleccion (list)
 * 
 * @author martinh
 *
 */
public class Utils {

	public static List <SolicitudArticuloDTO> solicitudArticuloBeanToDTO (List <SolicitudArticuloBean> articuloBeans){
		return articuloBeans.stream()
				.map(a -> new SolicitudArticuloDTO(a.getCodigo(),a.getEstado(),a.getFechaEntrega(),a.getIdModulo(),itemSolicitudArticuloBeanToDTO(a.getItemsSolicitudArticulo())))
				.collect(Collectors.<SolicitudArticuloDTO>toList());
	}
	
	public static List <ItemSolicitudArticuloDTO> itemSolicitudArticuloBeanToDTO (List <ItemSolicitudArticuloBean> itemSolicitudArticuloBeans){
		return itemSolicitudArticuloBeans.stream()
				.map(a -> new ItemSolicitudArticuloDTO(a.getArticulo().aArticuloDTO(),a.getCantidad()))
				.collect(Collectors.<ItemSolicitudArticuloDTO>toList());
	}
	
//	public static List <SolicitudArticuloBean> solicitudArticuloDTOToBean (List <SolicitudArticuloDTO> articuloDTOs){
//		return articuloDTOs.stream()
//				.map(a -> new SolicitudArticuloBean(a.getCodigo(),a.getEstado(),a.getFechaEntrega(),a.getIdModulo(),itemSolicitudArticuloDTOToBean(a.getItemsSolicitudArticulo())))
//				.collect(Collectors.<SolicitudArticuloBean>toList());
//	}
	
	public static List <ItemSolicitudArticuloBean> itemSolicitudArticuloDTOToBean (List <ItemSolicitudArticuloDTO> itemSolicitudArticuloBeans){
		return itemSolicitudArticuloBeans.stream()
				.map(a -> new ItemSolicitudArticuloBean(new ArticuloBean(),a.getCantidad()))
				.collect(Collectors.<ItemSolicitudArticuloBean>toList());
	}
	
//	public static List <ItemSolicitudCompraBean> itemSolicitudCompraDTOToBean (List <ItemSolicitudCompraDTO> itemSolicitudCompraBeans){
//		return itemSolicitudCompraBeans.stream()
//				.map(a -> new ItemSolicitudCompraBean(new ArticuloBean(),a.getCantidad()))
//				.collect(Collectors.<ItemSolicitudCompraBean>toList());
//	}
	
}
