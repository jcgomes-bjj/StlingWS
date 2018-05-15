/**
 * 
 */
package br.com.stlingws.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.stlingws.dao.PedidoDAO;
import br.com.stlingws.entity.Pedido;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class PedidoRepository {

	private PedidoDAO pedidoDAO = PedidoDAO.getInstance();

	public Pedido salvar(Pedido pedido) throws Exception {
		try {

			if (pedido.getId() == null) {
				pedido.setDtCadastro(Calendar.getInstance());
				pedido.setValorTotal(BigDecimal.ZERO);
			}
			pedidoDAO.init();
			Pedido retorno = pedidoDAO.salvar(pedido);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			pedidoDAO.rollBack();
			throw new Exception("Erro ao salvar pedido!");
		} finally {
			pedidoDAO.end();
		}
	}

	public Boolean remover(Integer id) throws Exception {
		try {
			pedidoDAO.init();
			Boolean retorno = pedidoDAO.remover(id);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			pedidoDAO.rollBack();
			throw new Exception("Erro ao remover pedido!");
		} finally {
			pedidoDAO.end();
		}
	}

	public List<Pedido> listar() throws Exception {
		try {
			return pedidoDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao listar pedidos!");
		} 
	}

	public Pedido findById(Integer id) throws Exception {
		try {
			return pedidoDAO.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar pedido por id!");
		} 
	}

}
