package br.com.stlingws.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.stlingws.entity.Pedido;
import br.com.stlingws.repository.PedidoRepository;

@Path("/pedidoService")
public class PedidoServiceController {

	private PedidoRepository repository = null;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/salvar")
	public Response salvar(Pedido pedido) throws Exception {
		try {
			repository = new PedidoRepository();
			Pedido retorno = repository.salvar(pedido);
			return Response.status(201).entity(retorno).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar pedido." + e.getMessage());
		}
	}

	@DELETE
	@Produces("application/json")
	@Path("/remover/{id}")
	public Boolean remover(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new PedidoRepository();
			return repository.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao remover pedido." + e.getMessage());
		}
	}

	@GET
	@Produces("application/json")
	@Path("/listar")
	public List<Pedido> listar() throws Exception {
		try {
			repository = new PedidoRepository();
			return repository.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao listar pedidos." + e.getMessage());
		}
	}

	@GET
	@Produces("application/json")
	@Path("/findById/{id}")
	public Pedido findById(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new PedidoRepository();
			return repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar pedido por id." + e.getMessage());
		}
	}
}
