package ar.link.backtp.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;
import ar.link.backtp.repos.RepoCarritoDeCompra;
import ar.link.backtp.repos.RepoComprador;

@RestController
@RequestMapping("")
public class CompradorController {
	@Autowired
	private RepoComprador repoComprador;
	
	@Autowired
	private RepoCarritoDeCompra repoCarrito;
	
	@Transactional
	@PostMapping("/create")
	public void guardar(@RequestBody Comprador comprador) {
		CarritoDeCompras carrito = new CarritoDeCompras(comprador);
		repoCarrito.save(carrito);
		repoComprador.save(comprador);
		
	}
	@GetMapping("compradores/{id}/carrito")
	public CarritoDeCompras getCarrito(@PathVariable("id") Integer compradorId) {
		Optional<Comprador> compradorOpc= repoComprador.findById(compradorId);
		Comprador comprador = compradorOpc.get();
		Optional<CarritoDeCompras> carritoOpc = repoCarrito.findByComprador(comprador);
		CarritoDeCompras carrito = carritoOpc.get();
		return carrito;
	}	
	@GetMapping("/hola")
	public String getCarrito() {
		System.out.print("hola");
		return "skr";
	}
}
