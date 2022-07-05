package ar.link.backtp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import ar.link.backtp.model.CarritoDeCompras;
import ar.link.backtp.model.Comprador;
import ar.link.backtp.model.Producto;
import ar.link.backtp.model.Usuario;
import ar.link.backtp.model.Vendedor;
import ar.link.backtp.repos.RepoCarritoDeCompra;
import ar.link.backtp.repos.RepoComprador;
import ar.link.backtp.repos.RepoProducto;
import ar.link.backtp.repos.RepoUsuario;
import ar.link.backtp.repos.RepoVendedores;

@Component
public class InitData implements CommandLineRunner {
	
	@Autowired
	private RepoVendedores repoVend;
	@Autowired
	private RepoComprador repoComp;
	@Autowired
	private RepoProducto repoProd;
	@Autowired
	private RepoUsuario repoUser;
	@Autowired
	private RepoCarritoDeCompra repoCarrito;
	@Autowired
	private RepositoryRestConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		
		config.exposeIdsFor(Usuario.class, Producto.class,Comprador.class);

		//Creacion de compradores
		Comprador comprador1 = new Comprador("Rodrigo","Olmedo","11-xxxx-xxxx","rodrigomolmedo1@gmail.com");
		repoComp.save(comprador1);

		//Creacion de vendedores
		Vendedor vendedor1 = new Vendedor("Ezequiel","Escobar","11-xxxx-xxxx","EEscobar@gmail.com");
		Vendedor vendedor2 = new Vendedor("Ezequiel","Sosa","11-xxxx-xxxx","ESosa@gmail.com");
		repoVend.save(vendedor1);
		repoVend.save(vendedor2);
		
		//Creacion de usuario
		Usuario usuario1 = new Usuario("comp", "comp",comprador1);
		Usuario usuario2 = new Usuario("vend", "vend",vendedor1);
		Usuario usuario3 = new Usuario("vend2","vend2",vendedor2);
		List<Usuario> usuarios = Arrays.asList(
				usuario1,
				usuario2,
				usuario3
				);
		
		usuarios.stream().forEach(usuario->{
			repoUser.save(usuario);
		});
		
		
		//Creacion de productos
		Producto producto1 = new Producto(vendedor1,"Mate Aromandise Madera", "Mate de madera aromandise con borde de metal", 650.00f, "https://m.media-amazon.com/images/I/41udhoeOV8L._AC_.jpg", 10, 2);
		Producto producto2 = new Producto(vendedor2,"Sony Google TV", "Televisor 60' Google TV Sony Negro", 250400.00f, "https://www.sony.com.ar/image/4ea841c42d23e79595504427d55b990e?fmt=pjpeg&wid=1014&hei=396&bgcolor=F1F5F9&bgc=F1F5F9", 5, 1);
		Producto producto3 = new Producto(vendedor1,"Escritorio L Melamina", "Escritorio en L con espacio para cpu y 2 cajoneras", 16700.00f, "https://http2.mlstatic.com/D_NQ_NP_714847-MLA42433229044_072020-W.jpg", 0, 1);
		Producto producto4 = new Producto(vendedor2,"Cable+Fuente Cargador Iphone", "Cargador de Iphone, fuente y cable originales", 5200.00f, "https://http2.mlstatic.com/D_NQ_NP_742776-MLA49195949278_022022-O.jpg", 20, 5);
		Producto producto5 = new Producto(vendedor1,"Zapatillas Puma RS-X3", "Zapatillas Puma RS-X3 Blancas", 30500.00f, "https://www.moov.com.ar/on/demandware.static/-/Sites-dabra-catalog/default/dw4144eb30/products/PU_373308-01/PU_373308-01-1.JPG", 8, 1);
		List<Producto> productos = Arrays.asList(producto1,producto2,producto3,producto4,producto5);
		
		productos.stream().forEach(producto->{
			repoProd.save(producto);
		});
		
		//Creacion del carrito
		CarritoDeCompras carritoComp1 = new CarritoDeCompras(comprador1);
		repoCarrito.save(carritoComp1);
		
	}			
		
		

}
