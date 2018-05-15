/**
 * 
 */
package br.com.stlingws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.stlingws.entity.Pedido;
import br.com.stlingws.factory.EntityManagerProvider;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class PedidoDAO {

	private static PedidoDAO instance;
	private EntityManagerProvider provider = null;
	private EntityManagerFactory factory = null;
	private EntityManager entityManager = null;

	public PedidoDAO() {
		this.provider = EntityManagerProvider.getInstance();
		this.factory = provider.getFactory();
		this.entityManager = provider.createManager();
	}

	/**
	 * Singleton
	 * 
	 * @return instance
	 */
	public static PedidoDAO getInstance() {
		if (instance == null) {
			instance = new PedidoDAO();
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
	public Pedido findById(Integer id) {
		return this.entityManager.find(Pedido.class, id);
	}

	/**
	 * Listar
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Pedido> listar() {
		return this.entityManager.createQuery("FROM " + Pedido.class.getName()).getResultList();
	}

	/**
	 * Salvar (Insere ou Edita)
	 * 
	 * @param obj
	 */
	public Pedido salvar(Pedido pedido) {
		try {
			if (pedido.getId() == null) {
				this.entityManager.persist(pedido);
			} else {
				this.entityManager.merge(pedido);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedido;

	}

	/**
	 * Remover
	 * 
	 * @param clazz
	 * @param id
	 */
	public Boolean remover(Integer id) {
		Pedido pedidoBanco = findById(id);
		try {
			this.entityManager.remove(pedidoBanco);
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
