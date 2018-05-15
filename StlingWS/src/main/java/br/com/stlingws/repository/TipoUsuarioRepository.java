/**
 * 
 */
package br.com.stlingws.repository;

import java.util.List;

import br.com.stlingws.dao.TipoUsuarioDAO;
import br.com.stlingws.entity.TipoUsuario;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class TipoUsuarioRepository {

	private TipoUsuarioDAO tipoUsuarioDAO = TipoUsuarioDAO.getInstance();

	public Boolean salvar(TipoUsuario tipoUsuario) throws Exception {
		try {
			tipoUsuarioDAO.init();
			Boolean retorno = tipoUsuarioDAO.salvar(tipoUsuario);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			this.tipoUsuarioDAO.rollBack();
			throw new Exception("Erro ao salvar tipoUsuario!");
		} finally {
			tipoUsuarioDAO.end();
		}
	}

	public Boolean remover(Integer id) throws Exception {
		try {
			tipoUsuarioDAO.init();
			Boolean retorno = tipoUsuarioDAO.remover(id);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			this.tipoUsuarioDAO.rollBack();
			throw new Exception("Erro ao remover tipoUsuario!");
		} finally {
			tipoUsuarioDAO.end();
		}
	}

	public List<TipoUsuario> listar() throws Exception {
		try {
			tipoUsuarioDAO.init();
			return tipoUsuarioDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao listar tipoUsuarios!");
		} finally {
			tipoUsuarioDAO.end();
		}
	}

	public TipoUsuario findById(Integer id) throws Exception {
		try {
			tipoUsuarioDAO.init();
			return tipoUsuarioDAO.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar tipoUsuario por id!");
		} finally {
			tipoUsuarioDAO.end();
		}
	}

}
