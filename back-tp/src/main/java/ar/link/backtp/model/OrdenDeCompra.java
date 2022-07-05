package ar.link.backtp.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class OrdenDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOrden;
	private LocalDate fecha;
	private double total;
	@OneToMany
	private Collection<ItemCarrito> productosComprados;
	
	protected OrdenDeCompra() {
		super();
	}
	public OrdenDeCompra(Collection<ItemCarrito> productos,double total) {
		this.setFecha(LocalDate.now());
		this.setProductosComprados(productos);
		this.total=total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Collection<ItemCarrito> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(Collection<ItemCarrito> productosComprados) {
		this.productosComprados = productosComprados;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
