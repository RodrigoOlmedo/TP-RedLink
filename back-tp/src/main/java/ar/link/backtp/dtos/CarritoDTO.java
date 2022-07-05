package ar.link.backtp.dtos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import ar.link.backtp.model.ItemCarrito;

public interface CarritoDTO {
	Integer getIdCarrito();
	@Value("#{target.productosAComprar}")
	Collection<ItemDTO> getItems();/*
	@Value("#{target.productosAComprar}")
	Collection<ItemDTO> getItems();*/
	
	

}
