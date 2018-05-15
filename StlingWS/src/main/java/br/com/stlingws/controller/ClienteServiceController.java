package br.com.stlingws.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.stlingws.entity.Cliente;
import br.com.stlingws.repository.ClienteRepository;

@Path("/clienteService")
public class ClienteServiceController {

	private ClienteRepository repository = null;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/salvar")
	public Boolean salvar(Cliente cliente) throws Exception {
		try {
			repository = new ClienteRepository();
			return repository.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar cliente.");
		}
	}

	@DELETE
	@Produces("application/json")
	@Path("/remover/{id}")
	public Boolean remover(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new ClienteRepository();
			return repository.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao remover cliente.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/listar")
	public List<Cliente> listar() throws Exception {
		try {
			repository = new ClienteRepository();
			return repository.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao listar clientes.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/findById/{id}")
	public Cliente findById(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new ClienteRepository();
			return repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar cliente por id.");
		}
	}
}
