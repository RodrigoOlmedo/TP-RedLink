package ar.link.backtp.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
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


@RepositoryRestController
public class UsuarioController {
	
	@Autowired
	private RepoUsuario repo;
	
	
	@Transactional
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
