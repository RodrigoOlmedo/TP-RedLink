package ar.link.backtp.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.link.backtp.dtos.CarritoDTO;
import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;
import ar.link.backtp.model.OrdenDeCompra;
import ar.link.backtp.repos.RepoCarritoDeCompra;
import ar.link.backtp.repos.RepoComprador;
import ar.link.backtp.repos.RepoOrdenDeCompra;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/clientes")
public class CompradorController {
	@Autowired
	private RepoComprador repoComprador;
	@Autowired
	private RepoCarritoDeCompra repoCarrito;
	@Autowired 
	private RepoOrdenDeCompra repoOrdenes;
	
	@Transactional					
	@PostMapping("/{compradorId}/ordenes")
	public void finalizarCompra(@PathVariable("compradorId") Integer compradorId){
		
		Optional<Comprador> opcComprador= repoComprador.findById(compradorId);
		Comprador comprador= opcComprador.get();
		
		Optional<CarritoDTO> opcCarritoDTO= repoCarrito.findByComprador(comprador);
		CarritoDTO falsoCarrito=opcCarritoDTO.get();
		Optional<CarritoDeCompras> opcCarrito =repoCarrito.findById(falsoCarrito.getIdCarrito());
		CarritoDeCompras carrito=opcCarrito.get();
		
		OrdenDeCompra ordenDeCompra=new OrdenDeCompra(carrito.getProductosAComprar(),carrito.precioFinal());
		carrito.comprarse();
		comprador.registrarCompra(ordenDeCompra);
		
		repoOrdenes.save(ordenDeCompra);
		repoComprador.save(comprador);
		repoCarrito.save(carrito);
		
	}
}
