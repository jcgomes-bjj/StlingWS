/**
 * 
 */
package br.com.stlingws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.stlingws.entity.TipoUsuario;
import br.com.stlingws.factory.EntityManagerProvider;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class TipoUsuarioDAO {

	private static TipoUsuarioDAO instance;
	private EntityManagerProvider provider = null;
	private EntityManagerFactory factory = null;
	private EntityManager entityManager = null;

	public TipoUsuarioDAO() {
		this.provider = EntityManagerProvider.getInstance();
		this.factory = provider.getFactory();
		this.entityManager = provider.createManager();
		this.entityManager.getTransaction().begin();
	}

	/**
	 * Singleton
	 * 
	 * @return instance
	 */
	public static TipoUsuarioDAO getInstance() {
		if (instance == null) {
			instance = new TipoUsuarioDAO();
		}
		return instance;
	}

	/**
	 * Buscar por id
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public TipoUsuario findById(Integer id) {
		return this.entityManager.find(TipoUsuario.class, id);
	}

	/**
	 * Listar
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TipoUsuario> listar() {
		return this.entityManager.createQuery("FROM " + TipoUsuario.class.getName()).getResultList();
	}

	/**
	 * Salvar (Insere ou Edita)
	 * 
	 * @param obj
	 */
	public Boolean salvar(TipoUsuario tipoUsuario) {
		try {
			if (tipoUsuario.getId() == null) {
				this.entityManager.persist(tipoUsuario);
			} else {
				this.entityManager.merge(tipoUsuario);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Remover
	 * 
	 * @param clazz
	 * @param id
	 */
	public Boolean remover(Integer id) {
		TipoUsuario tipoUsuarioBanco = findById(id);
		try {
			this.entityManager.remove(tipoUsuarioBanco);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void rollBack() {
		this.entityManager.getTransaction().rollback();
	}

	public void init() {
		if (!this.entityManager.getTransaction().isActive()) {
			this.entityManager.getTransaction().begin();
		}
	}

	public void end() {
		this.entityManager.getTransaction().commit();
	}

	/**
	 * @return the factory
	 */
	public EntityManagerFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the this.entityManager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * @param this.entityManager
	 *            the this.entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
