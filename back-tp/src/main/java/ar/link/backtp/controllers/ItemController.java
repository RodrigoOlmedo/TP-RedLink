package ar.link.backtp.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;
import ar.link.backtp.model.ItemCarrito;
import ar.link.backtp.model.Producto;
import ar.link.backtp.repos.RepoCarritoDeCompra;
import ar.link.backtp.repos.RepoItemCarrito;

@RestController
@RequestMapping("")
public class ItemController {

/*	@Autowired
	private RepoItemCarrito repoItems;
	
	@Autowired
	private RepoCarritoDeCompra repoCarrito;
	

	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="carrito/{carritoId}/items")
	public @ResponseBody void agregarItem(@PathVariable("carritoId") Integer carritoId, @RequestBody Producto producto, int cantidad){
		producto.verificarStock(cantidad);
		Optional<CarritoDeCompras> carritoOpc= repoCarrito.findById(carritoId);
		CarritoDeCompras carrito = carritoOpc.get();
		ItemCarrito itemNuevo=new ItemCarrito(producto,cantidad,producto.getPrecio());
		carrito.agregarItem(itemNuevo);
		repoItems.save(itemNuevo);
		repoCarrito.save(carrito);
	}*/
}
