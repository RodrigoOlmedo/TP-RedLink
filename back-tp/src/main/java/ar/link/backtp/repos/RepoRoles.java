package ar.link.backtp.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.model.Rol;

@RepositoryRestResource(path="roles")
public interface RepoRoles extends PagingAndSortingRepository<Rol, Integer> {

}
