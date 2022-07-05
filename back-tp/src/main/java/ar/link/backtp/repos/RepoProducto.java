package ar.link.backtp.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.link.backtp.model.Producto;

@CrossOrigin(origins = "http://localhost:4200/")
@RepositoryRestResource(path="productos")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {

}
