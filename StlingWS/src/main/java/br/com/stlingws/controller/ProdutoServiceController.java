package br.com.stlingws.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.stlingws.entity.Produto;
import br.com.stlingws.repository.ProdutoRepository;

@Path("/produtoService")
public class ProdutoServiceController {

	private ProdutoRepository repository = null;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/salvar")
	public Boolean salvar(Produto produto) throws Exception {
		try {
			repository = new ProdutoRepository();
			return repository.salvar(produto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao salvar produto.");
		}
	}

	@DELETE
	@Produces("application/json")
	@Path("/remover/{id}")
	public Boolean remover(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new ProdutoRepository();
			return repository.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao remover produto.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/listar")
	public List<Produto> listar() throws Exception {
		try {
			repository = new ProdutoRepository();
			return repository.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao listar produtos.");
		}
	}

	@GET
	@Produces("application/json")
	@Path("/findById/{id}")
	public Produto findById(@PathParam("id") Integer id) throws Exception {
		try {
			repository = new ProdutoRepository();
			return repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar produto por id.");
		}
	}
}
