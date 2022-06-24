package ar.link.backtp.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;
import ar.link.backtp.model.ItemCarrito;
import ar.link.backtp.model.Producto;
import ar.link.backtp.repos.RepoCarritoDeCompra;
import ar.link.backtp.repos.RepoComprador;

@RepositoryRestController
public class ControllerCarrito {
	
	@Autowired
	private RepoCarritoDeCompra repoCarrito;
	@Autowired
	private RepoComprador repoComprador;
	
	@GetMapping("compradores/{compradorId}/carritoDeCompras")
	public CarritoDeCompras get(@PathVariable("compradorId") Integer compradorId) {
		
		Optional<Comprador> compradorOpc= repoComprador.findById(compradorId);
		
		Comprador comprador = compradorOpc.get();
		
		Optional<CarritoDeCompras> opcionalCarrito= repoCarrito.findByComprador(comprador);
		
		CarritoDeCompras carritoDeCompra=opcionalCarrito.get();
		
		return carritoDeCompra;
	}
	
}
