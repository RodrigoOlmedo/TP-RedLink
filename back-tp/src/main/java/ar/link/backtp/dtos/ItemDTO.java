package ar.link.backtp.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface ItemDTO {
	int getCantidad();
	@Value("#{target.producto.nombre}")
	String getNombre();
	
	@Value("#{target.producto.image}")
	String getImage();
	
	@Value("#{target.producto.precio}")
	double getPrecio();
	
	@Value("#{target.producto.precio*target.cantidad}")
	double getTotal();
	
	@Value("#{target.producto.idProducto}")
	String getIdProducto();
	
	
	
}
