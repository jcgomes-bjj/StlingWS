/**
 * 
 */
package br.com.stlingws.repository;

import java.util.List;

import br.com.stlingws.dao.ProdutoDAO;
import br.com.stlingws.entity.Produto;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class ProdutoRepository {

	private ProdutoDAO produtoDAO = ProdutoDAO.getInstance();

	public Boolean salvar(Produto produto) throws Exception {
		try {
			produtoDAO.init();
			Boolean retorno = produtoDAO.salvar(produto);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			produtoDAO.rollBack();
			throw new Exception("Erro ao salvar produto!");
		} finally {
			produtoDAO.end();
		}
	}

	public Boolean remover(Integer id) throws Exception {
		try {
			produtoDAO.init();
			Boolean retorno = produtoDAO.remover(id);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			produtoDAO.rollBack();
			throw new Exception("Erro ao remover produto!");
		} finally {
			produtoDAO.end();
		}
	}

	public List<Produto> listar() throws Exception {
		try {
			return produtoDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao listar produtos!");
		}
	}

	public Produto findById(Integer id) throws Exception {
		try {
			return produtoDAO.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar produto por id!");
		}
	}

}
