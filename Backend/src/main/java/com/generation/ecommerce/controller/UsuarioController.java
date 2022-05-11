package com.generation.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.generation.ecommerce.model.Usuario;
import com.generation.ecommerce.model.UsuarioLogin;
import com.generation.ecommerce.repository.UsuarioRepository;
import com.generation.ecommerce.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/all")
	public ResponseEntity <List<Usuario>> getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getByTitulo(@PathVariable Long id){
		return usuarioRepository.findById(id)
		.map(resposta -> ResponseEntity.ok(resposta))//função lambda
		.orElse(ResponseEntity.notFound().build());
		
	}
	@PostMapping("/cadastrar")
	public ResponseEntity <Usuario> postUsuario(@Valid@RequestBody Usuario usuario){
		return usuarioService.cadastrarUsuario(usuario)
		.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))//função lambda
		.orElse(ResponseEntity.badRequest().build());
		
	}
	@PutMapping("/atualizar")
	public ResponseEntity <Usuario> putUsuario(@Valid@RequestBody Usuario usuario){
		return usuarioService.atualizarUsuario(usuario)
		.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))//função lambda
		.orElse(ResponseEntity.notFound().build());
		
	}
	@PostMapping("/logar")
	public ResponseEntity <UsuarioLogin> loginUsuario(@RequestBody Optional<UsuarioLogin> usuarioLogin){
		return usuarioService.autenticarUsuario(usuarioLogin)
		.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))//função lambda
		.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
}
