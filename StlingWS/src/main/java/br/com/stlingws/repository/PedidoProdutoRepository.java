/**
 * 
 */
package br.com.stlingws.repository;

import java.util.List;

import br.com.stlingws.dao.PedidoDAO;
import br.com.stlingws.dao.PedidoProdutoDAO;
import br.com.stlingws.entity.PedidoProduto;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class PedidoProdutoRepository {

	private PedidoProdutoDAO pedidoProdutoDAO = PedidoProdutoDAO.getInstance();

	public Boolean salvar(PedidoProduto pedidoProduto) throws Exception {
		try {
			pedidoProdutoDAO.init();
			Boolean retorno = pedidoProdutoDAO.salvar(pedidoProduto);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			this.pedidoProdutoDAO.rollBack();
			throw new Exception("Erro ao salvar pedidoProduto!");
		} finally {
			pedidoProdutoDAO.end();
		}
	}

	public Boolean salvarItens(List<PedidoProduto> listItens) throws Exception {
		try {
			pedidoProdutoDAO.init();
			Boolean retorno = pedidoProdutoDAO.salvarItens(listItens);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			this.pedidoProdutoDAO.rollBack();
			throw new Exception("Erro ao salvar itens PedidoProduto!");
		} finally {
			pedidoProdutoDAO.end();
		}
	}

	public Boolean remover(Integer id) throws Exception {
		try {
			pedidoProdutoDAO.init();
			Boolean retorno = pedidoProdutoDAO.remover(id);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			this.pedidoProdutoDAO.rollBack();
			throw new Exception("Erro ao remover pedidoProduto!");
		} finally {
			pedidoProdutoDAO.end();
		}
	}

	public List<PedidoProduto> listar() throws Exception {
		try {
			return pedidoProdutoDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao listar pedidoProdutos!");
		}
	}

	public List<PedidoProduto> findItensPedido(Integer idPedido) throws Exception {
		try {
			PedidoDAO pedidoDAO = new PedidoDAO();
			return pedidoProdutoDAO.findItensPedido(pedidoDAO.findById(idPedido));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao listar pedidoProdutos!");
		}
	}

	public PedidoProduto findById(Integer id) throws Exception {
		try {
			return pedidoProdutoDAO.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar pedidoProduto por id!");
		}
	}

}
