/**
 * 
 */
package br.com.stlingws.repository;

import java.util.List;

import br.com.stlingws.dao.ClienteDAO;
import br.com.stlingws.entity.Cliente;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class ClienteRepository {

	private ClienteDAO clienteDAO = ClienteDAO.getInstance();

	public Boolean salvar(Cliente cliente) throws Exception {
		try {
			clienteDAO.init();
			Boolean retorno = clienteDAO.salvar(cliente);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			this.clienteDAO.rollBack();
			throw new Exception("Erro ao salvar cliente!");
		} finally {
			clienteDAO.end();
		}
	}

	public Boolean remover(Integer id) throws Exception {
		try {
			clienteDAO.init();
			Boolean retorno = clienteDAO.remover(id);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			this.clienteDAO.rollBack();
			throw new Exception("Erro ao remover cliente!");
		} finally {
			clienteDAO.end();
		}
	}

	public List<Cliente> listar() throws Exception {
		try {
			return this.clienteDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao listar clientes!");
		} 
	}

	public Cliente findById(Integer id) throws Exception {
		try {
			return this.clienteDAO.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar cliente por id!");
		} 
	}

}
