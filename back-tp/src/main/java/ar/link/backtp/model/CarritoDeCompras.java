package ar.link.backtp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarritoDeCompras {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCarrito;
	@OneToMany
	private Collection<ItemCarrito> productosAComprar;
	@OneToOne
	private Comprador comprador; 
	public CarritoDeCompras() {
		super();
	}
	public CarritoDeCompras(Comprador comprador) {
		this.productosAComprar = new ArrayList<ItemCarrito>();
		this.comprador = comprador; 
	}
	
	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	//Funciones
	public void agregarItem(ItemCarrito itemARegistrar) {;
		this.productosAComprar.add(itemARegistrar);
	}
	public double calcularTotal(){
		return productosAComprar.stream().mapToDouble((item)->item.precioTotalItem()).sum();
	}
	public void comprarse() {
		this.registrarVentaDeProductos();
	}
	//reduce el stock de cada producto del carrito
	private void registrarVentaDeProductos() {
		productosAComprar.stream().forEach((item)->item.venderse());
	}

}
