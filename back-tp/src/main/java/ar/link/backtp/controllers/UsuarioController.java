package ar.link.backtp.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.link.backtp.model.Usuario;
import ar.link.backtp.model.UsuarioRepetidoException;
import ar.link.backtp.repos.RepoUsuario;

//@RestController
//@RequestMapping("/usuarios")
public class UsuarioController {
	
	//@Autowired
	private RepoUsuario repo;
	/*
	@GetMapping("")
	public Page<Usuario> get(@RequestParam(value = "user", required = false) String user, Pageable page){
		if(user==null) {
			return repo.findAll(page);
		}
		else {
			return repo.findByUser(user,page); 
		}
	}
	
	@GetMapping("/{user}") //no funciona porque no devuelve un unico registro, id user? user unico? 
	public Usuario get(@PathVariable("user") String user) {
		return repo.findByUser(user);
	}
	/*
	@Transactional*/
	@PostMapping("")
	public String post(@RequestBody @Valid Usuario usuario,			
			BindingResult bindingResult) throws UsuarioRepetidoException {
		if(!bindingResult.hasErrors()) {
			repo.save(usuario);
			return "ok";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "no ok, con errores";
		}
		

	}
}
