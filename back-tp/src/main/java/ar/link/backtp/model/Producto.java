package ar.link.backtp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Producto {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProducto;
	@ManyToOne
	private Vendedor vendedor;
	private String nombre;
	private double precio;
	private String descripcion;
	private int stock;
	private	int stockMinimo;
	
	public Producto(Vendedor vendedor, String nombre, double precio, String descripcion, int stock,int stockMinimo) {
		super();
		this.vendedor = vendedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.stockMinimo=stockMinimo;
	}
	
	//getters y setters 
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	//funciones
	public void verificarStock(Integer cantidad) {
		if(cantidad>stock){
			//throw new NoHayStockException();
		}
	}
	public void venderse(Integer cantidad) {
		this.setStock(stock-cantidad);
		if(stock<stockMinimo) {
			vendedor.recibirAvisoDeFaltaStock();
			//puede ser notificacion.avisoFaltaStock();
		}
	}
	

}
