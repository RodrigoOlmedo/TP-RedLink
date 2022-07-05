package ar.link.backtp.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.link.backtp.dtos.CarritoDTO;
import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;
import ar.link.backtp.model.ItemCarrito;
import ar.link.backtp.model.Producto;
import ar.link.backtp.repos.RepoCarritoDeCompra;
import ar.link.backtp.repos.RepoComprador;
import ar.link.backtp.repos.RepoItemCarrito;
import ar.link.backtp.repos.RepoProducto;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/carrito")
public class ControllerCarrito {
	
	@Autowired
	private RepoCarritoDeCompra repoCarrito;
	@Autowired
	private RepoItemCarrito repoItems;
	@Autowired
	private RepoComprador repoComprador;
	@Autowired
	private RepoProducto repoProducto;
	
	@GetMapping("/cliente/{compradorId}")
	public CarritoDTO get(@PathVariable("compradorId") Integer compradorId) {
		
		Optional<Comprador> compradorOpc= repoComprador.findById(compradorId);
		Comprador comprador = compradorOpc.get();
		
		Optional<CarritoDTO> opcionalCarrito= repoCarrito.findByComprador(comprador);
		CarritoDTO carritoDeCompra=opcionalCarrito.get();
		
		return carritoDeCompra;
	}
	
	@Transactional
	@PostMapping("/cliente/{compradorId}/{productoId}/{cantidad}")
	public void agregarItem(@PathVariable("compradorId") Integer compradorId,@PathVariable("cantidad") int cantidad, @PathVariable("productoId") Integer productoId){
		
		System.out.println(productoId);
		Optional<Producto> productoOpc= repoProducto.findById(productoId);
		Producto producto = productoOpc.get();
		Optional<Comprador> compradorOpc= repoComprador.findById(compradorId);
		Comprador comprador = compradorOpc.get();
		Optional<CarritoDTO> opcCarritoDTO= repoCarrito.findByComprador(comprador);
		CarritoDTO falsoCarrito=opcCarritoDTO.get();
		Optional<CarritoDeCompras> opcCarrito =repoCarrito.findById(falsoCarrito.getIdCarrito());
		CarritoDeCompras carritoDeCompra=opcCarrito.get();
		ItemCarrito itemNuevo = new ItemCarrito(producto, cantidad, producto.getPrecio());
		repoItems.save(itemNuevo);
		carritoDeCompra.agregarItem(itemNuevo);
		repoCarrito.save(carritoDeCompra);
	}
	
}
