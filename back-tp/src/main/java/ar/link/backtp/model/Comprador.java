package ar.link.backtp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Comprador extends Rol {
	@OneToMany
	private Collection<OrdenDeCompra> comprasRealizadas;
	public Comprador() {
		super();
	}
	public Comprador(String nombre, String apellido, String telefono, String email)  {
		super(nombre, apellido, telefono, email);
		
		this.comprasRealizadas = new ArrayList<OrdenDeCompra>();
	}
	
	public Collection<OrdenDeCompra> getComprasRealizadas() {
		return comprasRealizadas;
	}

	public void setComprasRealizadas(Collection<OrdenDeCompra> comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}

	public void registrarCompra(OrdenDeCompra ordenARegistrar){
		comprasRealizadas.add(ordenARegistrar);
	}
		
}
/**/
