package ar.link.backtp.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.model.Comprador;

@RepositoryRestResource(path="compradores")
public interface RepoComprador extends PagingAndSortingRepository<Comprador, Integer> {

}
