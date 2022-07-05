package ar.link.backtp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Vendedor extends Rol{
	
	@OneToMany(mappedBy = "vendedor")
	//@JoinColumn(name = "vendedor_id")
	private Collection<Producto> productosQueVende;
	private String rol="vendedor";
	public Vendedor() {
		super();
	}
	public Vendedor(String nombre, String apellido, String telefono, String email) {
		super(nombre, apellido, telefono, email);
		this.productosQueVende=new ArrayList<Producto>();
		
	}
	public Collection<Producto> getProductosQueVende() {
		return productosQueVende;
	}
	
	public void setProductosQueVende(Collection<Producto> productosQueVende) {
		this.productosQueVende = productosQueVende;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	public String recibirAvisoDeFaltaStock() {
		return "El stock esta por debajo de la cantidad minima esperada";
		
	}
	
}
