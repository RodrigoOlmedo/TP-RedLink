package ar.link.backtp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCarrito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCarrito;
	@ManyToOne
	private Producto producto;
	private int cantidad;
	private double precio;
	

	public ItemCarrito() {
		super();
	}
	public ItemCarrito(Producto producto, int cantidad, double precio) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public double precioTotalItem() {
		return precio*cantidad;
	}
	public void venderse() {
		producto.venderse(cantidad);
	}
}
