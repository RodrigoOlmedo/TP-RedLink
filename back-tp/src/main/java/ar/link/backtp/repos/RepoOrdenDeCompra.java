package ar.link.backtp.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.model.OrdenDeCompra;

@RepositoryRestResource(path="ordenesDeCompra")
public interface RepoOrdenDeCompra extends PagingAndSortingRepository<OrdenDeCompra, Integer> {

}
