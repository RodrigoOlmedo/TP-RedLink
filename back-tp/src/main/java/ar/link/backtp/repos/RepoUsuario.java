package ar.link.backtp.repos;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.link.backtp.dtos.UsuarioDTO;
import ar.link.backtp.model.Usuario;

@CrossOrigin(origins="http://localhost:4200/")
@RepositoryRestResource(path="usuarios", excerptProjection= UsuarioDTO.class)
public interface RepoUsuario extends PagingAndSortingRepository<Usuario, Integer> {
	@RestResource(path = "usuario")
	Optional<UsuarioDTO> findByUserAndPassword(String usuario, String contrasenia);
}
