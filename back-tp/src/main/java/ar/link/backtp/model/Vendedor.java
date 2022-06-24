package ar.link.backtp.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Vendedor extends Rol{
	
	@OneToMany
	@JoinColumn(name = "vendedor_id")
	private Collection<Producto> productosQueVende;
	
	public Vendedor() {
		super();
	}
	public Vendedor(String nombre, String apellido, String telefono, String email,Collection<Producto> productos) {
		super(nombre, apellido, telefono, email);
		this.productosQueVende=productos;
		
	}
	public Collection<Producto> getProductosQueVende() {
		return productosQueVende;
	}
	
	public void setProductosQueVende(Collection<Producto> productosQueVende) {
		this.productosQueVende = productosQueVende;
	}

	public String recibirAvisoDeFaltaStock() {
		return "El stock esta por debajo de la cantidad minima esperada";
		
	}

}
