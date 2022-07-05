package ar.link.backtp.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;
import ar.link.backtp.model.ItemCarrito;
import ar.link.backtp.model.OrdenDeCompra;
import ar.link.backtp.model.Producto;
import ar.link.backtp.repos.RepoComprador;
import ar.link.backtp.repos.RepoOrdenDeCompra;

@RestController
@RequestMapping("")
public class OrdenController {
	@Autowired
	private RepoOrdenDeCompra repoOrders;
	
	@Autowired
	private RepoComprador repoComprador;
	

}
