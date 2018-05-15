package br.com.stlingws.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.stlingws.entity.Usuario;
import br.com.stlingws.repository.UsuarioRepository;

@Path("/usuarioService")
public class UsuarioServiceController {

	private UsuarioRepository repository = null;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/salvar")
	public Boolean salvar(Usuario usuario) throws Exception {
		try {
			repository = new UsuarioRepository();
			return repository.salvar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar usuario.");
		}
	}

	@DELETE
	@Produces("application/json")
	@Path("/remover/{id}")
	public Boolean remover(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new UsuarioRepository();
			return repository.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao remover usuario.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/listar")
	public List<Usuario> listar() throws Exception {
		try {
			repository = new UsuarioRepository();
			return repository.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao listar usuarios.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/findById/{id}")
	public Usuario findById(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new UsuarioRepository();
			return repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar usuario por id.");
		}
	}
	
	@POST
	@Produces("application/json")
	@Path("/findById/{id}")
	public Usuario findByEmail(String email) throws Exception {
		try {
			repository = new UsuarioRepository();
			return repository.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar usuario por email!");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/listarVendedores")
	public List<Usuario> listarVenderores() throws Exception {
		try {
			repository = new UsuarioRepository();
			return repository.listarVenderores();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar vendedores!");
		}
	}
}
