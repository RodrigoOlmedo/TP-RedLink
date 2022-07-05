package ar.link.backtp.dtos;

import org.springframework.beans.factory.annotation.Value;


public interface UsuarioDTO {
	
	@Value("#{target.rol.rol}")
	String getTipoDeRol();
	
	@Value("#{target.rol.id}")
	Integer getId();
	
	@Value("#{target.rol.nombre}")
	String getNombre();
}
