package ar.link.backtp.repos;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;

@RepositoryRestResource(path="CarritosDeCompras")
public interface RepoCarritoDeCompra extends PagingAndSortingRepository<CarritoDeCompras, Integer> {

	Optional<CarritoDeCompras> findByComprador(Comprador comprador);

}
