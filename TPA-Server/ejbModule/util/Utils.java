package util;

import java.util.List;
import java.util.stream.Collectors;

import bean.ItemSolicitudArticuloBean;
import bean.SolicitudArticuloBean;
import dto.ItemSolicitudArticuloDTO;
import dto.SolicitudArticuloDTO;

public class Utils {

	public static List <SolicitudArticuloDTO> solicitudArticuloBeanToDTO (List <SolicitudArticuloBean> articuloBeans){
		return articuloBeans.stream()
				.map(a -> new SolicitudArticuloDTO(a.getCodigo(),a.getEstado(),a.getFechaEntrega(),a.getIdModulo()))
				.collect(Collectors.<SolicitudArticuloDTO>toList());
	}
	
	public static List <ItemSolicitudArticuloDTO> itemSolicitudArticuloBeanToDTO (List <ItemSolicitudArticuloBean> itemSolicitudArticuloBeans){
		return itemSolicitudArticuloBeans.stream()
				.map(a -> new ItemSolicitudArticuloDTO(a.getArticulo().aArticuloDTO(),a.getCantidad()))
				.collect(Collectors.<ItemSolicitudArticuloDTO>toList());
	}
}
