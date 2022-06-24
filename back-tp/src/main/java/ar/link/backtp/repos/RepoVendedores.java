package ar.link.backtp.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.model.Vendedor;

@RepositoryRestResource(path="vendedores")
public interface RepoVendedores extends PagingAndSortingRepository<Vendedor, Integer> {

}