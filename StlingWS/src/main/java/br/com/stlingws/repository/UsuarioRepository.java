/**
 * 
 */
package br.com.stlingws.repository;

import java.util.List;

import br.com.stlingws.dao.UsuarioDAO;
import br.com.stlingws.entity.Usuario;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class UsuarioRepository {

	private UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

	public Boolean salvar(Usuario usuario) throws Exception {
		try {
			usuarioDAO.init();
			Boolean retorno = usuarioDAO.salvar(usuario);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			usuarioDAO.rollBack();
			throw new Exception("Erro ao salvar usuario!");
		} finally {
			usuarioDAO.end();
		}
	}

	public Boolean remover(Integer id) throws Exception {
		try {
			usuarioDAO.init();
			Boolean retorno = usuarioDAO.remover(id);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			usuarioDAO.rollBack();
			throw new Exception("Erro ao remover usuario!");
		} finally {
			usuarioDAO.end();
		}
	}

	public List<Usuario> listar() throws Exception {
		try {
			return usuarioDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao listar usuarios!");
		}
	}

	public Usuario findById(Integer id) throws Exception {
		try {
			return usuarioDAO.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar usuario por id!");
		}
	}

	public Usuario findByEmail(String email) throws Exception {
		try {
			List<Usuario> listRetorno = usuarioDAO.findByEmail(email);

			if (listRetorno != null && !listRetorno.isEmpty()) {
				return listRetorno.get(0);
			}

			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar usuario por email!");
		}
	}

	public List<Usuario> listarVenderores() throws Exception {
		try {
			return usuarioDAO.listarVenderores();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao buscar vendedores!");
		}
	}

}
