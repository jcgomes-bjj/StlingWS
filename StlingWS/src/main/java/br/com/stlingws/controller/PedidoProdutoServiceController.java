package br.com.stlingws.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.stlingws.entity.PedidoProduto;
import br.com.stlingws.repository.PedidoProdutoRepository;

@Path("/pedidoProdutoService")
public class PedidoProdutoServiceController {

	private PedidoProdutoRepository repository = null;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/salvar")
	public Boolean salvar(PedidoProduto pedidoProduto) throws Exception {
		try {
			repository = new PedidoProdutoRepository();
			return repository.salvar(pedidoProduto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar pedido produto.");
		}
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/salvarItens")
	public Boolean salvarItens(List<PedidoProduto> listItens) throws Exception {
		try {
			repository = new PedidoProdutoRepository();
			return repository.salvarItens(listItens);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar pedido produto.");
		}
	}

	@DELETE
	@Produces("application/json")
	@Path("/remover/{id}")
	public Boolean remover(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new PedidoProdutoRepository();
			return repository.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao remover pedido produto.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/listar")
	public List<PedidoProduto> listar() throws Exception {
		try {
			repository = new PedidoProdutoRepository();
			return repository.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao listar pedido produtos.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/findItensPedido/{id}")
	public List<PedidoProduto> findItensPedido(@PathParam("id") Integer idPedido) throws Exception {
		try {
			repository = new PedidoProdutoRepository();
			return repository.findItensPedido(idPedido);
		} catch (Exception e) {
			throw new Exception("Erro ao listar pedido produtos.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/findById/{id}")
	public PedidoProduto findById(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new PedidoProdutoRepository();
			return repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar pedido produto por id.");
		}
	}
}
