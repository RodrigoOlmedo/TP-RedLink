package ar.link.backtp.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.link.backtp.dtos.ItemDTO;
import ar.link.backtp.model.ItemCarrito;

@RepositoryRestResource(path="itemsCarrito", excerptProjection = ItemDTO.class)
public interface RepoItemCarrito extends PagingAndSortingRepository<ItemCarrito, Integer> {

}
