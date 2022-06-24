package ar.link.backtp.repos;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.model.Usuario;

@RepositoryRestResource(path="usuarios")
public interface RepoUsuario extends PagingAndSortingRepository<Usuario, Integer> {
	
}
