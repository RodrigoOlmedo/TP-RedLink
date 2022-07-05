package ar.link.backtp.repos;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.dtos.CarritoDTO;
import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;

@RepositoryRestResource(path="Carritos", excerptProjection = CarritoDTO.class)
public interface RepoCarritoDeCompra extends PagingAndSortingRepository<CarritoDeCompras, Integer> {

	Optional<CarritoDTO> findByComprador(Comprador comprador);

}
